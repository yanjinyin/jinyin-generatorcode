package config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.GenTable;

/**
 * 
 * @Description: 全局配置类
 * @author yanjinyin
 * @date 2017年8月10日 下午8:03:17
 */
public class Global {

	/**
	 * 默认配置文件路径
	 */
	final public static String DEFAULT_CONFIG_XML_PATH = "src/main/resources/generatorConfig.xml";

	/**
	 * 作者
	 */
	public static String author = "";
	/**
	 * url头部
	 */
	public static String url_head = "";
	/**
	 * jdbc驱动jar包位置
	 */
	public static String classPathEntry = "";
	/**
	 * 是否替换文件
	 */
	public static Boolean replaceFile = true;

	/**
	 * 数据库连接驱动类
	 */
	public static String driverClass = "com.mysql.jdbc.Driver";
	/**
	 * 连接url
	 */
	public static String connectionURL = "";
	/**
	 * 用户名
	 */
	public static String username = "";
	/**
	 * 密码
	 */
	public static String password = "";

	/**
	 * 生成位置,type表示类型，value表示具体位置 key表示type,value表示targetPackage
	 * type(domain、mappping、service、controller、html)
	 */
	public static Map<String, String> generatorPostionsMap = new HashMap<String, String>();

	/**
	 * 生成的表列表
	 * 如果为空，表示生成所有
	 */
	public static List<GenTable> genTableList = new ArrayList<GenTable>();

	/**
	 * 获取工程路径
	 * 
	 * @return
	 */
	public static String getProjectPath() {
		// 如果配置了工程路径，则直接返回，否则自动获取。
		return "";
	}

}
