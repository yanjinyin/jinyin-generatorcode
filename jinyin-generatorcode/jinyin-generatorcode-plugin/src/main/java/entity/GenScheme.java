package entity;

import java.io.Serializable;

/**
 * 
 * @Description: 生成方案Entity
 * @author yanjinyin
 * @date 2017年8月14日 下午8:45:53
 */
public class GenScheme implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 分类
	 */
	private String category;
	/**
	 * 生成包路径
	 */
	private String packageName;
	/**
	 * 生成模块名
	 */
	private String moduleName;
	/**
	 * 生成子模块名
	 */
	private String subModuleName;
	/**
	 * 生成功能名
	 */
	private String functionName;
	/**
	 * 生成功能名（简写）
	 */
	private String functionNameSimple;
	/**
	 * 生成功能作者
	 */
	private String functionAuthor;
	/**
	 * 业务表名
	 */
	private GenTable genTable;

	/**
	 * 是否替换现有文件 0：不替换；1：替换文件
	 */
	private Boolean replaceFile;

	public GenScheme() {
		super();
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionNameSimple() {
		return functionNameSimple;
	}

	public void setFunctionNameSimple(String functionNameSimple) {
		this.functionNameSimple = functionNameSimple;
	}

	public String getFunctionAuthor() {
		return functionAuthor;
	}

	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor;
	}

	public GenTable getGenTable() {
		return genTable;
	}

	public void setGenTable(GenTable genTable) {
		this.genTable = genTable;
	}

	public Boolean getReplaceFile() {
		return replaceFile;
	}

	public void setReplaceFile(Boolean replaceFile) {
		this.replaceFile = replaceFile;
	}

}
