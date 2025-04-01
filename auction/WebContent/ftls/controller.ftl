package ${bean.beanPagesPath}.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ${bean.beanPagesPath}.controller.common.JsonResult;
import ${bean.beanPagesPath}.controller.common.PageResult;
import ${bean.beanPagesPath}.controller.common.PageSearchParam;
import ${bean.beanPagesPath}.domain.${bean.name?cap_first };
import ${bean.beanPagesPath}.service.I${bean.name?cap_first }Service;
import java.util.Date;
/**
 * @author ${annotation.authorName}(${annotation.authorMail})<br>
 * @date ${annotation.date}
 * ${bean.comment} controller
 * @version ${annotation.version}
 */
@Controller
@RequestMapping(value = "/${bean.name?uncap_first}", method = RequestMethod.GET)
public class ${bean.name?cap_first }Controller {
    @Resource
    private I${bean.name?cap_first }Service ${bean.name?uncap_first}Service;

    /**
     *列表
     */
    @RequestMapping(value = "", method = { RequestMethod.GET, RequestMethod.POST })
    public String index(ModelMap model, ${bean.name?cap_first } searchParam, Integer page, Integer pageSize) {
        PageSearchParam pageSearch = new PageSearchParam();
        pageSearch.setPage(page == null ? 1 : page);
        pageSearch.setPagesize(pageSize == null ? 20 : pageSize);
        pageSearch.setParams(searchParam);
        PageResult pageResult = ${bean.name?uncap_first}Service.getPages(pageSearch);
        model.addAttribute("datas", pageResult);
        return "admin/${bean.name?uncap_first}/page";
    }
	//新增
    @RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
    public String add(HttpServletRequest request, ${bean.name?cap_first } record, ModelMap model) {
        if ("post".equals(request.getMethod().toLowerCase())) {
        record.setCreated(new Date());
            String msg = ${bean.name?uncap_first}Service.save(record);
            if (msg.equals("添加成功")) {
                return "redirect:/${bean.name?uncap_first}";
            }
            model.addAttribute("msg", msg);
        }
        return "admin/${bean.name?uncap_first}/form";
    }
	//查看
    @RequestMapping(value = "/view")
    public String view(ModelMap model,Long id) {
    	${bean.name?cap_first} record = ${bean.name?uncap_first}Service.get${bean.name?cap_first}ById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", false);
        return "admin/${bean.name?uncap_first}/form";
    }
	//编辑
    @RequestMapping(value = "/edit")
    public String edit(ModelMap model,Long id) {
    	${bean.name?cap_first} record = ${bean.name?uncap_first}Service.get${bean.name?cap_first}ById(id);
		model.addAttribute("record", record);
		model.addAttribute("edit", true);
        return "admin/${bean.name?uncap_first}/form";
    }
    //更新
    @RequestMapping(value = "/update",method = { RequestMethod.GET, RequestMethod.POST })
    public String update(HttpServletRequest request, ${bean.name?cap_first } record, ModelMap model) {
    	${bean.name?uncap_first}Service.update(record);
        return "redirect:/${bean.name?uncap_first}";
    }
    //删除
    @RequestMapping(value = "/del")
    public String del(ModelMap model,Long id) {
        ${bean.name?uncap_first}Service.delete(id);
        return "redirect:/${bean.name?uncap_first}";
    }
}
