package com.etl.common.tables;
import java.util.*;
public class TollCycle {
		private int toll_id;
		private int cycle_id;
		private String status;
		private int order_id;
		private int toll_cycle_id;


	public int getTollId(){
		return this.toll_id;
		
	}


	public int getCycleId(){
		return this.cycle_id;
		
	}


	public String getStatus(){
		return this.status;
		
	}


	public int getOrderId(){
		return this.order_id;
		
	}


	public int getTollCycleId(){
		return this.toll_cycle_id;
		
	}
		
}