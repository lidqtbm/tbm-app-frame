package com.app.controller;

import com.app.controller.base.BaseController;
import com.app.entity.UserEntity;
import com.app.service.manager.RoleManager;
import com.app.service.manager.UserManager;
import com.app.util.ConstantUtil;
import com.app.util.PageData;

import com.app.util.RightsHelper;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;


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
        HttpSession session = this.getRequest().getSession();
        PageData user = (PageData) session.getAttribute("USER");
        PageData userPageData = userManager.getUserCUDByID(user);

        String createRights = userPageData.getString("CREATERIGHT");
        String updateRights = userPageData.getString("UPDATERIGHT");
        String deleteRights = userPageData.getString("DELETERIGHT");

        String createFlag = RightsHelper.testRights(createRights,2)?"1":"0";
        String updateFlag = RightsHelper.testRights(updateRights,2)?"1":"0";
        String deleteFlag = RightsHelper.testRights(deleteRights,2)?"1":"0";

        PageData button = this.getPageData();
        String menuUrl = button.getString("MENU_URL");
        button.put("CREATERIGHT",createRights);
        button.put("UPDATERIGHT",updateRights);
        button.put("DELETERIGHT",deleteRights);

        mv.addObject("button",button);
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
