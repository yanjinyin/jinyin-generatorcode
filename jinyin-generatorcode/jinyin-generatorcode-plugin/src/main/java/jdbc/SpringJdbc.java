package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import utils.DataSourceTools;
import config.Global;
import entity.GenTable;
import exception.GeneratorCodePluginException;

public class SpringJdbc {

//	final String SHOW_TABLE_DESC_SQL = "SHOW FULL COLUMNS FROM %s";
	protected JdbcTemplate jdbc = null;

	protected DataSource dataSource;

	public SpringJdbc() {
		TransactionSynchronizationManager.initSynchronization();
		dataSource = DataSourceTools.getDataSource();
		jdbc = new JdbcTemplate(dataSource);
	}

	/**
	 * 
	 * @Description: 获取数据库表
	 * @author yanjinyin
	 * @date 2017年8月14日 下午7:36:15
	 */
	public void getDataBaseTable() {
		Connection connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			StringBuilder sqlBuilder=new StringBuilder();
			//基于mysql的获取所有表的
			sqlBuilder.append("SELECT t.table_name AS name,t.TABLE_COMMENT AS comments FROM information_schema.`TABLES` t WHERE t.TABLE_SCHEMA = (select database()) ");
			List<GenTable> genTableList= Global.genTableList;;
			if(genTableList!=null && genTableList.size()>0){
				sqlBuilder.append("AND t.TABLE_NAME IN(");
				for (GenTable genTable : genTableList) {
					sqlBuilder.append("upper(");
					sqlBuilder.append(genTable.getName());
					sqlBuilder.append(")");
				}
			}
			sqlBuilder.append("ORDER BY t.TABLE_NAME");
			ps= connection.prepareStatement(sqlBuilder.toString());
			 rs = ps.executeQuery();
			   while (rs.next()) {  
//                   User user = new User();  
//                   user.setId(rs.getInt("N_ID"));  
//                   user.setName(rs.getString("C_NAME"));  
//                   userList.add(user);  
                }  
		} catch (Exception e) {
			throw new GeneratorCodePluginException("getDataBaseTable异常:"+e.toString());
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
			DataSourceUtils.releaseConnection(connection, dataSource);
		}
	}

	/**
	 * 
	 * @Description: 根据表id，查询表所有列原信息
	 * @param TableId
	 * @author yanjinyin
	 * @date 2017年8月13日 下午10:48:16
	 */
	public void findTableColumnListByTableId(Integer TableId) {
//		SELECT t.COLUMN_NAME AS name, (CASE WHEN t.IS_NULLABLE = 'YES' THEN '1' ELSE '0' END) AS isNull,
//		(t.ORDINAL_POSITION * 10) AS sort,t.COLUMN_COMMENT AS comments,t.COLUMN_TYPE AS jdbcType 
//	FROM information_schema.`COLUMNS` t 
//	WHERE t.TABLE_SCHEMA = (select database())
//	<if test="name != null and name != ''">
//		AND t.TABLE_NAME = upper(#{name})
//	</if>
//	ORDER BY t.ORDINAL_POSITION
		
		
		
		// Map<String, ResultType> resultTypes = new KeyMap<ResultType>();
		// Map<String, Map<String, Object>> columnInfo =
		// query(String.format(SHOW_TABLE_DESC_SQL, tableName), "field");
		Connection connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps = null;
		ResultSet rs = null;
		// XmlConfigLoader configLoader = XmlConfigLoader.getConfigLoader();
		// TableModel tableModel = configLoader.getTableMap().get(tableName) ;
		try {
			// ps =
			// connection.prepareStatement(String.format("select * from %s",
			// tableName));
			// rs = ps.executeQuery();
			// ResultSetMetaData rsmd = rs.getMetaData();
			// int cloumnLength = rsmd.getColumnCount();
			//
			// for(int x=0;x<cloumnLength;x++){
			// ResultType resultType = new ResultType();
			// String field = rsmd.getColumnLabel(x+1);
			// Map<String, Object> fieldMap = columnInfo.get( field );
			// String extra = StringTools.toString(fieldMap.get("extra")) ;
			// resultType.setAutoIncrement("auto_increment".equals(extra)) ;
			// resultType.setPri("pri".equalsIgnoreCase(StringTools.toString(fieldMap.get("key"))))
			// ;
			// resultType.setColumnLabel(field) ;
			// resultType.setColumnName( rsmd.getColumnName(x+1) ) ;
			// ColumnOverride columnOverride =
			// tableModel.getColumnOverride().get( field ) ;
			//
			// resultType.setColumnType( rsmd.getColumnType(x+1) ) ;
			// if(columnOverride == null){
			// resultType.setColumnTypeName( resultType.getJdbcType().name() ) ;
			// resultType.setClassName(rsmd.getColumnClassName(x+1)) ;
			// }else{
			// resultType.setColumnTypeName(columnOverride.getJdbcType().name())
			// ;
			// resultType.setClassName( columnOverride.getJavaType() ) ;
			// }
			//
			// resultType.setProperty( StringTools.toProperty(field) ) ;
			// resultType.setComment( StringTools.toString(
			// fieldMap.get("comment"))) ;
			// resultType.setGenerateClassName(
			// resultType.getClassName().replaceAll("java.lang.", ""));
			//
			// /*修改链接符号*/
			// ColumnSymbol columnSymbol = tableModel.getColumnSymbols().get(
			// field ) ;
			// if(null != columnSymbol){
			// columnSymbol.setQueryValue(
			// columnSymbol.getValue().replaceAll("\\{value\\}",
			// "#{"+resultType.getProperty()+"}"));
			// resultType.setColumnSymbol( columnSymbol );
			// }
			//
			// /*设置字段显示的值*/
			// resultType.setColumnValue( tableModel.getColumnValue().get(field)
			// ) ;
			//
			// resultTypes.put(field, resultType) ;
			//
			// }
//			return null;
		} catch (Exception e) {
//			return null;
			// MyDogLog.getLog().errr(" queryTableMetas ", e);
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
			DataSourceUtils.releaseConnection(connection, dataSource);
		}

		// return resultTypes;
	}

	/**
	 * 
	 * @Description: 根据表名，获取其主键
	 * @param TableId
	 * @author yanjinyin
	 * @date 2017年8月13日 下午10:52:12
	 */
	public void findTablePKByTableId(Integer TableId) {
//		SELECT lower(au.COLUMN_NAME) AS columnName 
//		FROM information_schema.`COLUMNS` au
//		WHERE au.TABLE_SCHEMA = (select database()) 
//		AND au.COLUMN_KEY='PRI' AND au.TABLE_NAME = upper(#{name})
		
		// Map<String, ResultType> resultTypes = new KeyMap<ResultType>();
		// Map<String, Map<String, Object>> columnInfo =
		// query(String.format(SHOW_TABLE_DESC_SQL, tableName), "field");
		Connection connection = DataSourceUtils.getConnection(dataSource);
		PreparedStatement ps = null;
		ResultSet rs = null;
		// XmlConfigLoader configLoader = XmlConfigLoader.getConfigLoader();
		// TableModel tableModel = configLoader.getTableMap().get(tableName) ;
		try {
			// ps =
			// connection.prepareStatement(String.format("select * from %s",
			// tableName));
			// rs = ps.executeQuery();
			// ResultSetMetaData rsmd = rs.getMetaData();
			// int cloumnLength = rsmd.getColumnCount();
			//
			// for(int x=0;x<cloumnLength;x++){
			// ResultType resultType = new ResultType();
			// String field = rsmd.getColumnLabel(x+1);
			// Map<String, Object> fieldMap = columnInfo.get( field );
			// String extra = StringTools.toString(fieldMap.get("extra")) ;
			// resultType.setAutoIncrement("auto_increment".equals(extra)) ;
			// resultType.setPri("pri".equalsIgnoreCase(StringTools.toString(fieldMap.get("key"))))
			// ;
			// resultType.setColumnLabel(field) ;
			// resultType.setColumnName( rsmd.getColumnName(x+1) ) ;
			// ColumnOverride columnOverride =
			// tableModel.getColumnOverride().get( field ) ;
			//
			// resultType.setColumnType( rsmd.getColumnType(x+1) ) ;
			// if(columnOverride == null){
			// resultType.setColumnTypeName( resultType.getJdbcType().name() ) ;
			// resultType.setClassName(rsmd.getColumnClassName(x+1)) ;
			// }else{
			// resultType.setColumnTypeName(columnOverride.getJdbcType().name())
			// ;
			// resultType.setClassName( columnOverride.getJavaType() ) ;
			// }
			//
			// resultType.setProperty( StringTools.toProperty(field) ) ;
			// resultType.setComment( StringTools.toString(
			// fieldMap.get("comment"))) ;
			// resultType.setGenerateClassName(
			// resultType.getClassName().replaceAll("java.lang.", ""));
			//
			// /*修改链接符号*/
			// ColumnSymbol columnSymbol = tableModel.getColumnSymbols().get(
			// field ) ;
			// if(null != columnSymbol){
			// columnSymbol.setQueryValue(
			// columnSymbol.getValue().replaceAll("\\{value\\}",
			// "#{"+resultType.getProperty()+"}"));
			// resultType.setColumnSymbol( columnSymbol );
			// }
			//
			// /*设置字段显示的值*/
			// resultType.setColumnValue( tableModel.getColumnValue().get(field)
			// ) ;
			//
			// resultTypes.put(field, resultType) ;
			//
			// }
//			return null;
		} catch (Exception e) {
//			return null;
			// MyDogLog.getLog().errr(" queryTableMetas ", e);
		} finally {
			JdbcUtils.closeResultSet(rs);
			JdbcUtils.closeStatement(ps);
			DataSourceUtils.releaseConnection(connection, dataSource);
		}

		// return resultTypes;
	}


}
