package com.app.service.manager;

import com.app.util.PageData;

import java.util.List;

/**
 * Created by lee on 2016/6/24.
 */
public interface RoleManager {

    public PageData getRoleByRoleID(PageData pd);

    public PageData getRightsByRoleID(PageData pd);

    public List<PageData> getRoles();

    public PageData checkRoleName(PageData pd);

    public void addRoleName(PageData pd);

    public void deleteRole(PageData pd);

    public void updateRoles(PageData pd);
}