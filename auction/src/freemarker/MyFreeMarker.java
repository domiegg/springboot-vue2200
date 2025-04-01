/**
 * 
 */
package freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.Writer;

/**
 * freemarker测试
 * 
 * @author hongten(hongtenzone@foxmail.com)<br>
 * @date 2013-4-5
 */
public class MyFreeMarker {

    public static Configuration configuration;
    public static Template template;
    public static Writer writer;
    /**
     * 模板文件的存放路径，这里是存放在项目根目录下的ftls文件夹中
     */
    public static final String FTLS_PATH = "WebContent/ftls";

    public static final String MESSAGE = "message";
    public static final String HELLO_WORLD = "Hello World!";
    public static final String JSP_FORM_TEMPLATE = "jsp-form.ftl";
    public static final String JSP_PAGE_TEMPLATE = "jsp-page.ftl";
    public static final String DOMAIN_TEMPLATE = "domain.ftl";
    public static final String MAPPER_TEMPLATE = "mapper.ftl";
    public static final String MAPPER_XML_TEMPLATE = "mapper-xml.ftl";
    public static final String SERVICE_TEMPLATE = "service.ftl";
    public static final String SERVICE_IMPL_TEMPLATE = "service-impl.ftl";
    public static final String CONTROLLER_TEMPLATE = "controller.ftl";
    public static final String common1 = "common/Page.ftl";
    public static final String common2 = "common/JsonResult.ftl";
    public static final String common3 = "common/PageResult.ftl";
    public static final String common4 = "common/PageSearchParam.ftl";
    public static final String interceptor = "interceptor/GlobalInterceptor.ftl";
    public static final String interceptor2 = "interceptor/LoginInterceptor.ftl";
    public static final String domain = "domain/Menu.ftl";
    public static final String domain2 = "domain/User.ftl";
    public static final String dao = "dao/MenuMapper.ftl";
    public static final String dao2 = "dao/UserMapper.ftl";
    public static final String service = "service/MenuService.ftl";
    public static final String service2 = "service/UserService.ftl";
    public static final String service3 = "service/impl/IMenuService.ftl";
    public static final String service4 = "service/impl/IUserService.ftl";
    public static final String controller = "controller/IndexController.ftl";
    public static final String controller1 = "controller/UserController.ftl";
    public static final String resources = "resources/jdbc.ftl";
    public static final String resources1 = "resources/spring-mvc.ftl";
    public static final String resources2 = "resources/spring-mybatis.ftl";
    public static final String resourcesmapping = "resources/mapping/MenuMapper.ftl";
    public static final String resourcesmapping2 = "resources/mapping/UserMapper.ftl";

    // bean
    public static final String BEAN = "bean";
    public static final String BEAN_URL = "src.com.ognice";
    public static final String RESOURCES_MAPPING_URL = "resources.mapping";
    public static final String RESOURCES_URL = "resources";
    public static final String WEB_URL = "WebContent.WEB-INF.admin";
    public static final String PAKAGE_URL = "com.ognice";

    // annotation
    public static final String ANNOTATION = "annotation";
    public static final String ANNOTATION_AUTHOR_NAME = "..";
    public static final String ANNOTATION_AUTHOR_MAIL = "952396697@qq.com";
    public static final String ANNOTATION_VERSION = "1.0";

    // date formate
    public static final String DATE_FROMATE = "yyyy-MM-dd";

}
