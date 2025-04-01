/**
 *
 */
package ${bean.beanPagesPath}.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${bean.beanPagesPath}.controller.common.PageResult;
import ${bean.beanPagesPath}.controller.common.PageSearchParam;
import ${bean.beanPagesPath}.dao.${bean.name?cap_first}Mapper;
import ${bean.beanPagesPath}.domain.${bean.name?cap_first};
import ${bean.beanPagesPath}.service.I${bean.name?cap_first}Service;
/**
* 
* ${bean.comment} service接口实现类
*
**/
@Service("${bean.name?uncap_first}Service")
public class ${bean.name?cap_first}Service implements I${bean.name?cap_first}Service {
    @Resource
    private ${bean.name?cap_first}Mapper ${bean.name?uncap_first}Mapper;

    public ${bean.name?cap_first} get${bean.name?cap_first}ById(Long id) {
        return ${bean.name?uncap_first}Mapper.select${bean.name?cap_first}ById(id);
    }

    public String save(${bean.name?cap_first} record) {
            if (1 == ${bean.name?uncap_first}Mapper.insert(record)) {
                return "添加成功";
            }
        return "添加失败";
    }

    public PageResult getPages(PageSearchParam param) {
        PageResult pageResult = new PageResult();
        pageResult.setPagesize(param.getPagesize());
        pageResult.setPage(param.getPage());
        param.setPage((param.getPage() - 1) * param.getPagesize());
        List<${bean.name?cap_first}> ${bean.name?uncap_first}s = ${bean.name?uncap_first}Mapper.page(param);
        pageResult.setData(${bean.name?uncap_first}s);
        param.setPage(null);
        pageResult.setTotal(${bean.name?uncap_first}Mapper.page(param).size());
        pageResult.setTotalPage((int) Math.ceil(((double) pageResult.getTotal() / pageResult.getPagesize())));
        return pageResult;
    }

    public int update(${bean.name?cap_first} record) {
        return ${bean.name?uncap_first}Mapper.update(record);
    }
    
    public int delete(Long id) {
        return ${bean.name?uncap_first}Mapper.delete(id);
    }
    
    public List<${bean.name?cap_first}> all() {
		// TODO Auto-generated method stub
		return ${bean.name?uncap_first}Mapper.page(new PageSearchParam());
	}

}
