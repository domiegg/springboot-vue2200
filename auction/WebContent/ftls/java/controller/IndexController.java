/**
 *
 */
package com.ognice.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ognice.domain.User;
import com.ognice.service.IMenuService;
import com.ognice.service.IUserService;

/**
 *
 *
 * <br>
 * ========================== <br>
 * 开发：952396697@qq.com <br>
 * 版本：1.0 <br>
 * 创建时间：2016年11月25日 <br>
 * ==========================
 */
@Controller
public class IndexController {
    @Resource
    private IUserService userservice;

    @Resource
    private IMenuService menuservice;

    /**
     *
     */
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "admin/demo";
    }

    /**
    *
    */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "admin/index";
    }

    /**
    *
    */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String preindex(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "pre/login";
    }

    /**
    *
    */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("u");
        String psw = request.getParameter("p");
        User u = userservice.login(username, psw);
        if (null == u) {            request.setAttribute("msg", "账号或密码错误");

            return "admin/login";

        }
        if (u.getStatus().equals(1)) {
            request.setAttribute("msg", "账号已禁用");
            return "admin/login";

        }
        request.getSession().setAttribute("loginUser", u);

        return "redirect:/admin";
    }

    /**
    *
    */
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "pre/index";
    }

    /**
    *
    */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("loginUser");
        return "redirect:/admin";
    }
    /**
    *
    */
    @RequestMapping(value = "/index/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("indexUser");
        return "redirect:/index";
    }

     /**
     *
     */
     @RequestMapping(value = "/index/login")
     public String indexlogin(HttpServletRequest request, HttpServletResponse
     response) {
     String username = request.getParameter("username");
     String psw = request.getParameter("password");
     Preuser u = preuserservice.login(username, psw);
     if (null == u) {
     request.setAttribute("msg", "账号或密码不存在");
     return "pre/login";
    
     }
     request.getSession().setAttribute("indexUser", u);
    
     return "redirect:/index";
     }

}
