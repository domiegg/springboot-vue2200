/**
 *
 */
package freemarker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangkaifu
 *
 */
public class DbNameUtil {
    public static Map<String, String> j2dbtype = new HashMap<>();
    public static Map<String, String> dbtype = new HashMap<>();
    public static Map<String, String> mybaticdbtype = new HashMap<>();

    static {
        dbtype.put("BIGINT", "Long");
        dbtype.put("INT", "Integer");
        dbtype.put("VARCHAR", "String");
        dbtype.put("DATETIME", "Date");
        dbtype.put("TEXT", "String");
        dbtype.put("DOUBLE", "Double");

        j2dbtype.put("Long", "BIGINT");
        j2dbtype.put("Integer", "INT");
        j2dbtype.put("String", "VARCHAR");
        j2dbtype.put("Date", "DATETIME");
        j2dbtype.put("TEXT", "String");
        j2dbtype.put("Double", "DOUBLE");

        mybaticdbtype.put("BIGINT", "INTEGER");
        mybaticdbtype.put("INT", "INTEGER");
        mybaticdbtype.put("VARCHAR", "VARCHAR");
        mybaticdbtype.put("DATETIME", "TIMESTAMP");
        mybaticdbtype.put("TEXT", "VARCHAR");
        mybaticdbtype.put("DOUBLE", "DOUBLE");

    }

    public static String convertToJava(String dbName) {
        if (null != dbName) {
            String[] words = dbName.split("_");
            String result = toUppercase4FirstLetter(words);
            return result;
        } else {
            return "";
        }
    }

    public static String toUppercase4FirstLetter(String... words) {
        StringBuffer buffer = new StringBuffer();
        if (words != null && words.length > 0) {
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                String firstLetter = word.substring(0, 1);
                String others = word.substring(1);
                String upperLetter = null;
                if (i != 0) {
                    upperLetter = firstLetter.toUpperCase();
                } else {
                    upperLetter = firstLetter;
                }
                buffer.append(upperLetter).append(others);
            }
            return buffer.toString();
        }
        return "";
    }

    public static String toUppercase4FirstLetter(String word) {
        StringBuffer buffer = new StringBuffer();
        String firstLetter = word.substring(0, 1);
        String others = word.substring(1);
        String upperLetter = null;
        upperLetter = firstLetter.toUpperCase();
        buffer.append(upperLetter).append(others);
        return buffer.toString();
    }
}
