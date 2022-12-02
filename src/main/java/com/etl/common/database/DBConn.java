package com.etl.common.database;

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
	 * Connect to a JDBC Database
	 * @param dburl
	 * @param dbuser
	 * @param dbpass
	 * @param dbtype
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection connectDB(String dburl,String dbuser,String dbpass, DbTypes dbtype) throws ClassNotFoundException, SQLException {
		return dbConn(dburl,dbuser,dbpass,dbtype);
	}


}
