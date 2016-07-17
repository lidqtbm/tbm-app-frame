package com.app.util;

import com.app.service.manager.MenuManager;
import javafx.beans.binding.IntegerBinding;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lee on 2016/6/29.
 */
public class MenuUtil {
    /**
     * 通过根目录，获取菜单树形图
     * @param menu
     * @return
     */

    public List<PageData> initMenu(List<PageData> menu,MenuManager menuManager){
        List<PageData> menuResult = new ArrayList<PageData>();
        for(PageData parentPageData : menu){
            List<PageData> firstSubMenu = menuManager.getMenuIDByParentID(parentPageData);
            parentPageData.put("firstSubMenu",firstSubMenu);
            menuResult.add(parentPageData);
            for(PageData subPageData : firstSubMenu){
                List<PageData> secondSubMenu = menuManager.getMenuIDByParentID(subPageData);
                subPageData.put("secondSubMenu",secondSubMenu);
                menuResult.add(subPageData);
                for(PageData subSubPageData : secondSubMenu){
                    List<PageData> thirdSubMenu = menuManager.getMenuIDByParentID(subSubPageData);
                    subSubPageData.put("thirdSubMenu",thirdSubMenu);
                    menuResult.add(subSubPageData);
                    if(0!=thirdSubMenu.size()){
                        menuResult.addAll(thirdSubMenu);
                    }
                }
            }
        }
        return menuResult;
    }

    private List<PageData> checkOwnerMenu(List<PageData> subMenu,List<PageData> ownerMenu){
        List<PageData> list = new ArrayList<PageData>();
        List<Integer> idList = new ArrayList<Integer>();
        for(PageData pageData : ownerMenu){
            idList.add((Integer)pageData.get("MENU_ID"));
        }
        for(PageData pageData : subMenu){
            Integer id = (Integer) pageData.get("MENU_ID");
            if(idList.contains(id)){
                list.add(pageData);
            }
        }
        return list;
    }

    public List<PageData> getTreeMenu(List<PageData> menu,List<PageData> parentID,MenuManager menuManager){
        List<PageData> menuResult = new ArrayList<PageData>();
        for(PageData parentPageData : parentID){
            List<PageData> firstSubMenu = menuManager.getMenuIDByParentID(parentPageData);
            //添加一级菜单
            parentPageData.put("firstSubMenu",this.checkOwnerMenu(firstSubMenu,menu));
            menuResult.add(parentPageData);
            for(PageData subPageData : firstSubMenu){
                List<PageData> secondSubMenu = menuManager.getMenuIDByParentID(subPageData);
                //添加二级菜单
                subPageData.put("secondSubMenu",this.checkOwnerMenu(secondSubMenu,menu));
                menuResult.add(subPageData);
                for(PageData subSubPageData : secondSubMenu){
                    List<PageData> thirdSubMenu = menuManager.getMenuIDByParentID(subSubPageData);
                    //添加三级菜单
                    subSubPageData.put("thirdSubMenu",this.checkOwnerMenu(thirdSubMenu,menu));
                    menuResult.add(subSubPageData);
                    if(0!=thirdSubMenu.size()){
                        menuResult.addAll(thirdSubMenu);
                    }
                }
            }
        }
//        for(PageData test : menuResult){
//            if(test.getString("PARENT_ID").equals("0")){
//                System.out.println(test.getString("MENU_NAME"));
//                List<PageData> firstSubMenu = (List<PageData>) test.get("firstSubMenu");
//                for(PageData subPageData : firstSubMenu){
//                    System.out.println("  "+subPageData.getString("MENU_NAME"));
//                    List<PageData> secondSubMenu = (List<PageData>) subPageData.get("secondSubMenu");
//                    for(PageData subSubPageData : secondSubMenu){
//                        System.out.println("    "+subSubPageData.getString("MENU_NAME"));
//                        List<PageData> thirdSubMenu = (List<PageData>) subSubPageData.get("thirdSubMenu");
//                        for(PageData fourthSubMenu : thirdSubMenu){
//                            System.out.println("      "+fourthSubMenu.getString("MENU_NAME"));
//                        }
//                    }
//                }
//            }
//        }
        return menuResult;
    }
}
