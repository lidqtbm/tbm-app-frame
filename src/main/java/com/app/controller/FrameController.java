package com.app.controller;

import com.app.controller.base.BaseController;
import com.app.service.manager.RoleManager;
import com.app.service.manager.UserManager;
import com.app.util.ConstantUtil;
import com.app.util.PageData;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统管理 控制器
 *
 * Created by lee on 2016/6/27.
 */
@Controller
public class FrameController extends BaseController {

    @Resource(name = "userService")
    private UserManager userManager;

    @Resource(name = "roleService")
    private RoleManager roleManager;

    /**
     * This method is used for redirecting to Template
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/frame_template",produces="application/json;charset=UTF-8")
    public ModelAndView login(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = (PageData) this.getRequest().getSession().getAttribute("PD");
        mv.addObject("pd",pd);
        mv.setViewName("blank_page");
        return mv;
    }

    /**
     * This method is used for redirecting to Table Role
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/frame_role" ,produces = "application/json;chartset=UTF-8")
    public ModelAndView frameRole(){
        ModelAndView mv = this.getModelAndView();
        List<PageData> rolesList = roleManager.getRoles();
        mv.addObject("rolesList",rolesList);
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        mv.setViewName("frame_role");
        return mv;
    }

    /**
     * This method is used for redirecting to Table User
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/frame_user" ,produces = "application/json;chartset=UTF-8")
    public ModelAndView frameUser(){
        ModelAndView mv = this.getModelAndView();

        List<PageData> userListPageData = userManager.getUserAndRoleInfo();
        mv.addObject("pd",ConstantUtil.getInfomationPageData());
        mv.addObject("userlist",userListPageData);
        mv.setViewName("frame_user");
        return mv;
    }

    /**
     * This method is used for redirecting to Table Button
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/frame_button",produces="application/json;charset=UTF-8")
    public ModelAndView frameButton(){
        ModelAndView mv = this.getModelAndView();
        mv.setViewName("blank_page");
        return mv;
    }

    /**
     * This method is used for redirecting to Table Button
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/frame_tab",produces="application/json;charset=UTF-8")
    public ModelAndView frameTab(){
        ModelAndView mv = this.getModelAndView();
        mv.addObject("pd",ConstantUtil.getInfomationPageData());
        mv.setViewName("main");
        return mv;
    }




}
