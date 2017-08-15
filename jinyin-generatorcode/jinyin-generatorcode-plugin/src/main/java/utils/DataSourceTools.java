package utils;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import config.Global;

/**
 * 
 * @Description: 数据源工具
 * @author yanjinyin
 * @date 2017年8月13日 下午10:38:14
 */
public class DataSourceTools {
	/**
	 * 数据源
	 */
	protected static BasicDataSource dataSource;
	/**
	 * 
	 * @Description: 获取数据源
	 * @return
	 * @author yanjinyin
	 * @date 2017年8月13日 下午10:36:44
	 */
	public static DataSource getDataSource() {
		synchronized (Thread.class) {
			if (null == dataSource) {
				dataSource = new BasicDataSource();
				dataSource = new BasicDataSource();
				dataSource.setUrl(Global.connectionURL);
				dataSource.setUsername(Global.username);
				dataSource.setPassword(Global.password);
				dataSource.setDriverClassName(Global.driverClass);
			}
		}
		return dataSource;
	}
}
