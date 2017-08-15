package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description: 待生成表Entity
 * @author yanjinyin
 * @date 2017年8月9日 下午8:53:24
 */
public class GenTable implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 业务表名称
	 */
	private String name; 	
	/**
	 * 实体类名称
	 */
	private String className;		
	/**
	 * 模块名称
	 */
	private String moduleName;
	
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * 当前表的，所有列
	 */
	private List<GenTableColumn> columnList = new ArrayList<GenTableColumn>();	// 表列

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<GenTableColumn> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<GenTableColumn> columnList) {
		this.columnList = columnList;
	}

}


