package com.app.util;

import com.app.service.manager.MenuManager;
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
    public List<PageData> getTreeMenu(List<PageData> menu,MenuManager menuManager){
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
