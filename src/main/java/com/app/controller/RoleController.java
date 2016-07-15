package com.app.controller;

import com.app.controller.base.BaseController;
import com.app.service.manager.RoleManager;
import com.app.util.ConstantUtil;
import com.app.util.PageData;
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
 * This Controller is used for Role Management Surface
 */
@Controller
public class RoleController extends BaseController {

    @Resource(name = "roleService")
    private RoleManager roleManager;

    /**
     * System Administrator
     * Role Management --- Create
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRole" , produces = "application/json;charset=UTF-8")
    public ModelAndView addRole(){
        ModelAndView mv = this.getModelAndView();
        Map<String,Object> map = new HashMap<String, Object>();
        PageData pd = this.getPageData();
        pd.put("ROLE_NAME",pd.getString("addRoleName"));
        pd.put("RIGHTS","");
        pd.put("ADD_QX","");
        pd.put("DEL_QX","");
        pd.put("EDIT_QX","");
        pd.put("CHA_QX","");
        roleManager.addRoleName(pd);
        List<PageData> rolesList = roleManager.getRoles();
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        mv.addObject("rolesList",rolesList);
        mv.setViewName("ajax/role_table");
        return mv;
    }

    /**
     * System Administrator
     * Role Management --- Delete
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRole", produces = "application/json;charset=UTF-8")
    public ModelAndView deleteRole(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = this.getPageData();
        pd.put("roleName",pd.get("roleName"));
        roleManager.deleteRole(pd);
        List<PageData> rolesList = roleManager.getRoles();
        mv.addObject("pd", ConstantUtil.getInfomationPageData());
        mv.addObject("rolesList",rolesList);
        mv.setViewName("ajax/role_table");
        return mv;
    }

}
