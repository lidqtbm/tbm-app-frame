package com.app.service;

import com.app.dao.DAO;
import com.app.entity.UserEntity;
import com.app.service.manager.LoginManager;
import com.app.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lee on 2016/6/23.
 */
@Service("loginService")
public class LoginServiceImpl implements LoginManager {

    @Resource(name = "daoSupport")
    private DAO dao;
    public PageData getUserByRealPass(PageData pd) {
        PageData user =  new PageData();
        try {
            user = (PageData) dao.findForObject("UserMapper.getUserByRealPass",pd);
        } catch (Exception e) {
            e.printStackTrace();
            return new PageData();
        }
        return user;
    }
}
