package freemarker;

/**
 * bean类
 * 
 * @author hongten(hongtenzone@foxmail.com)<br>
 * @date 2013-4-5
 */
public class Attr {

    /** bean 名称 */
    private String jname;
    private String dbname;
    /** bean 首字母小写名称 */
    private String jtype;
    private String dtype;
    private String ogdtype;
    private String comment;

    /**
     * @return the ogdtype
     */
    public String getOgdtype() {
        return ogdtype;
    }

    /**
     * @param ogdtype the ogdtype to set
     */
    public void setOgdtype(String ogdtype) {
        this.ogdtype = ogdtype;
    }

    /**
     * @return the jname
     */
    public String getJname() {
        return jname;
    }

    /**
     * @param jname
     *            the jname to set
     */
    public void setJname(String jname) {
        this.jname = jname;
    }

    /**
     * @return the dbname
     */
    public String getDbname() {
        return dbname;
    }

    /**
     * @param dbname
     *            the dbname to set
     */
    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    /**
     * @return the jtype
     */
    public String getJtype() {
        return jtype;
    }

    /**
     * @param jtype
     *            the jtype to set
     */
    public void setJtype(String jtype) {
        this.jtype = jtype;
    }

    /**
     * @return the dtype
     */
    public String getDtype() {
        return dtype;
    }

    /**
     * @param dtype
     *            the dtype to set
     */
    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment
     *            the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}