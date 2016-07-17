package com.app.controller;

import com.app.controller.base.BaseController;
import com.app.service.manager.UserManager;
import com.app.util.ConstantUtil;
import com.app.util.PageData;
import com.app.util.RightsHelper;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lee on 2016/7/11.
 * This Controller is used for User Management Surface
 */
@Controller
public class UserController extends BaseController {

    @Resource(name = "userService")
    private UserManager userManager;
    /**
     * System Administrator
     * User Management --- Create
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser",produces = "application/json;charset=UTF-8")
    public ModelAndView addUser(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("loginname","testAjax");
        pd.put("inputname","testAjax");
        pd.put("email","testAjax@qq.com");
        pd.put("rolename","1");
        userManager.insertUser(pd);
        List<PageData> userListPageData = userManager.getUserAndRoleInfo();
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        mv.addObject("userlist",userListPageData);
        mv.setViewName("ajax/user_table");
        return mv;
    }
    /**
     * System Administrator
     * User Management --- Delete
      * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteUser",produces = "application/json;charset=UTF-8")
    public ModelAndView deleteUser(){
        ModelAndView mv = this.getModelAndView();
        Map<String,Object> map = new HashMap<String, Object>();
        PageData pageData = this.getPageData();
        userManager.deleteUser(pageData);
        List<PageData> userListPageData = userManager.getUserAndRoleInfo();
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        mv.addObject("userlist",userListPageData);
        mv.setViewName("ajax/user_table");
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/btnSaveRights" , produces = "application/json;charset=UTF-8")
    public ModelAndView saveBtnRights(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        String righsArray [] = pd.getString("right").split("@");
        String rightCode = RightsHelper.sumRights(righsArray).toString();
        pd.put("rightCode",rightCode);
        userManager.updateBtnRight(pd);
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        mv.addObject("userlist",userManager.getUserAndRoleInfo());
        mv.setViewName("ajax/user_table");
        return mv;
    }
}
