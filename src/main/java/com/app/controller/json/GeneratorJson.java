package com.app.controller.json;

import com.app.controller.base.BaseController;
import com.app.service.manager.MenuManager;
import com.app.service.manager.RoleManager;
import com.app.service.manager.UserManager;
import com.app.util.ConstantUtil;
import com.app.util.MenuUtil;
import com.app.util.PageData;
import com.app.util.RightsHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lee on 2016/6/23.
 */
@Controller
public class GeneratorJson  extends BaseController{

    @Resource(name = "menuService")
    private MenuManager menuManager;

    @Resource(name = "roleService")
    private RoleManager roleManager;

    @Resource(name = "userService")
    private UserManager userManager;


    @ResponseBody
    @RequestMapping(value = "/initMenu" , produces = "application/json;charset=UTF-8")
    public Map<String,List<PageData>> initMenu(){
        Map<String,List<PageData>> map = new HashMap<String, List<PageData>>();
        PageData pd = this.getPageData();
        pd.put("MENU_ID","0");
        List<PageData> allMenu = menuManager.getMenuIDByParentID(pd);
        List<PageData> result = new ArrayList<PageData>();
        result = new MenuUtil().initMenu(allMenu,menuManager);
        List<PageData> nodes = new ArrayList<PageData>();
        for(PageData tPageData : result ){
            if(tPageData.getString("PARENT_ID").equals("0")){
                int mu = (Integer)tPageData.get("MENU_ID");
                PageData parentPD = new PageData();
                parentPD.put("id",mu);
                parentPD.put("pId",tPageData.getString("PARENT_ID"));
                parentPD.put("name",tPageData.getString("MENU_NAME"));
                nodes.add(parentPD);
                List<PageData> firstSubMenu = (List<PageData>) tPageData.get("firstSubMenu");
                for(PageData subPageData : firstSubMenu){
                    PageData firstPD = new PageData();
                    int submu = (Integer)tPageData.get("MENU_ID");
                    firstPD.put("id",(Integer)subPageData.get("MENU_ID"));
                    firstPD.put("pId",subPageData.getString("PARENT_ID"));
                    firstPD.put("name",subPageData.getString("MENU_NAME"));
                    nodes.add(firstPD);
                    List<PageData> secondSubMenu = (List<PageData>) subPageData.get("secondSubMenu");
                    for(PageData subSubPageData : secondSubMenu){
                        PageData secondPD = new PageData();
                        int secsubmu = (Integer)tPageData.get("MENU_ID");
                        secondPD.put("id",(Integer)subSubPageData.get("MENU_ID"));
                        secondPD.put("pId",subSubPageData.getString("PARENT_ID"));
                        secondPD.put("name",subSubPageData.getString("MENU_NAME"));
                        nodes.add(secondPD);
                        List<PageData> thirdSubMenu = (List<PageData>) subSubPageData.get("thirdSubMenu");
                        for(PageData fourthSubMenu : thirdSubMenu){
                            PageData thirdPD = new PageData();
                            int thirdsubmu = (Integer)tPageData.get("MENU_ID");
                            thirdPD.put("id",(Integer)fourthSubMenu.get("MENU_ID"));
                            thirdPD.put("pId",fourthSubMenu.getString("PARENT_ID"));
                            thirdPD.put("name",fourthSubMenu.getString("MENU_NAME"));
                            nodes.add(thirdPD);
                        }
                    }
                }
            }
        }
        map.put("nodes",nodes);
        return map;
    }

