package com.etl.common.tables;
import java.util.*;
public class ClosedCycle {
		private int cycle_id;
		private String cycle_code;
		private String cycle_name;
		private String status;
		private String boo;
		private String close_time_code;


	public int getCycleId(){
		return this.cycle_id;
		
	}


	public String getCycleCode(){
		return this.cycle_code;
		
	}


	public String getCycleName(){
		return this.cycle_name;
		
	}


	public String getStatus(){
		return this.status;
		
	}


	public String getBoo(){
		return this.boo;
		
	}


	public String getCloseTimeCode(){
		return this.close_time_code;
		
	}
		
}