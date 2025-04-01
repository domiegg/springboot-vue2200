/**
 *
 */
package freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangkaifu
 *
 */
public class Builder {
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE_NAME = "auction";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "123456";
    private static Connection con = null;
    static Annotation annotation = new Annotation();

    static {
        annotation.setAuthorMail(MyFreeMarker.ANNOTATION_AUTHOR_MAIL);
        annotation.setAuthorName(MyFreeMarker.ANNOTATION_AUTHOR_NAME);
        annotation.setVersion(MyFreeMarker.ANNOTATION_VERSION);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(MyFreeMarker.DATE_FROMATE);
        annotation.setDate(simpleDateFormat.format(new Date()));
    }

    public static Connection getConn() {
        try {
            Class.forName(DRIVER_CLASS);
            con = DriverManager.getConnection(DATABASE_URL + DATABASE_NAME, DATABASE_USER, DATABASE_PASSWORD);
            return con;
        } catch (Exception ex) {
            System.out.println("2:" + ex.getMessage());
        }
        return con;
    }

    public static void loopTables() throws SQLException, Exception {

        CopyFileUtil.copyDir(System.getProperty("user.dir") + "/WebContent/ftls/java", System.getProperty("user.dir") + "/src/com/ognice");
        CopyFileUtil.copyDir(System.getProperty("user.dir") + "/WebContent/ftls/resources", System.getProperty("user.dir") + "/resources");
        CopyFileUtil.copyDir(System.getProperty("user.dir") + "/WebContent/ftls/webapp", System.getProperty("user.dir") + "/WebContent");

        getConn();
        // 获取表
        DatabaseMetaData dm = con.getMetaData();

        ResultSet rs = dm.getCatalogs();
        rs = dm.getTables(null, "%", "%", new String[] { "TABLE" });
        while (rs.next()) {

            String comment = rs.getString("REMARKS");
            String name = rs.getString("TABLE_NAME"); // 字符串参数的具体取值参看API中getTables()
            System.out.println("数据表：" + name);
            if (name.equals("menu") || name.equals("user")) {
                continue;
            }
            Statement stmt = con.createStatement();
            ResultSet rs3 = stmt
                    .executeQuery("select table_name,table_comment from information_schema.tables  where table_schema = '" + DATABASE_NAME + "' and table_name ='" + name + "'");
            rs3.next();
            comment = rs3.getString("table_comment");
            ResultSet rs2 = con.getMetaData().getColumns(null, "root", name.toUpperCase(), "%");
            Bean bean = new Bean();
            bean.setName(name);
            bean.setComment(comment);
            bean.setBeanPagesPath(MyFreeMarker.PAKAGE_URL);
            bean.setBeanUrl(MyFreeMarker.BEAN_URL + ".domain");
            Attr attr = null;
            bean.setAttrs(new ArrayList<Attr>());
            while (rs2.next()) {
                attr = new Attr();
                attr.setJname(DbNameUtil.toUppercase4FirstLetter(rs2.getString("COLUMN_NAME")));
                attr.setDbname(rs2.getString("COLUMN_NAME"));
                System.out.println("*****" + rs2.getString("TYPE_NAME") + "****" + DbNameUtil.dbtype.get(rs2.getString("TYPE_NAME")));
                attr.setJtype(DbNameUtil.dbtype.get(rs2.getString("TYPE_NAME")));
                attr.setDtype(DbNameUtil.mybaticdbtype.get(rs2.getString("TYPE_NAME")));
                attr.setOgdtype(rs2.getString("TYPE_NAME"));
                attr.setComment(rs2.getString("REMARKS"));
                bean.getAttrs().add(attr);

            }
            rs2.close();
            rs3.close();
            buildOne(bean, MyFreeMarker.DOMAIN_TEMPLATE, ".java", "", false);
            bean.setBeanUrl(MyFreeMarker.BEAN_URL + ".controller");
            buildOne(bean, MyFreeMarker.CONTROLLER_TEMPLATE, "Controller.java", "", false);
            bean.setBeanUrl(MyFreeMarker.BEAN_URL + ".service");
            buildOne(bean, MyFreeMarker.SERVICE_TEMPLATE, "Service.java", "I", false);
            bean.setBeanUrl(MyFreeMarker.BEAN_URL + ".service.impl");
            buildOne(bean, MyFreeMarker.SERVICE_IMPL_TEMPLATE, "Service.java", "", false);
            bean.setBeanUrl(MyFreeMarker.BEAN_URL + ".dao");
            buildOne(bean, MyFreeMarker.MAPPER_TEMPLATE, "Mapper.java", "", false);
            bean.setBeanUrl(MyFreeMarker.RESOURCES_MAPPING_URL);
            buildOne(bean, MyFreeMarker.MAPPER_XML_TEMPLATE, "Mapper.xml", "", false);
            bean.setBeanUrl(MyFreeMarker.WEB_URL + "." + bean.getName());
            buildOne(bean, MyFreeMarker.JSP_FORM_TEMPLATE, "form.jsp", "", true);
            bean.setBeanUrl(MyFreeMarker.WEB_URL + "." + bean.getName());
            buildOne(bean, MyFreeMarker.JSP_PAGE_TEMPLATE, "page.jsp", "", true);

        }
    }

    public static void main(String[] args) throws Exception {
        loopTables();
    }

    public static void buildOne(Bean bean, String template, String houzui, String qianzhui, boolean jsp) throws IOException, TemplateException {
        // 创建Freemarker配置实例
        MyFreeMarker.configuration = new Configuration();
        MyFreeMarker.configuration.setDirectoryForTemplateLoading(new File(MyFreeMarker.FTLS_PATH));
        // 创建数据模型
        Map<String, Object> root = new HashMap<String, Object>();
        root.put(MyFreeMarker.BEAN, bean);
        root.put(MyFreeMarker.ANNOTATION, annotation);
        // domain
        // 加载模板文件
        MyFreeMarker.template = MyFreeMarker.configuration.getTemplate(template);

        String beanPath = System.getProperty("user.dir") + "/" + bean.getBeanUrl().replace(".", "/") + "/";
        File filePath = new File(beanPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        String beanname = jsp ? "" : DbNameUtil.toUppercase4FirstLetter(DbNameUtil.convertToJava(bean.getName()));
        String filePathOfBean = beanPath + "/" + qianzhui + beanname + houzui;
        File file = new File(filePathOfBean);
        if (!file.exists()) {
            file.createNewFile();// 显示生成的数据
            MyFreeMarker.writer = new FileWriter(file);
            MyFreeMarker.template.process(root, MyFreeMarker.writer);
        }
    }
}
