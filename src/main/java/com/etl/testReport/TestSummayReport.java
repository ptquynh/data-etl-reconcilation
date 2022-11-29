package com.etl.testReport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import com.etl.common.SuiteSummary;
import com.etl.common.Utils;

public class TestSummayReport implements ISuiteListener{

	private PrintWriter writer;
	private String reportFileName = "test-summary-report.html";
	private String reportTitle= "Test Summary Report";
	private String pathReport=Utils.getAbsolutePath("test-ouput");
	
	private int m_row;
	private Date startDate;
	private Date endDate;
	
	@Override
	public void onFinish(ISuite suite) {
		try {
			System.out.print("pathReport:"+pathReport);
			writer = createWriter(pathReport);
		} catch (IOException e) {
			System.err.println("Unable to create output file");
			e.printStackTrace();
			return;
		}
		
		startHtml(writer);
		writeReportTitle(reportTitle);
		testSummarySection(suite);
		
		endHtml(writer);
		writer.flush();		
		writer.close();
	}
	
//	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
//			String outdir) {
//		try {
//			writer = createWriter(outdir);
//		} catch (IOException e) {
//			System.err.println("Unable to create output file");
//			e.printStackTrace();
//			return;
//		}
//
//		startHtml(writer);
//		writeReportTitle(reportTitle);
//		testSummarySection(suites);
//		//generateSuiteSummarySection(suites);
////		generateMethodSummaryReport(suites);
////		generateMethodDetailReport(suites);
////		endHtml(writer);
//		writer.flush();
//		writer.close();
//	}
	
	protected PrintWriter createWriter(String outdir) throws IOException {
		new File(outdir).mkdirs();
		return new PrintWriter(new BufferedWriter(new FileWriter(new File(outdir, reportFileName))));
	}
	
