/**
 *
 */
package com.ognice.controller;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ognice.controller.common.PageResult;
import com.ognice.controller.common.PageSearchParam;
import com.ognice.domain.Preuser;
import com.ognice.domain.Product;
import com.ognice.domain.User;
import com.ognice.service.ICateService;
import com.ognice.service.IMenuService;
import com.ognice.service.IPreuserService;
import com.ognice.service.IProductService;
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
    private IPreuserService preuserservice;
    @Resource
    private IProductService productService;
    @Resource
    private ICateService cateService;

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
     * 上传
     */
    @ResponseBody
    @RequestMapping(value = "/index/upload2", method = RequestMethod.POST)
    public String upload2(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        String url = "";

        try {

            String staticPath = request.getSession().getServletContext().getRealPath("static/imgs/");
            String fileName = new Date().getTime() + ".jpg";
            File targetFile = new File(staticPath, fileName);
            file.transferTo(targetFile);
            url = "http://localhost:" + request.getLocalPort() + request.getSession().getServletContext().getContextPath() + "/static/imgs/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;

    }

    /**
    *
    */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String preindex(ModelMap model, Product searchParam, Integer page, Integer pageSize) {
        searchParam.setStatus(1);
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);

        pageSearch.setParams(searchParam);
        PageResult pageResult = productService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("cates", cateService.all());
        return "pre/index";
    }

    /**
    *
    */
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("u");
        String psw = request.getParameter("p");
        User u = userservice.login(username, psw);
        if (null == u) {
            request.setAttribute("msg", "账号或密码错误");

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
    public String index(HttpServletRequest request, Product searchParam, HttpServletResponse response, ModelMap model, Integer page, Integer pageSize) {

        searchParam.setStatus(1);
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);

        pageSearch.setParams(searchParam);
        PageResult pageResult = productService.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        model.addAttribute("cates", cateService.all());
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
    public String logout2(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("indexUser");
        return "redirect:/index";
    }

    /**
    *
    */
    @RequestMapping(value = "/index/login")
    public String indexlogin(HttpServletRequest request, HttpServletResponse response) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            String username = request.getParameter("username");
            String psw = request.getParameter("password");
            Preuser u = preuserservice.login(username, psw);
            if (null == u) {
                request.setAttribute("msg", "账号或密码不存在");
                return "pre/login";

            }
            request.getSession().setAttribute("indexUser", u);

            return "redirect:/index";
        } else {
            return "pre/login";
        }
    }

    @RequestMapping(value = "/index/reg", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, Preuser u, ModelMap model, String repassword) {
        if ("post".equals(request.getMethod().toLowerCase())) {
            if (!u.getPassword().equals(repassword)) {
                model.addAttribute("msg", "密码不一致");
                return "pre/login";

            }
            String msg = preuserservice.save(u);

            Preuser u2 = preuserservice.login(u.getUsername(), u.getPassword());
            request.getSession().setAttribute("indexUser", u2);
            if (msg.equals("添加成功")) {
                return "redirect:/";
            }
            model.addAttribute("msg", msg);
        }
        return "pre/login";
    }

}
