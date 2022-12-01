package com.etl.common;


public class TestBase {
	
	
	
	public int loopCount = 0;	
	

	/*========System Property====================*/

	protected Boolean isRandom;
	protected Boolean isUseFile;

	protected String jdbcDriver;
	protected String dbUrl;
	protected String user;
	protected String pass;


	/*========Default System Property=============*/

	public final static Boolean DEFAULT_ISRANDOM = true;
	public final static Boolean DEFAULT_ISUSEFILE = true;
	
	//JDBC Driver
	public final static String JDBC_DRIVER_ORACLE = "oracle.jdbc.OracleDriver";
	public final static String JDBC_DRIVER_POSTGRESQL = "org.postgresql.Driver";
	public final static String JDBC_DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	public final static String JDBC_DRIVER_MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public final static String JDBC_DRIVER_HIVE = "org.apache.hive.jdbc.HiveDriver";
	
	// Oracle JDBC driver.
	public final static String DB_URL_ORACLE = "jdbc:oracle:thin:@10.0.9.226:1521:orcl";
	public final static String USER_ORACLE = "rating_owner";
	public final static String PASS_ORACLE = "rating_owner";
	
	// Postgresql JDBC driver.
	public final static String DB_URL_POSTGRESQL_AIRFLOW = "jdbc:postgresql://10.0.9.226:5433/airflow";
	public final static String USER_POSTGRESQL_AIRFLOW = "airflow";
	public final static String PASS_POSTGRESQL_AIRFLOW = "airflow";
	
	// Postgresql JDBC driver.
	public final static String DB_URL_POSTGRESQL_VETCCALL = "jdbc:postgresql://10.0.9.222:5432/vetc-call";
	public final static String USER_POSTGRESQL_VETCCALL = "carpla_staging";
	public final static String PASS_POSTGRESQL_VETCCALL = "123456789";
	
	// Postgresql JDBC driver.
	public final static String DB_URL_POSTGRESQL_LOCAL = "jdbc:postgresql://localhost:5432/postgres";
	public final static String USER_POSTGRESQL_LOCAL = "postgres";
	public final static String PASS_POSTGRESQL_LOCAL = "123456789";
	
	//MySql JDBC driver.
	public final static String DB_URL_MYSQL = "jdbc:mysql://127.0.0.1:3306/test";
	public final static String USER_MYSQL = "root";
	public final static String PASS_MYSQL = "password";
	
	//MSSql JDBC driver.
	public final static String DB_URL_MSSQL = "jdbc:sqlserver://1.2.3.4:1433;databaseName=mydatabase";
	public final static String USER_MSSQL = "root";
	public final static String PASS_MSSQL = "password";
	
	//HIVE JDBC driver.
	public final static String DB_URL_HIVE = "jdbc:hive2://10.0.9.226:10000/default";
	public final static String USER_HIVE = "truongnh@10.0.9.226";
	public final static String PASS_HIVE = "123456789";
	
	//test data file
	public final static String INPUT_EXCEL_PATH_BOOK="input-excel-file/book.xlsx";
	public final static String OUPUT_SQL_PATH_BOOK="output-sql-file/book.sql";
	
	
	//SQL query get Metadata
	public final static String SQL_META_POSTGRESQL="SELECT * FROM information_schema.columns WHERE table_name = ? order by ordinal_position";
	public static final String SQL_META_ORACLE ="SELECT * FROM all_tab_columns WHERE table_name=? ORDER BY COLUMN_ID";
	public static final String SQL_META_MYSQL = "SELECT * FROM information_schema.columns WHERE table_name = ? order by ordinal_position";
	public static final String SQL_META_MMSQL = "SELECT * FROM information_schema.columns WHERE table_name = ? order by ordinal_position";
	public static final String SQL_META_HIVE = "describe ?";
	
	
	//Email information
	public final static String EMAIL_FROM = "qateam.data@gmail.com";
	public final static String EMAIL_PASS ="ggpkczxwvxzuostr";
	public final static String EMAIL_TO="quynhpt@carpla.vn";
	
	
	//Test Report information
	public final static String TEST_REPORT_FILE_NAME = "test-summary-report.html";
	public final static String TEST_REPORT_TITLE= "Test Summary Report";
	public final static String TEST_REPORT_PATH= "/test-output/"+TEST_REPORT_FILE_NAME;

	/**
	 * Get System Property
	 */
	public void getSystemProperty(){
		
		jdbcDriver = System.getProperty("jdbcDriver");
		dbUrl = System.getProperty("dbUrl");
		user = System.getProperty("user");
		pass = System.getProperty("pass");


		if (jdbcDriver==null) jdbcDriver = JDBC_DRIVER_ORACLE;
		if (dbUrl==null) dbUrl = DB_URL_ORACLE;
		if (user==null) user = USER_ORACLE;
		if (pass==null) pass = PASS_ORACLE;

		if (isRandom==null) isRandom = DEFAULT_ISRANDOM;
		if (isUseFile==null) isUseFile = DEFAULT_ISUSEFILE;
	}
	
}