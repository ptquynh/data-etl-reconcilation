package com.etl.common.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.ibatis.jdbc.ScriptRunner;

import com.etl.common.TestBase;

import static com.etl.common.TestLogger.info;

public class DatabaseUtils extends DBConn{

	private static Statement stmt;

	public enum DataTypes{
		NUMBER,DATE,STRING,VARCHAR2,TEXT,INT,INT4,DOUBLE,FLOAT,VARCHAR;
	}
	
	//private static Connection conn;
		public enum DbTypes{
			ORACLE,MYSQL,POSTGRESQL,MMSQL,HIVE;
		}
		
		
	
	/***************************************************METADATA********************************************************
	 * ****************************************************************************************************************************
	 */
	/**
     * Get all metadata of a table
     * @param tableName
     * @param conn
     * @return
     * @throws SQLException
     */
	public static List<Object> getTableMeta(String tableName,Connection conn,DbTypes db) throws SQLException{
		info("Connecting to database...");
		String sql=null;
		switch(db) {
		case ORACLE:
			sql=TestBase.SQL_META_ORACLE.replace("?","'"+tableName+"'");
			break;
		case POSTGRESQL:
			sql=TestBase.SQL_META_POSTGRESQL.replace("?","'"+tableName+"'");
			break;
		case MYSQL:
			sql=TestBase.SQL_META_MYSQL.replace("?","'"+tableName+"'");
			break;
		case MMSQL:
			sql=TestBase.SQL_META_MMSQL.replace("?","'"+tableName+"'");
			break;
		case HIVE:
			sql=TestBase.SQL_META_HIVE.replace("?",""+tableName+"");
			break;
		}
		System.out.println("--------------------------------");
		System.out.println("sql:"+sql);
		System.out.println("--------------------------------");
		return getColumnValues(sql,conn);
	}
	/**
	 * Get all list of columns
	 * @param tableName
	 * @param conn
	 * @param db
	 * @return
	 * @throws SQLException
	 */
	public static List<Object> getColumnsMeta(String tableName,String colName,Connection conn,DbTypes db) throws SQLException{
		info("Connecting to database...");
		String sql=null;
		switch(db) {
		case ORACLE:
			sql=TestBase.SQL_META_ORACLE.replace("?","'"+tableName+"'");
			break;
		case POSTGRESQL:
			sql=TestBase.SQL_META_POSTGRESQL.replace("?","'"+tableName+"'");
			break;
		case MYSQL:
			sql=TestBase.SQL_META_MYSQL.replace("?","'"+tableName+"'");
			break;
		case MMSQL:
			sql=TestBase.SQL_META_MMSQL.replace("?","'"+tableName+"'");
			break;
		case HIVE:
			sql=TestBase.SQL_META_HIVE.replace("?",""+tableName+"");
			break;
		}
		System.out.println("--------------------------------");
		System.out.println("sql:"+sql);
		System.out.println("--------------------------------");
		return getColumnValues(sql,conn,colName);
	}


	/***************************************************SQL STATEMENT********************************************************
	 * ****************************************************************************************************************************
	 */
	/**
	 * Generate sql insert statement format
	 * @param column
	 * @param tableName
	 * @return
	 * @throws SQLException 
	 */
	public static String getInsertStatement(String tableName,Connection conn,DbTypes db) throws SQLException {
		List<Object> tableMeta=getColumnsMeta(tableName,"column_name",conn,db);
		StringBuilder insertPartBuilder = new StringBuilder("INSERT INTO " + tableName + " (");
		StringBuilder valuesPartBuilder = new StringBuilder("VALUES (");

		if(tableMeta.size()!=0) {
			for (int i=0;i<tableMeta.size();i++) {
				insertPartBuilder = insertPartBuilder.append(tableMeta.get(i)).append(", ");
				valuesPartBuilder = valuesPartBuilder.append("?, ");
			}

			insertPartBuilder.setLength(insertPartBuilder.length() - 2);
			insertPartBuilder = insertPartBuilder.append(") ");

			valuesPartBuilder.setLength(valuesPartBuilder.length() - 2);
			valuesPartBuilder = valuesPartBuilder.append(") ");
		}else info("The table [" + tableName + "] does not contain any columns!");

		String sqlStatement=insertPartBuilder.toString() + valuesPartBuilder.toString();
		System.out.println("--------------------------------");
		System.out.println("sqlStatement:"+sqlStatement);
		System.out.println("--------------------------------");
		return sqlStatement;
	}


