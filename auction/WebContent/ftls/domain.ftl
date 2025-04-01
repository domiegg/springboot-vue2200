package ${bean.beanPagesPath}.domain;

import java.util.Date;
/**
*
* ${bean.comment} 实体类
*
**/
public class ${bean.name?cap_first } {
<#list bean.attrs as attr>
    private ${attr.jtype} ${attr.jname?uncap_first};

	public ${attr.jtype} get${attr.jname?cap_first}() {
        return ${attr.jname?uncap_first};
    }

    public void set${attr.jname?cap_first}(${attr.jtype} ${attr.jname?uncap_first}) {
        this.${attr.jname?uncap_first} = ${attr.jname?uncap_first};
    }

</#list>
}