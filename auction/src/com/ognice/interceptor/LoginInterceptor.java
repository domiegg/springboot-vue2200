package com.ognice.interceptor;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ognice.domain.Menu;
import com.ognice.domain.Preuser;
import com.ognice.domain.User;
import com.ognice.service.IMenuService;

public class LoginInterceptor implements HandlerInterceptor {
    public static final Logger log = Logger.getLogger(LoginInterceptor.class);
    @Resource
    private IMenuService menuservice;

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception err) throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        if (request.getServletPath().contains("index") || request.getServletPath().equals("/") || request.getServletPath().contains("login")
                || request.getServletPath().contains("swagger") || request.getServletPath().contains("v2/api-docs")) {
            return true;
        }
        if (request.getServletPath().contains("index")) {
            Preuser user = (Preuser) request.getSession().getAttribute("indexUser");
            log.debug("前台登陆拦截..." + request.getServletPath());
            if (user != null) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/");
            }
        } else {
            User user = (User) request.getSession().getAttribute("loginUser");
            log.debug("登陆拦截..." + request.getServletPath());
            if (user != null) {
                String[] urls = request.getServletPath().split("/");
                request.setAttribute("url", request.getServletPath());
                request.setAttribute("urlmain", urls.length >= 1 ? urls[1] : urls[0]);
                List<Menu> menus = menuservice.getAllMain();
                for (Menu menu : menus) {
                    menu.setChilds(menuservice.getChild(menu.getId()));
                }
                request.setAttribute("menu", menus);
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
        }
        return false;
    }

}
