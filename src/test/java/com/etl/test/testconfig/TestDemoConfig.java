package com.etl.test.testconfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.etl.common.TestLogger.info;

import java.sql.SQLException;

public class TestDemoConfig {
	
	@BeforeClass
	public void beforeClass() throws ClassNotFoundException, SQLException {
		info("beforeClass");
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() throws SQLException {
		info("afterClass");
		System.out.println("afterClass");
	}
}
