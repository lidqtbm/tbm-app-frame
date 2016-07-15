package com.app.util;

/**
 * Created by lee on 2016/6/23.
 */
public class ConstantUtil {

    public static String LOGIN = "/login_toLogin.do";

    public static PageData getInfomationPageData(){

        PageData pd = new PageData();

        pd.put("TITLE","TBM-APP|Frame");
        pd.put("FORM_TITLE","输入用户名和密码登录");
        pd.put("HIDE_ALERT","用户名和密码不匹配");
        pd.put("FORM_USER","请输入账户");
        pd.put("FORM_PASS","请输入密码");
        pd.put("FORM_REMEMBER","记住此账户");
        pd.put("FORM_LOGIN","登录");
        pd.put("FORM_USER_NULL","账户名称不能为空");
        pd.put("FORM_PASS_NULL","账户密码不能为空");

        pd.put("TITLE","TBM-APP|Frame");
        pd.put("DASHBOARD","工作仪表盘");

        //header
        pd.put("LOGOUT","退出");
        pd.put("DEFINE","请选择开始日期");
        pd.put("DETAIL","展示数据和其他");
        pd.put("START","开始");
        pd.put("KPI","系统KPI");

        pd.put("HOME","首页");
        pd.put("SUBTITLE","工作KPI展示");


        pd.put("TOOLS","快捷工具");
        pd.put("PRINT","打印");
        pd.put("PDF","保存为PDF");
        pd.put("EXCEL","保存为EXCEL");
        pd.put("INDEX","编号");
        pd.put("DELETE","删除");
        pd.put("CLOSE","取消");
        pd.put("CONFIRM","确定");
        pd.put("DELETE_TITLE","删除界面");
        pd.put("DELETE_CONFIRM","你确定要删除");


        //role surface
        pd.put("ROLE_TITLE","角色界面");
        pd.put("ROLE_SUBTITLE","操作界面");
        pd.put("ROLE_ADD","新增角色");
        pd.put("ROLE_NAME","编号");

        pd.put("ROLE_UPDATE","修改");
        pd.put("ROLE_ASSIGNMENT","权限分配界面");

        //user surface
        pd.put("USER_TITLE","用户界面");
        pd.put("USER_SUBTITLE","操作界面");
        pd.put("USER_LOGINAME","用户名");
        pd.put("USER_EMAIL","电邮");
        pd.put("USER_CREATE","分配新建权限");
        pd.put("USER_UPDATE","分配修改权限");
        pd.put("USER_DELETE","分配删除权限");
        pd.put("USER_ADD","新增用户");
        pd.put("USER_ASSIGNMENT","权限分配界面");


        return pd;
    }

}
