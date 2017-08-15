package service;

import utils.GenUtils;
import entity.GenCategory;
import entity.GenConfig;

/**
 * 
 * @Description: 生成入口
 * @author yanjinyin
 * @date 2017年8月15日 下午8:20:31
 */
public class GeneratorMainService {
	public static void main(String[] args) {
		GenConfig config = GenUtils.getConfig();
		System.out.println(config.getCategoryList().size());
		for (GenCategory genCategory : config.getCategoryList()) {
			if(genCategory.getTemplate()!=null){
				for (String template : genCategory.getTemplate()) {
					System.out.println(template);
				}
			}
		}
		
//		System.out.println(config.getCategoryList());
//		GeneratorConfigService.setGeneratorConfigByFile("C:\\cjworkspace\\jinyin-generatorcode\\jinyin-generatorcode-plugin\\src\\main\\resources\\generatorConfig.xml");
//		GeneratorCodeService.generateCode();
//		
//		
//		System.out.println(Global.author);
	}
}