	/**
	 * Get PreparedStatement
	 * @param sql
	 * @param jdbcDriver
	 * @param jdbcUrl
	 * @param jdbcUser
	 * @param jdbcPass
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public static PreparedStatement getPreparedStatement(String sql,Connection conn) throws SQLException{
		conn.setAutoCommit(false);
		PreparedStatement stmt = conn.prepareStatement(sql);   

		return stmt;
	}
	
	/**
     * Generate Insert SQL Statement
     * @param tableName
     * @param conn
     * @param db
     * @return
     * @throws SQLException
     */
    public static PreparedStatement genInsertSQLStatement(String tableName,Connection conn,DbTypes db) throws SQLException {
    	String insertSQL=DatabaseUtils.getInsertStatement(tableName,conn,db);
    	conn.setAutoCommit(false);
		return conn.prepareStatement(insertSQL);
    	
    }
	/**
	 * Execute Sql file
	 * @param file
	 * @param conn
	 * @throws FileNotFoundException
	 */
	public static void excuteSqlScript(String file,Connection conn) throws FileNotFoundException {
		Reader reader = new BufferedReader(new FileReader(file));
		ScriptRunner sr = new ScriptRunner(conn);
		sr.setAutoCommit(true);
		sr.setStopOnError(true);
		sr.runScript(reader);
	}

	/**
	 * Execute sql query which not return sql results
	 * this function applies to Insert, Update & Delete data
	 * @param sql
	 * @param con
	 * @throws SQLException
	 */
	public static void execSql(String sql, Connection conn) throws SQLException {
		stmt = conn.createStatement();
		stmt.execute(sql);
	}
	/**
	 * Delete all data in a table
	 * @param table
	 * @param conn
	 * @throws SQLException
	 */
	public static void deleteAllDataTable(String table, Connection conn) throws SQLException {
		String sql="DELETE FROM "+table;
		stmt = conn.createStatement();
		stmt.execute(sql);
	}
	/**
	 * Delete data in a table with condition
	 * @param table
	 * @param condition
	 * @param conn
	 * @throws SQLException
	 */
	public static void deleteDataTableWithConditions(String table,String condition,Connection conn) throws SQLException {
		String sql="DELETE FROM "+table+" "+ condition;
		stmt = conn.createStatement();
		stmt.execute(sql);
	}

	/***************************************************RESULTS OF SQL STATEMENT********************************************************
	 * ***************************************************************************************************************************
	 */
    /**
     * Get difference values between lists
     * @param srcQuery
     * @param tagQuery
     * @param srcConn
     * @param tagConn
     * @return
     * @throws SQLException
     */
    public static List<Object> getDiffResultQueries(String srcQuery,String tagQuery, Connection srcConn, Connection tagConn) throws SQLException {
    	List<Object> srcValues =getColumnValues(srcQuery,srcConn);
    	List<Object> tagValues = getColumnValues(tagQuery,tagConn);
		List<Object> diffList = tagValues.stream().filter(obj -> !srcValues.contains(obj)).collect(Collectors.toList()); 
		return diffList;
    	
    }
    
	/**
	 * Get all values of many columns in Sql query
	 * @param sql
	 * @param con
	 * @param Column
	 * @return
	 * @throws SQLException
	 */
	public static List<Object> getColumnValues(String sql,Connection con) throws SQLException {
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		List<Object> values = new ArrayList<>();
		int columnCount =rs.getMetaData().getColumnCount();
		while(rs.next()){
			for(int i=1;i<=columnCount;i++) {
				values.add(rs.getObject(i));
			}
		}
		values.removeAll(Collections.singleton(""));
		
		List<Object> newlist=values.stream().filter(Objects::nonNull).collect(Collectors.toList());
		System.out.println("values_1:"+newlist);
		return newlist;
	}

	
	/**
	 * Get all values of a specific column by index
	 * @param sql
	 * @param con
	 * @param Column
	 * @return
	 * @throws SQLException
	 */

	public static List<Object> getColumnValues(String sql,Connection con,int Column) throws SQLException {
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Object> values = new ArrayList<>();
		while(rs.next()){
			info("-------------------------------------");
			info(rs.getString(1));
			info("-------------------------------------");
			values.add(rs.getObject(Column));
		}
		return values;
	}

	/**
	 * Get all values of a column by name
	 * @param sql
	 * @param con
	 * @param colName
	 * @return
	 * @throws SQLException
	 */
	public static List<Object> getColumnValues(String sql,Connection con,String colName) throws SQLException {
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		List<Object> values = new ArrayList<>();
		while(rs.next()){
			info("-------------------------------------");
			values.add(rs.getObject(colName));
		}
		return values;
	}

	

}
