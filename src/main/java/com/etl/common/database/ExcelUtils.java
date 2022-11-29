package com.etl.common.database;


import static com.etl.common.TestLogger.info;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelUtils {
	private Connection conn;
	private Fillo fillo;
	private Workbook workbookData;
	private String excelPath;
	//private Cell cell;
	
	public ExcelUtils(String excelPath) throws FilloException {
		info("Connecting to excel file...");
		this.fillo=new Fillo();
		this.excelPath=excelPath;
	}
	/**
	 * Get connection of the excel file
	 * @param excelPath
	 * @return
	 * @throws FilloException
	 */
	public Connection getConnection(String excelPath) throws FilloException {
		return this.fillo.getConnection(this.excelPath);
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
	public List<Object> getColumnValues(String sql,Connection con,int Column) throws SQLException, FilloException {
		Recordset recordset=this.conn.executeQuery(sql);
	    
	    List<Object> values = new ArrayList<>();
	    while(recordset.next()){
	    	info("-------------------------------------");
		    info(recordset.getField(Column).toString());
		    System.out.println(recordset.getField(Column));
		    info("-------------------------------------");
	        values.add(recordset.getField(Column));
	    }
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

	
//	/**
//	 * get integer value of a cell
//	 * @param row
//	 * @param cell
//	 * @return
//	 */
//	public int getCellNumbericData(Cell cell) {
//		int cellValue=0;
//		if(this.cell!=null) {
//		
//			switch (cell.getCellType()) {
//			case Cell.CELL_TYPE_NUMERIC:
//				cellValue=(int)cell.getNumericCellValue();
//				break;
//			case Cell.CELL_TYPE_STRING:
//				cellValue=Integer.valueOf(cell.getStringCellValue());
//				break;
//			}
//		}
//		return cellValue;
//		
//	}
//	/**
//	 * Get string value of a cell
//	 * @param row
//	 * @param cell
//	 * @return
//	 */
//	public String getCellStringData(Cell cell) {
//		String cellValue=null;
//		if(cell!=null) {
//		
//			switch (cell.getCellType()) {
//			case Cell.CELL_TYPE_NUMERIC:
//				cellValue=String.valueOf(cell.getNumericCellValue());
//				break;
//			case Cell.CELL_TYPE_STRING:
//				cellValue=cell.getStringCellValue();
//				break;
//			}
//		}
//		return cellValue;
//	}
//	
//	/**
//	 * get date value of a cell
//	 * @param cell
//	 * @return
//	 */
//	public Date getCellDateData(Cell cell) {
//		Date cellValue=null;
//		if(cell!=null) {
//			cellValue=cell.getDateCellValue();
//		}
//		return cellValue;
//	}
	
}
