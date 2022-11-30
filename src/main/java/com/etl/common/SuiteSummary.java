package com.etl.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.internal.ResultMap;

public class SuiteSummary {

	private SuiteSummary() {
		// Instantiation via builder
	}

	private Date startDate;

	private Date endDate;
	private long duration;

	private String name;

	private IResultMap passedTests = new ResultMap();

	private IResultMap skippedTests = new ResultMap();

	private IResultMap failedTests = new ResultMap();

	private IResultMap failedButWithinSuccessPercentageTests = new ResultMap();

	public static SuiteSummary build(ISuite suite) {
		Objects.requireNonNull(suite);
		SuiteSummary summary = new SuiteSummary();
		summary.name = suite.getName();
		// @formatter:off
		suite
			.getResults()
			.values()
			.forEach(s -> s.getTestContext()
					.getPassedTests()
					.getAllResults()
					.stream()
					.forEach(t -> summary.passedTests.addResult(t, t.getMethod())));
		suite
			.getResults()
			.values()
			.forEach(s -> s.getTestContext()
					.getSkippedTests()
					.getAllResults()
					.stream()
					.forEach(t -> summary.skippedTests.addResult(t, t.getMethod())));
		suite
			.getResults()
			.values()
			.forEach(s -> s.getTestContext()
					.getFailedTests()
					.getAllResults()
					.stream()
					.forEach(t -> summary.failedTests.addResult(t, t.getMethod())));
		suite
			.getResults()
			.values()
			.forEach(s -> s.getTestContext()
					.getFailedButWithinSuccessPercentageTests()
					.getAllResults()
					.stream()
					.forEach(t -> summary.failedButWithinSuccessPercentageTests.addResult(t, t.getMethod())));		
		suite
			.getResults()
			.values()
			.forEach(s -> s.getTestContext()
					.getFailedButWithinSuccessPercentageTests()
					.getAllResults()
					.stream()
					.forEach(t -> summary.failedButWithinSuccessPercentageTests.addResult(t, t.getMethod())));		

		// @formatter:on
		summary.startDate = suite.getResults().values().stream().map(s -> s.getTestContext().getStartDate())
				.min(Date::compareTo).get();
		summary.endDate = suite.getResults().values().stream().map(s -> s.getTestContext().getEndDate())
				.max(Date::compareTo).get();
		return summary;
	}

	public Date getStartDate() {
		return startDate;
	}
	
	public String getDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public long getMilis() {
		long milis=startDate.getTime()-endDate.getTime();
		return milis;
	}
	
	public double getMinus() {
		return (startDate.getTime()-endDate.getTime())/1000/ 60;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public long getDuration(Date startDate, Date endDate) {
		//this.duration=startDate.getTime()-endDate.getTime();
		return this.duration;
	}

	public Date getEndDate() {
	//	DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		//return dateFormat.format(endDate);
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IResultMap getPassedTests() {
		return passedTests;
	}

	public void setPassedTests(IResultMap passedTests) {
		this.passedTests = passedTests;
	}

	public IResultMap getSkippedTests() {
		return skippedTests;
	}

	public void setSkippedTests(IResultMap skippedTests) {
		this.skippedTests = skippedTests;
	}

	public IResultMap getFailedTests() {
		return failedTests;
	}

	public void setFailedTests(IResultMap failedTests) {
		this.failedTests = failedTests;
	}

	public IResultMap getFailedButWithinSuccessPercentageTests() {
		return failedButWithinSuccessPercentageTests;
	}

	public void setFailedButWithinSuccessPercentageTests(IResultMap failedButWithinSuccessPercentageTests) {
		this.failedButWithinSuccessPercentageTests = failedButWithinSuccessPercentageTests;
	}

}
