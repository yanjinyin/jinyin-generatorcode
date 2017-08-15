package entity;

import java.io.Serializable;

/**
 * 
 * @Description: 业务表字段Entity
 * @author yanjinyin
 * @date 2017年8月9日 下午8:54:41
 */
public class GenTableColumn implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 列名
	 */
	private String columnName;
	/**
	 * 对应实体的JAVA类型,用于替换默认的类型
	 */
	private String javaType;
	/**
	 * 属性名
	 */
	private String javaFieldName;
	/**
	 * 是否可为空（1：可为空；0：不为空）
	 */
	private String isNull;
	/**
	 * 是否为插入字段（1：插入字段）
	 */
	private String isInsert;
	/**
	 * 是否编辑字段（1：编辑字段）
	 */
	private String isEdit;
	/**
	 * 是否列表字段（1：列表字段）
	 */
	private String isList;
	/**
	 * 是否查询字段（1：查询字段）
	 */
	private String isQuery;
	/**
	 * 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
	 */
	private String queryType;
	/**
	 * 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
	 */
	private String showType;
	/**
	 * 字典类型
	 */
	private String dictType;
	/**
	 * 排序（升序）
	 */
	private Integer sort;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getJavaFieldName() {
		return javaFieldName;
	}

	public void setJavaFieldName(String javaFieldName) {
		this.javaFieldName = javaFieldName;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getIsInsert() {
		return isInsert;
	}

	public void setIsInsert(String isInsert) {
		this.isInsert = isInsert;
	}

	public String getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(String isEdit) {
		this.isEdit = isEdit;
	}

	public String getIsList() {
		return isList;
	}

	public void setIsList(String isList) {
		this.isList = isList;
	}

	public String getIsQuery() {
		return isQuery;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}
