/**
 * 
 */
package freemarker;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 接口或类的说明
 *
 * <br>==========================
 * <br> 公司：月亮小屋（中国）有限公司
 * <br> 开发：huangkaifu@bluemoon.com.cn
 * <br> 版本：1.0
 * <br> 作者：黄凯福
 * <br> 创建时间：2017年3月14日
 * <br>==========================
 */
public class CreateSql {
    static ArrayList<String> sqls = new ArrayList<String>();

    private static String length(String type) {
        String length = "";
        switch (type) {
        case "INT":
            length = "11";
            break;
        case "BIGINT":
            length = "20";
            break;
        case "VARCHAR":
            length = "255";
            break;
        default:
            break;
        }
        return length;
    }

    private static void createsql(Class cls) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE `").append(cls.getSimpleName().toLowerCase()).append("` (`id` bigint(20) NOT NULL AUTO_INCREMENT,");

        try {
            Field[] lVals = cls.getDeclaredFields();
            for (Field field : lVals) {
                if (!field.getName().equals("id")) {
                    sb.append("`").append(field.getName()).append("` ");

                    if (field.getType().getSimpleName().equals("Date")) {
                        sb.append(DbNameUtil.j2dbtype.get(field.getType().getSimpleName()).toLowerCase()).append(length(DbNameUtil.j2dbtype.get(field.getType().getSimpleName())));

                        sb.append(" DEFAULT CURRENT_TIMESTAMP,");

                    } else {
                        sb.append(DbNameUtil.j2dbtype.get(field.getType().getSimpleName()).toLowerCase()).append("(")
                                .append(length(DbNameUtil.j2dbtype.get(field.getType().getSimpleName())));

                        sb.append(") DEFAULT NULL,");
                    }
                }
            }
            sb.append("PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println(sb.toString());
        sqls.add(sb.toString());
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        List<Class<?>> classes = ClassUtil.getClasses("bean");
        for (Class clas : classes) {
            if (StringUtils.isNotBlank(clas.getSimpleName())) {
                createsql(clas);
            }
        }
        java.sql.Connection con = Builder.getConn();
        for (String sql : sqls) {
            java.sql.PreparedStatement pre = con.prepareStatement(sql);
            pre.executeUpdate();
        }
    }

}
