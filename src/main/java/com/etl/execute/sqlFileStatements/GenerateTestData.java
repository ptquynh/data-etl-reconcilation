package com.etl.execute.sqlFileStatements;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.etl.common.ExcelToObjectMapper;
import com.etl.common.Utils;
import com.etl.common.database.DatabaseUtils;
import com.etl.common.database.DatabaseUtils.DbTypes;
import com.etl.common.datasource.DBConn;
import com.etl.common.tables.Book;

public class GenerateTestData {
	
	public static void main(String[] args) throws Exception {
		System.out.println("----------------------------");
		//Init setup
		//Connect to Local database
		String dbUrl=args[0];
		String dbUser=args[1];
		String dbPass=args[2];
		DbTypes dbType=DbTypes.valueOf(args[3]);
		String tbName=args[4];
		String inputExcel=args[5];
		String outputExcel=args[6];
		Connection conn = DBConn.connectDB(dbUrl,dbUser,dbPass,dbType);
		PreparedStatement prestmt = DatabaseUtils.genInsertSQLStatement(tbName, conn,dbType);
		
		//Get the path of sql & Excel file		
		String excelFile = Utils.getFilePath(inputExcel);
		String sqlFile = Utils.getFilePath(outputExcel);
		
		//Generate insert Sql for Book table
		sqlStatementBookTb(excelFile,sqlFile,prestmt);
		//Execute insert Sql file
		DatabaseUtils.excuteSqlScript(sqlFile, conn);
		
		//conn.close();
		//prestmt.close();
		System.out.println("---------END-------------------");
	}
	
	/**
	 * Generate sql file for book table
	 * @param excelFile
	 * @param sqlFile
	 * @throws Exception
	 */
	public static void sqlStatementBookTb(String excelFile,String sqlFile,PreparedStatement prestmt) throws Exception {
		//Get data from Object class to List
		//Convert Excel file to Object class
		ExcelToObjectMapper mapper = new ExcelToObjectMapper(excelFile,0);
		List<Book> books= mapper.map(Book.class);
		
		//Delete old sql file
		Utils.deleteFile(sqlFile);
		FileWriter fw = new FileWriter(sqlFile,true);
		
		for (Book book : books) {
            prestmt.setObject(1,book.getOpenYYYY());
            prestmt.setObject(2,book.getOpenMM());
            prestmt.setObject(3,book.getMetricMonth());
            prestmt.setObject(4,book.getBaseTxnIssued());
            prestmt.setObject(5,book.getAllTxnIssued());
            fw.write(prestmt+";\n");
        }
		fw.close();
	}
	
}
