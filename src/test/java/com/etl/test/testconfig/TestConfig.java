package com.etl.test.testconfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.etl.common.database.DBConn;
import com.etl.common.database.DatabaseUtils.DbTypes;

import static com.etl.common.TestLogger.info;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConfig {
	public Connection srcConn;
	public Connection tagConn;
	
	@BeforeClass
	@Parameters({"srcDbUrl","srcDbUser", "srcDbPass", "srcDbType","targDbUrl","targDbUser", "targDbPass", "targDbType"})
	public void beforeClass(String srcDbUrl,String srcDbUser,String srcDbPass,String srcDbType,
			String targDbUrl,String targDbUser,String targDbPass,String targDbType) throws ClassNotFoundException, SQLException {
		info("beforeClass");
		
		//Create connection to Source Database
		srcConn=DBConn.connectDB(srcDbUrl,srcDbUser,srcDbPass,DbTypes.valueOf(srcDbType));
		//Create connection to Target Database
		tagConn=DBConn.connectDB(targDbUrl,targDbUser,targDbPass,DbTypes.valueOf(targDbType));
		
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() throws SQLException {
		info("afterClass");
		//Close connection to Source Database
		srcConn.close();
		//Close connection to Target Database
		tagConn.close();
		System.out.println("afterClass");
	}
}
