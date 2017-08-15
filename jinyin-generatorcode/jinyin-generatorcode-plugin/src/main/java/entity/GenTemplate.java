package entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @Description: 生成方案Entity
 * @author yanjinyin
 * @date 2017年8月8日 下午11:39:25
 */
@XmlRootElement(name = "template")
public class GenTemplate implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 分类(暂未使用)
	 */
	private String category;
	/**
	 * 生成文件路径
	 */
	private String filePath;
	/**
	 * 文件名
	 */
	private String fileName;
	/**
	 * 内容
	 */
	private String content;

	public GenTemplate() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	// @XmlTransient
	// public List<String> getCategoryList() {
	// if (category == null){
	// return Lists.newArrayList();
	// }else{
	// return Lists.newArrayList(StringUtils.split(category, ","));
	// }
	// }
	//
	// public void setCategoryList(List<String> categoryList) {
	// if (categoryList == null){
	// this.category = "";
	// }else{
	// this.category = ","+StringUtils.join(categoryList, ",") + ",";
	// }
	// }

}
