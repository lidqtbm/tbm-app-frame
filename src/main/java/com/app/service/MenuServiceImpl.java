package com.app.service;

import com.app.dao.DAO;
import com.app.service.manager.MenuManager;
import com.app.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2016/6/24.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuManager {

    @Resource(name = "daoSupport")
    private DAO daoSupport;

    /**
     *
     * @param pd
     * @return
     */
    public List<PageData> getUserMenu(PageData pd) {
        List<PageData> menuList = new ArrayList<PageData>();
        try {
            menuList = (List<PageData>) daoSupport.findForList("MenuMapper.getUserMenu",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }

    public List<PageData> getMenuIDByParentID(PageData pd) {
        List<PageData> menuList = new ArrayList<PageData>();
        try {
            menuList = (List<PageData>) daoSupport.findForList("MenuMapper.getMenuIDByParentID",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuList;
    }
}
