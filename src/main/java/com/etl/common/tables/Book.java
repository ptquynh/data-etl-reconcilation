package com.etl.common.tables;

import java.sql.PreparedStatement;

public class Book {
  
	private int open_yyyy;
	private int open_mm;
	private String metricmonth;
	private int basetxn_issued;
	private int alltxn_issued;
	
	public int getOpenYYYY() {
		return open_yyyy;
	}
	
	public int getOpenMM() {
		return open_mm;
	}
	
	public String getMetricMonth() {
		return metricmonth;
	}
	
	public int getBaseTxnIssued() {
		return basetxn_issued;
	}
	
	public int getAllTxnIssued() {
		return alltxn_issued;
	}
	
	public void setOpenYYYY(int open_yyyy) {
		this.open_yyyy= open_yyyy;
	}
	
	public void setOpenMM(int open_mm) {
		this.open_mm= open_mm;
	}
	
	public void setMetricMonth(String metricmonth) {
		this.metricmonth= metricmonth;
	}
	
	public void setBaseTxnIssued(int basetxn_issued) {
		this.basetxn_issued= basetxn_issued;
	}
	
	public void setAllTxnIssued(int alltxn_issued) {
		this.alltxn_issued= alltxn_issued;
	}
	
	public PreparedStatement getStatement() {
		return null;
		
	}
}
