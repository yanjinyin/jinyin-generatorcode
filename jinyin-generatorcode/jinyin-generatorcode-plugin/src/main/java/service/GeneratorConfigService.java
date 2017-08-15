package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Element;

import utils.JarTools;
import utils.StringTools;
import utils.XmlUtil;
import config.Global;
import entity.GenTable;
import entity.GenTableColumn;
import exception.GeneratorCodePluginException;

/**
 * 
 * @Description: 设置参数业务
 * @author yanjinyin
 * @date 2017年8月9日 下午10:09:09
 */
public class GeneratorConfigService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 * @Description: 设置GeneratorConfig.xml数据
	 * @param configXmlPath
	 *            文件路径
	 * @return
	 * @author yanjinyin
	 * @date 2017年8月10日 下午8:05:22
	 */
	public static void setGeneratorConfigByFile(String configXmlPath) {
		if (StringUtils.isEmpty(configXmlPath)) {
			configXmlPath = Global.DEFAULT_CONFIG_XML_PATH;
		}
		File file = new File(configXmlPath);
		if (!file.exists() || !file.isFile()) {
			throw new GeneratorCodePluginException("generatorConfig.xml文件不存在");
		}
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file.getAbsolutePath());
			Element root = XmlUtil.getDocument(fis).getDocumentElement();
			
			//设置数据库链接
			setJdbcConnectionByElement(root);//设置数据库连接属性
			//设置生成的相关属性到全局配置里面
			setGeneratorPropertiesByXmlElement(root);
			setTableListByXmlElement(root);
			/* 加载jdbc驱动包 */
			loadClassPathEntry();
			//设置生成包位置
			setGeneratorsByElement(root);
		} catch (Exception e) {
			throw new GeneratorCodePluginException(e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(fis);
		}

	}
	
	/**
	 * 
	 * @Description: 设置generatorProperties
	 * @param root
	 * @author yanjinyin
	 * @date 2017年8月10日 下午9:55:01
	 */
	private static void setGeneratorPropertiesByXmlElement(Element root) {
		Element e = XmlUtil.getElement(root, "generatorProperties");
		if (null != e) {
			Map<String, String> varMap = XmlUtil.loadProperty(e);
			if (varMap == null  || varMap.get("classPathEntry") == null) {
				throw new GeneratorCodePluginException("GeneratorProperties参数不正确");
			}
			Global.author = varMap.get("author");
			Global.classPathEntry = varMap.get("classPathEntry");
			if (varMap.get("replaceFile") != null) {
				Boolean isReplaceFile = null;
				try {
					isReplaceFile = Boolean.valueOf(varMap.get("replaceFile"));
				} catch (Exception ex) {
					throw new GeneratorCodePluginException("replaceFile参数不正确");
				}
				Global.replaceFile = isReplaceFile;
			}
			
		} else {
			throw new GeneratorCodePluginException("generatorProperties不存在");
		}
	}
	
	/**
	 * 
	 * @Description: 设置生成包位置
	 * @param root
	 * @return
	 * @author hasee
	 * @date 2017年8月10日 下午9:57:49
	 */
	private static void setGeneratorsByElement(Element root) {
		Element generatorsElement = XmlUtil.getElement(root, "generators");
		if(null != generatorsElement){
		List<Element> generatorElementList=XmlUtil.getElements(generatorsElement, "generator");
//		
		for (Element element : generatorElementList) {
			Global.generatorPostionsMap.put( element.getAttribute("type"),  element.getAttribute("targetPackage"));
		}
		}else{
			throw new GeneratorCodePluginException("generators parameter is incorrect");
		}
	}

	/**
	 * 
	 * @Description: 设置表信息 
	 * @param root
	 * @return
	 * @author yanjinyin
	 * @date 2017年8月10日 下午9:55:16
	 */
	private static void setTableListByXmlElement(Element root) {
		Element e = XmlUtil.getElement(root, "tables");
		// 获取里面的表列表
		List<Element> elements = XmlUtil.getElements(e, "table");

		List<GenTable> genTableList = new ArrayList<GenTable>();
		for (Element element : elements) {
			GenTable genTable = new GenTable();
			Map<String, String> attributes = XmlUtil.loadAttribute(element);
			// 表名
			String tableName = attributes.get("tableName");
			// 表实体名
			String domainObjectName = attributes.get("domainObjectName");
			// 模块名
			String moduleName = attributes.get("moduleName");
			genTable.setName(tableName);
			genTable.setModuleName(moduleName);
			// 生成的实体名称
			if (StringUtils.isBlank(domainObjectName)) {
				genTable.setClassName(StringTools.toClassName(tableName));
			} else {
				genTable.setClassName(domainObjectName);
			}
			// 获取列
			List<Element> columnValues = XmlUtil.getElements(element, "column");
			List<GenTableColumn> genTableColumnList = new ArrayList<GenTableColumn>();
			for (Element columnElement : columnValues) {
				GenTableColumn genTableColumn = new GenTableColumn();
				//列名
				String columnName = columnElement.getAttribute("columnName");
				genTableColumn.setColumnName(columnName);
//				List<Element> values = XmlUtil.getElements(element, "value");
				// ColumnValue columnValue = new ColumnValue();
				// columnValue.setName(column);
//				for (Element valueElement : values) {
					// columnValue.getMap().put(valueElement.getAttribute("key"),
					// valueElement.getAttribute("value"));

//				}
				genTableColumnList.add(genTableColumn);
			}
			genTable.setColumnList(genTableColumnList);
			genTableList.add(genTable);
		}
		Global.genTableList=genTableList;
	}

	/**
	 * 
	 * @Description: 加载jdbc数据量链接参数
	 * @param root
	 * @return
	 * @author yanjinyin
	 * @date 2017年8月10日 下午8:48:23
	 */
	private static void setJdbcConnectionByElement(Element root) {
		Element e = XmlUtil.getElement(root, "jdbcConnection");
		if (e == null) {
			throw new GeneratorCodePluginException("jdbcConnection parameter is incorrect");
		}
		Map<String, String> attributes = XmlUtil.loadAttribute(e);
		if (StringUtils.isBlank(attributes.get("connectionURL"))|| StringUtils.isBlank(attributes.get("driverClass"))|| StringUtils.isBlank(attributes.get("password"))
				||StringUtils.isBlank(attributes.get("username"))) {
			throw new GeneratorCodePluginException("JdbcConnection parameter is incorrect");
		}
		Global.connectionURL=attributes.get("connectionURL");
		Global.driverClass=attributes.get("driverClass");
		Global.password=attributes.get("password");
		Global.username=attributes.get("username");
	}

	/**
	 * 加载ClassPath驱动包
	 */
	private static void loadClassPathEntry() {
		if (StringUtils.isNoneBlank(Global.classPathEntry)) {
			String[] splits = StringUtils.split(Global.classPathEntry, ',');
			for (String split : splits) {
				JarTools.loadJar(split, null);
			}
		}
	}
}
