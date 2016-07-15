package com.app.service;

import com.app.dao.DAO;
import com.app.service.manager.UserManager;
import com.app.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2016/6/29.
 */
@Service("userService")
public class UserServiceImpl implements UserManager {

    @Resource(name = "daoSupport")
    private DAO daoSupport;

    public List<PageData> getUser() {
        List<PageData> userList = new ArrayList<PageData>();
        try {
            userList = (List<PageData>) daoSupport.findForList("UserMapper.getUser",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    public List<PageData> getUserAndRoleInfo() {
        List<PageData> userRoleList = new ArrayList<PageData>();
        try {
            userRoleList = (List<PageData>) daoSupport.findForList("UserMapper.getUserAndRoleInfo",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRoleList;
    }

    public void insertUser(PageData pd) {
        try {
            daoSupport.save("UserMapper.insertUser",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(PageData pd) {
        try {
            daoSupport.delete("UserMapper.deleteUser",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateBtnRight(PageData pd) {
        try {
            daoSupport.update("UserMapper.updateBtnRight",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
