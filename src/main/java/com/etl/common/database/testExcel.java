package com.etl.common.database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.etl.common.Utils;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

public class testExcel {

	static Recordset rs;
	
	public static void main(String[] args) throws FilloException, SQLException {
		// TODO Auto-generated method stub
		String sourceQuery="SELECT col_name,data_type,comment FROM CYC_INTF";
		String excelFile=Utils.getFilePath("input-excel-file/schema/HIVE_INTF_SCHEMA.xlsx");
		Connection conn = ExcelUtils.getConnection(excelFile);
		
		getColumnValues(sourceQuery,conn);
		
		rs.close();
		conn.close();
	}
	
	
	public static List<Object> getColumnValues(String sql,Connection con) throws SQLException, FilloException {
		
		rs = con.executeQuery(sql);
		List<Object> values = new ArrayList<>();
		int totalCol = rs.getFieldNames().size();
		while(rs.next()){
			for(int i=0;i<totalCol;i++) {
				values.add(rs.getField(rs.getFieldNames().get(i)));
			}
		}
		System.out.println("values_excel:"+values);
		return values;
	}

}
