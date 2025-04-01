package ${bean.beanPagesPath}.dao;

import java.util.List;

import ${bean.beanPagesPath}.controller.common.PageSearchParam;
import ${bean.beanPagesPath}.domain.${bean.name?cap_first};
/**
* 
* ${bean.comment} dao类
*
**/
public interface ${bean.name?cap_first}Mapper {
    int delete(Long id);

    int insert(${bean.name?cap_first} record);

    ${bean.name?cap_first} select${bean.name?cap_first}ById(Long id);

    int update(${bean.name?cap_first} record);

    List<${bean.name?cap_first}> page(PageSearchParam param);
}