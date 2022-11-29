package com.etl.common;

public class TestCaseModel {

	public String testId;
	public String summary;
	public String description;
	public String precondition;
	public String priority;
	public String labels;
	public String components;
	public String steps;
	public String sourceDB;
	public String targetDB;
	public String sourceQuery;
	public String targetQuery;
	public String expectedResult;
	public String actualResult;
	public String testResults;
	
	public String getTestID() {
		return this.testId;
	}
	
	public String getSummary() {
		return this.summary;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getPrecondition() {
		return this.precondition;
	}
	
	public String getPriority() {
		return this.priority;
	}
	
	public String getLabels() {
		return this.labels;
	}
	
	public String getComponents() {
		return this.components;
	}
	
	public String getSteps() {
		return this.steps;
	}
	
	public String getSourceDB() {
		return this.sourceDB;
	}
	
	public String getTargetDB() {
		return this.targetDB;
	}
	
	public String getSourceQuery() {
		return this.sourceQuery;
	}
	
	public String getTargetQuery() {
		return this.targetQuery;
	}
	public String getExpectedResult() {
		return this.expectedResult;
	}
	public void setActualResult(String actualResult) {
		this.actualResult=actualResult;
	}
}
