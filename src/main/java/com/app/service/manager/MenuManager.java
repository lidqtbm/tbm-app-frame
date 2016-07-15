package com.app.service.manager;

import com.app.util.PageData;

import java.util.List;

/**
 * Created by lee on 2016/6/24.
 */
public interface MenuManager {

    public List<PageData> getUserMenu(PageData pd);

    public List<PageData> getMenuIDByParentID(PageData pd);
}
