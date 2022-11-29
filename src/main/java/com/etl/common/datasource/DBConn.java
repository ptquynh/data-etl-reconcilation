package com.etl.common.datasource;

import static com.etl.common.TestLogger.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.etl.common.TestBase;
import com.etl.common.database.DatabaseUtils.DbTypes;

public class DBConn{

	/***************************************************DATABASE CONNNECTION********************************************************
	 * ****************************************************************************************************************************
	 */
	/**
	 * Create connection driver for the database
	 * @param url
	 * @param user
	 * @param pass
	 * @param db
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection dbConn(String url, String user,String pass,DbTypes db) throws ClassNotFoundException, SQLException {
		info("Connecting to database...");
		switch(db) {
		case ORACLE:
			Class.forName(TestBase.JDBC_DRIVER_ORACLE);
			break;
		case POSTGRESQL:
			Class.forName(TestBase.JDBC_DRIVER_POSTGRESQL);
			break;
		case MYSQL:
			Class.forName(TestBase.JDBC_DRIVER_MYSQL);
			break;
		case MMSQL:
			Class.forName(TestBase.JDBC_DRIVER_MSSQL);
			break;
		case HIVE:
			Class.forName(TestBase.JDBC_DRIVER_HIVE);
			break;
		}
		return DriverManager.getConnection(url,user,pass);
	}
	/**
	 * Create connection to Postgresql localhost
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection postgreSqlDBLocal() throws ClassNotFoundException, SQLException {
		return dbConn(TestBase.DB_URL_POSTGRESQL_LOCAL,
				TestBase.USER_POSTGRESQL_LOCAL, 
				TestBase.PASS_POSTGRESQL_LOCAL,
				DbTypes.POSTGRESQL);
	}

	/**
	 * Create connection to Postgresql of vetc call
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection postgreSqlDBVetcCall() throws ClassNotFoundException, SQLException {
		return dbConn(TestBase.DB_URL_POSTGRESQL_VETCCALL,
				TestBase.USER_POSTGRESQL_VETCCALL, 
				TestBase.PASS_POSTGRESQL_VETCCALL,
				DbTypes.POSTGRESQL);
	}

	/**
	 * Create connection to Postgresql of vetc call
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection oracleDB() throws ClassNotFoundException, SQLException {
		return dbConn(TestBase.DB_URL_ORACLE,
				TestBase.USER_ORACLE, 
				TestBase.USER_ORACLE,
				DbTypes.ORACLE);
	}


}