	protected void startHtml(PrintWriter out) {
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
		out.println("<title>Test Summary Report</title>");
		out.println("<style type=\"text/css\">");
		out.println("table {margin-bottom:10px;border-collapse:collapse;empty-cells:show}");
		out.println("td,th {border:1px solid #009;padding:.25em .5em}");
		out.println(".result th {vertical-align:bottom}");
		out.println(".param th {padding-left:1em;padding-right:1em}");
		out.println(".param td {padding-left:.5em;padding-right:2em}");
		out.println(".stripe td,.stripe th {background-color: #E6EBF9}");
		out.println(".numi,.numi_attn {text-align:right}");
		out.println(".total td {font-weight:bold}");
		out.println(".passedodd td {background-color: #0A0}");
		out.println(".passedeven td {background-color: #3F3}");
		out.println(".skippedodd td {background-color: #CCC}");
		out.println(".skippedodd td {background-color: #DDD}");
		out.println(".failedodd td,.numi_attn {background-color: #F33}");
		out.println(".failedeven td,.stripe .numi_attn {background-color: #D00}");
		out.println(".stacktrace {white-space:pre;font-family:monospace}");
		out.println(".totop {font-size:85%;text-align:center;border-bottom:2px solid #000}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

	}
	
	protected void writeReportTitle(String title) {
		writer.print("<center><h1>" + title + " - " + getDateAsString() + "</h1></center>");
	}
	
	private String getDateAsString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void testSummarySection(ISuite suite) {
		writer.println("<h3>Test Status Summary</h3>");
		writer.println("<hr>");
		writer.println("<table border=\"0\">");
		writer.println("<tr>");
		writer.println("<td style=\"padding-right:10px\">Start Date</td>");
		writer.println("<td>"+SuiteSummary.build(suite).getDateTime()+"</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td style=\"padding-right:10px\">Duration</td>");
		//writer.println("<td>$numberTool.format(\"#0.00\", "+String.valueOf(getMinus)+") minutes ("+getMili(suite)+")</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td style=\"padding-right:10px\">Total Tests</td>");
		writer.println("<td>"+totalTests(suite)+"</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td style=\"padding-right:10px\">Passed Tests</td>");
		writer.println("<td>"+SuiteSummary.build(suite).getPassedTests().size()+"</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td style=\"padding-right:10px\">Failed Tests</td>");
		writer.println("<td>"+SuiteSummary.build(suite).getFailedTests().size()+"</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td style=\"padding-right:10px\">Skipped Tests</td>");
		writer.println("<td>"+SuiteSummary.build(suite).getSkippedTests().size()+"</td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td style=\"padding-right:10px\">Failed But Within Succuess Percentage Tests</td>");
		writer.println("<td>"+SuiteSummary.build(suite).getFailedButWithinSuccessPercentageTests().size()+"</td>");
		writer.println("</tr>");
		writer.println("</table>");
	}
	/**
	 * Generate Summary Section
	 * @param suites
	 */
	public void generateSuiteSummarySection(List<ISuite> suites) {
		tableStart("testOverview", null);
		writer.print("<tr>");
		tableColumnStart("Test Scenarios");
		tableColumnStart("Passed");
		tableColumnStart("Skipped");
		tableColumnStart("Failed");
		tableColumnStart("Source Data");
		tableColumnStart("Target Data");
		tableColumnStart("Start<br/>Time");
		tableColumnStart("End<br/>Time");
		tableColumnStart("Total<br/>Time(hh:mm:ss)");
		tableColumnStart("Included<br/>Groups");
		tableColumnStart("Excluded<br/>Groups");

		writer.println("</tr>");
		
//		NumberFormat formatter = new DecimalFormat("#,##0.0");
//		int qty_tests = 0;
//		int qty_pass_m = 0;
//		int qty_pass_s = 0;
//		int qty_skip = 0;
//		long time_start = Long.MAX_VALUE;
//		int qty_fail = 0;
//		long time_end = Long.MIN_VALUE;
//		m_testIndex = 1;
//		for (ISuite suite : suites) {
//			if (suites.size() >= 1) {
//				titleRow(suite.getName(), 10);
//			}
//			Map<String, ISuiteResult> tests = suite.getResults();
//			for (ISuiteResult r : tests.values()) {
//				qty_tests += 1;
//				ITestContext overview = r.getTestContext();
//
//				startSummaryRow(overview.getName());
//				int q = getMethodSet(overview.getPassedTests(), suite).size();
//				qty_pass_m += q;
//				summaryCell(q, Integer.MAX_VALUE);
//				q = getMethodSet(overview.getSkippedTests(), suite).size();
//				qty_skip += q;
//				summaryCell(q, 0);
//				q = getMethodSet(overview.getFailedTests(), suite).size();
//				qty_fail += q;
//				summaryCell(q, 0);
//
//				// Write OS and Browser
//				summaryCell(suite.getParameter("browserType"), true);
//				writer.println("</td>");
//
//				SimpleDateFormat summaryFormat = new SimpleDateFormat("hh:mm:ss");
//				summaryCell(summaryFormat.format(overview.getStartDate()),true);				
//				writer.println("</td>");
//
//				summaryCell(summaryFormat.format(overview.getEndDate()),true);
//				writer.println("</td>");
//
//				time_start = Math.min(overview.getStartDate().getTime(), time_start);
//				time_end = Math.max(overview.getEndDate().getTime(), time_end);
//				summaryCell(timeConversion((overview.getEndDate().getTime() - overview.getStartDate().getTime()) / 1000), true);
//
//				summaryCell(overview.getIncludedGroups());
//				summaryCell(overview.getExcludedGroups());
//				writer.println("</tr>");
//				m_testIndex++;
//			}
//		}
//		if (qty_tests > 1) {
//			writer.println("<tr class=\"total\"><td>Total</td>");
//			summaryCell(qty_pass_m, Integer.MAX_VALUE);
//			summaryCell(qty_skip, 0);
//			summaryCell(qty_fail, 0);
//			summaryCell(" ", true);
//			summaryCell(" ", true);
//			summaryCell(" ", true);
//			summaryCell(timeConversion(((time_end - time_start) / 1000)), true);
//			writer.println("<td colspan=\"3\">&nbsp;</td></tr>");
//		}
		writer.println("</table>");
	}
	/**
	 * Draw table
	 * @param cssclass
	 * @param id
	 */
	private void tableStart(String cssclass, String id) {
		writer.println("<table cellspacing=\"0\" cellpadding=\"0\""
				+ (cssclass != null ? " class=\"" + cssclass + "\""
						: " style=\"padding-bottom:2em\"")
				+ (id != null ? " id=\"" + id + "\"" : "") + ">");
		m_row = 0;
	}
	/**
	 * Draw columns
	 * @param label
	 */
	private void tableColumnStart(String label) {
		writer.print("<th>" + label + "</th>");
	}
	
	private long getMili(ISuite suite) {
		return SuiteSummary.build(suite).getStartDate().getTime()-SuiteSummary.build(suite).getEndDate().getTime();
	}
	
	private double getMinus(long mili) {
		return mili / 1000.0 / 60.0;
	}
	
	private int totalTests(ISuite suite) {
		int total= SuiteSummary.build(suite).getPassedTests().size()+SuiteSummary.build(suite).getFailedTests().size()+SuiteSummary.build(suite).getSkippedTests().size();
		return total;
	}
	
	/** Finishes HTML stream */
	protected void endHtml(PrintWriter out) {
		out.println("<center> TestNG Report </center>");
		out.println("</body></html>");
	}

}
