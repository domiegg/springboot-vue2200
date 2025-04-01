package freemarker;

import java.util.ArrayList;
import java.util.List;

/**
 * bean类
 * 
 * @author hongten(hongtenzone@foxmail.com)<br>
 * @date 2013-4-5
 */
public class Bean {

	/** bean 名称 */
	private String name;
	private String comment;
	/** bean 首字母小写名称 */
	private String lowerName;
	/** bean 路径 */
	private String beanUrl;
	private String beanPagesPath;
	/** dao 路径 */
	private String beanDaoUrl;
	/** dao 实现路径 */
	private String beanDaoImplUrl;
	/** service 路径 */
	private String beanServiceUrl;
	/** service 实现路径 */
	private String beanServiceImplUrl;

	private List<Attr> attrs = new ArrayList<>();

	/**
	 * @return the beanPagesPath
	 */
	public String getBeanPagesPath() {
		return beanPagesPath;
	}

	/**
	 * @param beanPagesPath
	 *            the beanPagesPath to set
	 */
	public void setBeanPagesPath(String beanPagesPath) {
		this.beanPagesPath = beanPagesPath;
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

	/**
	 * @return the attrs
	 */
	public List<Attr> getAttrs() {
		return attrs;
	}

	/**
	 * @param attrs
	 *            the attrs to set
	 */
	public void setAttrs(List<Attr> attrs) {
		this.attrs = attrs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLowerName() {
		return lowerName;
	}

	public void setLowerName(String lowerName) {
		this.lowerName = lowerName;
	}

	public String getBeanUrl() {
		return beanUrl;
	}

	public void setBeanUrl(String beanUrl) {
		this.beanUrl = beanUrl;
	}

	public String getBeanDaoUrl() {
		return beanDaoUrl;
	}

	public void setBeanDaoUrl(String beanDaoUrl) {
		this.beanDaoUrl = beanDaoUrl;
	}

	public String getBeanDaoImplUrl() {
		return beanDaoImplUrl;
	}

	public void setBeanDaoImplUrl(String beanDaoImplUrl) {
		this.beanDaoImplUrl = beanDaoImplUrl;
	}

	public String getBeanServiceUrl() {
		return beanServiceUrl;
	}

	public void setBeanServiceUrl(String beanServiceUrl) {
		this.beanServiceUrl = beanServiceUrl;
	}

	public String getBeanServiceImplUrl() {
		return beanServiceImplUrl;
	}

	public void setBeanServiceImplUrl(String beanServiceImplUrl) {
		this.beanServiceImplUrl = beanServiceImplUrl;
	}

}