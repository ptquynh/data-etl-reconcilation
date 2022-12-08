package com.etl.test.testconfig;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.codoid.products.exception.FilloException;
import com.etl.common.Utils;
import com.etl.common.database.DBConn;
import com.etl.common.database.ExcelUtils;
import com.etl.common.database.DatabaseUtils.DbTypes;
import static com.etl.common.TestLogger.info;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConfig {
	public Connection srcConn;
	public Connection tagConn;
	public com.codoid.products.fillo.Connection srcExcelConn;	
	
	@BeforeClass
	@Parameters({"srcDbUrl","srcDbUser", "srcDbPass", "srcDbType","targDbUrl","targDbUser", "targDbPass", "targDbType","excelPath"})
	public void beforeClass(String srcDbUrl,String srcDbUser,String srcDbPass,String srcDbType,
			String targDbUrl,String targDbUser,String targDbPass,String targDbType,String excelPath) throws ClassNotFoundException, SQLException, FilloException {
		info("beforeClass");
		//Create connection to Source Database
		srcConn=DBConn.connectDB(srcDbUrl,srcDbUser,srcDbPass,DbTypes.valueOf(srcDbType));
		//Create connection to Target Database
		tagConn=DBConn.connectDB(targDbUrl,targDbUser,targDbPass,DbTypes.valueOf(targDbType));
		String excelFile=Utils.getFilePath(excelPath);
		srcExcelConn=ExcelUtils.getConnection(excelFile);
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() throws SQLException {
		info("afterClass");
		//Close connection to Source Database
		srcConn.close();
		//Close connection to Target Database
		tagConn.close();
		srcExcelConn.close();
		System.out.println("afterClass");
	}
}
