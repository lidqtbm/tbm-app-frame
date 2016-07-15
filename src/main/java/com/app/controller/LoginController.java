package com.app.controller;

import com.app.controller.base.BaseController;
import com.app.service.manager.LoginManager;
import com.app.service.manager.MenuManager;
import com.app.service.manager.RoleManager;
import com.app.util.*;

import org.omg.CORBA.Object;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lee on 2016/6/23.
 * This Controller is used for login & logout
 */
@Controller
public class LoginController extends BaseController {

    @Resource(name = "loginService")
    private LoginManager loginManager;

    @Resource(name = "menuService")
    private MenuManager menuManager;

    @Resource(name = "roleService")
    private RoleManager roleManager;

    /**
     * This method is used for redirecting to Login Html
     * @return
     */
    @RequestMapping(value="/login_toLogin")
    public ModelAndView goLogin(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = ConstantUtil.getInfomationPageData();
        mv.addObject("pd",pd);
        mv.setViewName("login/login");
        return mv;
    }

    /**
     * This method is used for checking UserName & Password
     * Use Json to feedback the logining result
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/login",produces="application/json;charset=UTF-8")
    public Map<String,String> login(){
        Map<String,String> map = new HashMap<String, String>();
        PageData pd = this.getPageData();
        String result = "error";
        String realpass = MD5.md5(pd.getString("username")+"tbm"+pd.getString("password"));
        pd.put("realpass",realpass);
        PageData user = loginManager.getUserByRealPass(pd);
        if(null!=user){
            HttpSession session = this.getRequest().getSession();
            session.setAttribute("USER",user);
            result = "success";
        }
        map.put("result",result);
        return map;
    }
    /**
     * If Yes ,redirecting to Main Html
     * @return
     */
    @RequestMapping(value = "/login_index")
    public ModelAndView getMainIndex(){
        ModelAndView mv = this.getModelAndView();
        HttpSession session = this.getRequest().getSession();
        PageData pd = (PageData) session.getAttribute("USER");
        //获取所有menu数据
        List<PageData> menu = (List<PageData>) menuManager.getUserMenu(pd);
        //获取Role_Id
        String roleID = pd.getString("ROLE_ID");
        pd.put("ROLE_ID",roleID);
        //通过Role_id获取菜单权限
        String rights = roleManager.getRightsByRoleID(pd).getString("RIGHTS");
        session.setAttribute("RIGHTS",rights);
        //此用户所拥有的目录权限ownerRole包含了所有的此用户含有的权限
        List<PageData> ownerRole = new ArrayList<PageData>();
        //根目录
//        List<PageData> parentID_0 = new ArrayList<PageData>();
        //通过rights权限码，确定此role包含的权限、并且确定此目录的所有根目录(parent_id==0),和非根目录(parent_id!=0)
        for(PageData local : menu){
            int mu = (Integer) local.get("MENU_ID");
            boolean flag = RightsHelper.testRights(rights,mu);
            if(flag){
                ownerRole.add(local);
//                if(local.getString("PARENT_ID").equals("0")){
//                    parentID_0.add(local);
//                }
            }
        }
        //通过根目录，获取菜单树形图
        List<PageData> menuResult = new ArrayList<PageData>();
        menuResult = new MenuUtil().getTreeMenu(ownerRole,menuManager);

        PageData infoPageData = ConstantUtil.getInfomationPageData();
        //通过session，保存menu信息
        //start init
        session.setAttribute("PD",pd);

        mv.setViewName("index");
        mv.addObject("pd",infoPageData);
        mv.addObject("menu",menuResult);
        return mv;
    }

    /**
     * LogOut
     * @return
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout(){
        ModelAndView mv = this.getModelAndView();
        //清除所有session
        HttpSession session = this.getRequest().getSession();
        session.removeAttribute("USER");
        session.removeAttribute("PD");
        session.removeAttribute("MENURESULT");
        session.removeAttribute("RIGHTS");
        session.invalidate();

        PageData pd = ConstantUtil.getInfomationPageData();
        mv.addObject("pd",pd);
        mv.setViewName("login/login");
        return mv;
    }

    @RequestMapping(value = "/showMain")
    public ModelAndView showMain(){
        ModelAndView mv = this.getModelAndView();
        mv.addObject("pd",ConstantUtil.getInfomationPageData());
        mv.setViewName("main");
        return mv;
    }
}
