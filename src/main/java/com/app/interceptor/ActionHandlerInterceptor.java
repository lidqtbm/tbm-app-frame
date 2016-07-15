package com.app.interceptor;

import com.app.entity.UserEntity;
import com.app.util.ConstantUtil;
import com.app.util.PageData;
import com.app.util.SessionUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lee on 2016/6/23.
 */
public class ActionHandlerInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // TODO Auto-generated method stub
        String path = request.getServletPath();

        //静态资源不拦截
        if(path.startsWith("/media/")||path.startsWith("/login")||path.startsWith("/logout")){
            return true;
        }else{
            return true;
//            PageData user  = (PageData)SessionUtil.getHttpSession().getAttribute("USER");
//            if(null != user){
//                return true;
//            }else{
//                response.sendRedirect(request.getContextPath() + ConstantUtil.LOGIN);
//                return false;
//            }
        }
    }
}
