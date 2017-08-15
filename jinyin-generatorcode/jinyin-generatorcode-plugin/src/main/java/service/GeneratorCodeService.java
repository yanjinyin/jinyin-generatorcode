package service;

import java.io.Serializable;
import java.util.Map;

import utils.GenUtils;
import config.Global;
import entity.GenConfig;
import entity.GenTable;
import entity.GenTemplate;

/**
 * 
 * @Description: 生成具体代码业务
 * @author yanjinyin
 * @date 2017年8月10日 下午10:00:45
 */
public class GeneratorCodeService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String generateCode(){
		
		for (GenTable genTable : Global.genTableList) {
			GeneratorEntity();
		}
		
		//获取所有表原始信息
		StringBuilder result = new StringBuilder();
		// 查询主表及字段列
//		GenTable genTable = genTableDao.get(genScheme.getGenTable().getId());
//		genTable.setColumnList(genTableColumnDao.findList(new GenTableColumn(new GenTable(genTable.getId()))));
		
		// 获取所有代码模板
		GenConfig config = GenUtils.getConfig();
		
		// 获取模板列表
//		List<GenTemplate> templateList = GenUtils.getTemplateList(config, genScheme.getCategory(), false);
//		List<GenTemplate> childTableTemplateList = GenUtils.getTemplateList(config, genScheme.getCategory(), true);
		
		// 如果有子表模板，则需要获取子表列表
//		if (childTableTemplateList.size() > 0){
//			GenTable parentTable = new GenTable();
//			parentTable.setParentTable(genTable.getName());
//			genTable.setChildList(genTableDao.findList(parentTable));
//		}
		
		// 生成子表模板代码
//		for (GenTable childTable : genTable.getChildList()){
//			childTable.setParent(genTable);
//			childTable.setColumnList(genTableColumnDao.findList(new GenTableColumn(new GenTable(childTable.getId()))));
//			genScheme.setGenTable(childTable);
//			Map<String, Object> childTableModel = GenUtils.getDataModel(genScheme);
//			for (GenTemplate tpl : childTableTemplateList){
//				result.append(GenUtils.generateToFile(tpl, childTableModel, genScheme.getReplaceFile()));
//			}
//		}
		
		// 生成主表模板代码
//		genScheme.setGenTable(genTable);
//		Map<String, Object> model = GenUtils.getDataModel(genScheme);
//		for (GenTemplate tpl : templateList){
//			result.append(GenUtils.generateToFile(tpl, model, genScheme.getReplaceFile()));
//		}
		return result.toString();
	}


	/**
	 * 
	 * @Description: 生成js
	 * @author yanjinyin
	 * @date 2017年8月10日 下午10:21:36
	 */
	private static void GeneratorJs(GenTemplate genTemplate,Map<String, Object> model) {

	}

	/**
	 * 
	 * @Description: 生成controller
	 * @author yanjinyin
	 * @date 2017年8月10日 下午10:22:21
	 */
	private static void GeneratorController() {

	}

	/**
	 * 
	 * @Description: 生成Service
	 * @author yanjinyin
	 * @date 2017年8月10日 下午10:22:21
	 */
	private static void GeneratorService() {

	}
	
	/**
	 * 
	 * @Description: 生成Dao
	 * @author yanjinyin
	 * @date 2017年8月10日 下午10:22:21
	 */
	private static void GeneratorDao() {

	}
	
	/**
	 * 
	 * @Description: 生成实体
	 * @author yanjinyin
	 * @date 2017年8月10日 下午10:22:21
	 */
	private static void GeneratorEntity() {

	}
	
	/**
	 * 
	 * @Description: 生成jsp页面
	 * @author yanjinyin
	 * @date 2017年8月10日 下午10:22:21
	 */
	private static void GeneratorView() {

	}
}
