package com.app.service;

import com.app.dao.DAO;
import com.app.service.manager.RoleManager;
import com.app.util.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2016/6/24.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleManager {


    @Resource(name = "daoSupport")
    private DAO daoSupport;

    /**
     *
     * @param pd
     * @return
     */
    public PageData getRoleByRoleID(PageData pd) {
        PageData rolePD = new PageData();
        try {
            rolePD = (PageData) daoSupport.findForObject("RoleMapper.getRoleByRoleID",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rolePD;
    }

    /**
     *
     * @param pd
     * @return
     */
    public PageData getRightsByRoleID(PageData pd) {
        PageData result = new PageData();
        try {
            result = (PageData) daoSupport.findForObject("RoleMapper.getRightsByRoleID",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<PageData> getRoles() {
        List<PageData> rolesList = new ArrayList<PageData>();
        try {
            rolesList = (List<PageData>) daoSupport.findForList("RoleMapper.getRoles",null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rolesList;
    }

    public PageData checkRoleName(PageData pd) {
        PageData checkResult = new PageData();
        try {
            checkResult = (PageData) daoSupport.findForObject("RoleMapper.checkRoleName",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return checkResult;
    }

    public void addRoleName(PageData pd) {
        try {
            daoSupport.save("RoleMapper.addRoleName",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRole(PageData pd) {
        try {
            daoSupport.delete("RoleMapper.deleteRoles",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoles(PageData pd) {
        try {
            daoSupport.update("RoleMapper.updateRoles",pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
