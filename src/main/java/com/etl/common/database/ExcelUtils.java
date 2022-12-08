package com.etl.common.database;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtils {
	private static Fillo fillo;
	private Workbook workbookData;
	static Recordset rs;
	
	
	/**
	 * Get connection of the excel file
	 * @param excelPath
	 * @return
	 * @throws FilloException
	 */
	public static Connection getConnection(String excelPath) throws FilloException {
		    fillo=new Fillo();
			return fillo.getConnection(excelPath);
	}
	/**
	 * Get all values of the column
	 * @param sql
	 * @param con
	 * @param Column
	 * @return
	 * @throws SQLException
	 * @throws FilloException
	 */
	public static List<Object> getColumnValues(String sql,Connection con) throws SQLException, FilloException {
		
		rs = con.executeQuery(sql);
		List<Object> values = new ArrayList<>();
		int totalCol = rs.getFieldNames().size();
		while(rs.next()){
			for(int i=0;i<totalCol;i++) {
				values.add(rs.getField(rs.getFieldNames().get(i)));
			}
		}
		values.stream().filter(Objects::nonNull).collect(Collectors.toList());
		values.removeAll(Collections.singleton(""));
		System.out.println("values_excel:"+values);
		return values;
	}
	

	/**
	 * Get Sheet data in Excel
	 * @param filePath
	 * @param SheetIndex
	 * @return
	 * @throws IOException
	 */
	public Sheet getSheet(String filePath,int SheetIndex) throws IOException {
		FileInputStream inputStream = new FileInputStream(filePath);
		this.workbookData = new XSSFWorkbook(inputStream);
		return this.workbookData.getSheetAt(SheetIndex);
	}
}
