/**
 *
 */
package ${bean.beanPagesPath}.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ${bean.beanPagesPath}.controller.common.PageResult;
import ${bean.beanPagesPath}.controller.common.PageSearchParam;
import ${bean.beanPagesPath}.domain.${bean.name?cap_first};

/**
* 
* ${bean.comment} service接口类
*
**/
public interface I${bean.name?cap_first}Service {
	//根据id获取
    public ${bean.name?cap_first} get${bean.name?cap_first}ById(Long id);
	//保存入库
    public String save(${bean.name?cap_first} record);
    //获取全部数据
    public List<${bean.name?cap_first}> all();
	//分页获取
    public PageResult getPages(PageSearchParam param);
	//更新
    public int update(${bean.name?cap_first} record);
    //删除
    public int delete(Long id);

}
