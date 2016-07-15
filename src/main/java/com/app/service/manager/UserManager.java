package com.app.service.manager;

import com.app.util.PageData;

import java.util.List;

/**
 * Created by lee on 2016/6/29.
 */
public interface UserManager {

    public List<PageData> getUser();

    public List<PageData> getUserAndRoleInfo();

    public void insertUser(PageData pd);

    public void deleteUser(PageData pd);

    public void updateBtnRight(PageData pd);
}
