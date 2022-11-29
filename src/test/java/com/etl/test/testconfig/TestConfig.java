package com.etl.test.testconfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.etl.common.database.DatabaseUtils;

import static com.etl.common.TestLogger.info;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConfig {
	public Connection srcConn;
	public Connection tagConn;
	
	@BeforeClass
	public void beforeClass() throws ClassNotFoundException, SQLException {
		info("beforeClass");
		
		srcConn=DatabaseUtils.oracleDB();
		tagConn=DatabaseUtils.oracleDB();
		
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() throws SQLException {
		info("afterClass");
		srcConn.close();
		tagConn.close();
		System.out.println("afterClass");
	}
}
