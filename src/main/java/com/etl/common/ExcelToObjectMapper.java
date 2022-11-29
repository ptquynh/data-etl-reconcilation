package com.etl.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import static com.etl.common.TestLogger.info;

public class ExcelToObjectMapper {

	private Workbook workbook;
	private int col;
	/**
	 * Set a Excel file to this class
	 * @param filePath
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public ExcelToObjectMapper(String filePath,int col) throws InvalidFormatException, IOException {
		workbook = createWorkBook(filePath);
		this.col=col;
	}
	/**
	 * Create a new workbook
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 */
	private Workbook createWorkBook(String file) throws IOException, InvalidFormatException {
        InputStream inp = new FileInputStream(file);
        return WorkbookFactory.create(inp);
    }
	/**
	 * Create a mapping between excel file and model object
	 * @param <T>
	 * @param cls
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public <T> ArrayList<T> map(Class<T> cls) throws Exception {
	        ArrayList<T> list = new ArrayList<T>();

	        Sheet sheet = workbook.getSheetAt(col);
	        int lastRow = sheet.getLastRowNum();
	        for (int i=1; i<=lastRow;i++) {
	            Object obj = cls.newInstance();
	            Field[] fields = obj.getClass().getDeclaredFields();
	            for (Field field: fields) {
	                String fieldName = field.getName();
	                int index = getHeaderIndex(fieldName, workbook);
	                Cell cell = sheet.getRow(i).getCell(index);
	                Field classField = obj.getClass().getDeclaredField(fieldName);
	                setObjectFieldValueFromCell(obj, classField, cell);
	            }
	            list.add( (T) obj);
	        }
	        return list;
	    }
	/**
	 * Return sheet name
	 * @param col
	 * @return
	 */
	public String getSheetName(int col) {
		return workbook.getSheetName(col);
	}
	 /**
	  * Get index of headers
	  * @param headerName
	  * @param workbook
	  * @return
	  * @throws Exception
	  */
	 private int getHeaderIndex(String headerName, Workbook workbook) throws Exception {
	        Sheet sheet = workbook.getSheetAt(0);
	        int totalColumns = sheet.getRow(0).getLastCellNum();
	        int index = -1;
	        for (index=0; index<totalColumns;index++) {
	            Cell cell = sheet.getRow(0).getCell(index);
	            if(cell.getStringCellValue().toLowerCase().equals(headerName.toLowerCase())) {
	                break;
	            }
	        }
	        if(index == -1) {
	            info("Invalid object field name provided.");
	        }
	        return index;
	    }
	 /**
	  * Set object's fields from Excel file
	  * @param obj
	  * @param field
	  * @param cell
	  */
	 private void setObjectFieldValueFromCell(Object obj, Field field, Cell cell){
	        Class<?> cls = field.getType();
	        field.setAccessible(true);
	        if(cls == String.class) {
	            try {
	                field.set(obj, cell.getStringCellValue());
	            }catch (Exception e) {
	                try {
	                    field.set(obj, null);
	                } catch (IllegalAccessException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	        else if(cls == Date.class) {
	            try {
	                Date date = cell.getDateCellValue();
	                field.set(obj, date);
	            }catch (Exception e) {
	                try {
	                    field.set(obj, null);
	                } catch (IllegalAccessException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	        else if(cls == int.class || cls == long.class || cls == float.class || cls == double.class ){
	            double value = cell.getNumericCellValue();
	            try {
	                if (cls == int.class) {
	                    field.set(obj, (int) value);
	                }
	                else if (cls == long.class) {
	                    field.set(obj, (long) value);
	                }
	                else if (cls == float.class) {
	                    field.set(obj, (float) value);
	                }
	                else {
	                    //Double value
	                    field.set(obj, value);
	                }
	            }catch (Exception e) {
	                try {
	                    field.set(obj, null);
	                } catch (IllegalAccessException e1) {
	                    System.out.println("chinna - ");
	                    e1.printStackTrace();
	                }
	            }
	        }
	        else if(cls == boolean.class) {
	            boolean value = cell.getBooleanCellValue();
	            try {
	                field.set(obj, value);
	            }catch (Exception e) {
	                try {
	                    field.set(obj, null);
	                } catch (IllegalAccessException e1) {
	                    e1.printStackTrace();
	                }
	            }
	        }
	        
	        else {
	            info("Unsupported data type.");
	        }

	    }

}