    /**
     * 获取所有的menu,并且按照zTree树形图展示出来
     * @return map
     */
    @ResponseBody
    @RequestMapping(value = "/getMenu",produces="application/json;charset=UTF-8")
    public Map<String,List<PageData>> getMenu(){
        Map<String,List<PageData>> map = new HashMap<String, List<PageData>>();
        PageData pd = this.getPageData();
        pd.put("MENU_ID","0");
        List<PageData> allMenu = menuManager.getMenuIDByParentID(pd);
        List<PageData> result = new ArrayList<PageData>();
        result = new MenuUtil().initMenu(allMenu,menuManager);
        String rights = pd.getString("rights");
        List<PageData> nodes = new ArrayList<PageData>();
        for(PageData tPageData : result ){
            if(tPageData.getString("PARENT_ID").equals("0")){
                int mu = (Integer)tPageData.get("MENU_ID");
                PageData parentPD = new PageData();
                parentPD.put("id",mu);
                parentPD.put("pId",tPageData.getString("PARENT_ID"));
                parentPD.put("name",tPageData.getString("MENU_NAME"));
                nodes.add(parentPD);
                List<PageData> firstSubMenu = (List<PageData>) tPageData.get("firstSubMenu");
                for(PageData subPageData : firstSubMenu){
                    PageData firstPD = new PageData();
                    firstPD.put("id",(Integer)subPageData.get("MENU_ID"));
                    firstPD.put("pId",subPageData.getString("PARENT_ID"));
                    firstPD.put("name",subPageData.getString("MENU_NAME"));
                    List<PageData> secondSubMenu = (List<PageData>) subPageData.get("secondSubMenu");
                    boolean subflag = RightsHelper.testRights(rights,(Integer)subPageData.get("MENU_ID"));
                    if(0 == secondSubMenu.size()&&subflag){
                        firstPD.put("checked","true");
                    }
                    nodes.add(firstPD);
                    for(PageData subSubPageData : secondSubMenu){
                        PageData secondPD = new PageData();
                        secondPD.put("id",(Integer)subSubPageData.get("MENU_ID"));
                        secondPD.put("pId",subSubPageData.getString("PARENT_ID"));
                        secondPD.put("name",subSubPageData.getString("MENU_NAME"));
                        List<PageData> thirdSubMenu = (List<PageData>) subSubPageData.get("thirdSubMenu");
                        boolean secsubflag = RightsHelper.testRights(rights,(Integer)subSubPageData.get("MENU_ID"));
                        if(0 == thirdSubMenu.size()&&secsubflag){
                            secondPD.put("checked","true");
                        }
                        nodes.add(secondPD);
                        for(PageData fourthSubMenu : thirdSubMenu){
                            PageData thirdPD = new PageData();
                            thirdPD.put("id",(Integer)fourthSubMenu.get("MENU_ID"));
                            thirdPD.put("pId",fourthSubMenu.getString("PARENT_ID"));
                            thirdPD.put("name",fourthSubMenu.getString("MENU_NAME"));
                            boolean thirdsubflag = RightsHelper.testRights(rights,(Integer)fourthSubMenu.get("MENU_ID"));
                            if(thirdsubflag){
                                thirdPD.put("checked","true");
                            }
                            nodes.add(thirdPD);
                        }
                    }
                }
            }
        }
        map.put("nodes",nodes);
        return map;
    }
    /**
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/saveRights",produces = "application/json;charset=UTF-8")
    public ModelAndView getNewRights(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        String checkCount= pd.getString("checkCount");
        String[] roleId = checkCount.split(",");
        BigInteger right = RightsHelper.sumRights(roleId);
        pd.put("rights",right);
        pd.put("rightRole",pd.getString("rightRole"));
        roleManager.updateRoles(pd);
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        mv.addObject("rolesList",roleManager.getRoles());
        mv.setViewName("ajax/role_table");
        mv.addObject("result",right);
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/checkRoleName" , produces = "application/json;charset=UTF-8")
    public Map<String , Object> checkRoleName(){
        Map<String,Object> map = new HashMap<String, Object>();
        PageData pd = this.getPageData();
        String roalName = pd.getString("addRoleName");
        PageData resultPd = roleManager.checkRoleName(pd);
        Long result = (Long)resultPd.get("RESULT");
        String checkRoleResult = "";
        if(0==result){
            checkRoleResult = "yes";
        }else{
            checkRoleResult = "no";
        }

        map.put("result",checkRoleResult);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/refresh" , produces = "application/json;charset=UTF-8")
    public ModelAndView refresh(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        String refreshType = pd.getString("refreshType");
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        if("role".equals(refreshType)){
            mv.addObject("rolesList",roleManager.getRoles());
            mv.setViewName("ajax/role_table");
        }else if("user".equals(refreshType)){
            mv.addObject("userlist",userManager.getUserAndRoleInfo());
            mv.setViewName("ajax/user_table");
        }
        return mv;
    }

}
