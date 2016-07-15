package com.app.entity;

/**
 * Created by lee on 2016/6/23.
 */
public class UserEntity {

    private String USER_ID;		//用户id
    private String USERNAME;	//用户名
    private String PASSWORD; 	//密码
    private String NAME;		//姓名
    private String RIGHTS;		//权限
    private String ROLE_ID;		//角色id
    private String LAST_LOGIN;	//最后登录时间
    private String IP;			//用户登录ip地址
    private String STATUS;		//状态

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getRIGHTS() {
        return RIGHTS;
    }

    public void setRIGHTS(String RIGHTS) {
        this.RIGHTS = RIGHTS;
    }

    public String getROLE_ID() {
        return ROLE_ID;
    }

    public void setROLE_ID(String ROLE_ID) {
        this.ROLE_ID = ROLE_ID;
    }

    public String getLAST_LOGIN() {
        return LAST_LOGIN;
    }

    public void setLAST_LOGIN(String LAST_LOGIN) {
        this.LAST_LOGIN = LAST_LOGIN;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
}
