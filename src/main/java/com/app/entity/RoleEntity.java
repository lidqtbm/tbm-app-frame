package com.app.entity;

/**
 * Created by lee on 2016/6/24.
 */
public class RoleEntity {

    private String roleID;
    private String roleName;
    private String rights;
    private String parentID;
    private String addQX;
    private String delQX;
    private String editQX;
    private String chaQX;

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getAddQX() {
        return addQX;
    }

    public void setAddQX(String addQX) {
        this.addQX = addQX;
    }

    public String getDelQX() {
        return delQX;
    }

    public void setDelQX(String delQX) {
        this.delQX = delQX;
    }

    public String getEditQX() {
        return editQX;
    }

    public void setEditQX(String editQX) {
        this.editQX = editQX;
    }

    public String getChaQX() {
        return chaQX;
    }

    public void setChaQX(String chaQX) {
        this.chaQX = chaQX;
    }
}
