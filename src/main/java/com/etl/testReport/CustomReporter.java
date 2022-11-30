package com.etl.testReport;


import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
import com.etl.common.Utils;

public class CustomReporter implements IReporter{

	private FileWriter writer;
	private String reportFileName = "test-summary-report.html";
	private String reportTitle= "Test Summary Report";
	private String pathReport;
	private long totalMilis=0;
	private double totalMinutes=0;
	private int totalTestCase=0;
	private int totalTestPass=0;
	private int totalTestFailed=0;
	private int totalTestSkipped=0;
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {

		try {
            
			pathReport = Utils.getAbsolutePath("/test-output/"+reportFileName);
			Utils.deleteFile(pathReport);
			System.out.print("pathReport:"+pathReport);
			writer = createWriter(pathReport);
			testReportTitle(writer);
			caltotalNumbers(suites);
			testSummarySection(writer);
			testMethodDetail(writer,suites);
			testDetailSection(writer,suites);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}

	protected FileWriter createWriter(String outdir) throws IOException {
		FileWriter fw = new FileWriter(outdir,true);
		return fw;
	}
	protected void testReportTitle(FileWriter out) throws IOException {
		out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.1//EN\" \"https://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd\">\r\n"
				+ "<html xmlns=\"https://www.w3.org/1999/xhtml\">\r\n"
				+ "<head>\r\n"
				+ "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"/>\r\n"
				+ "<title>Test Report</title>\r\n"
				+ "</head>"
				+ "<body>");
		out.write("<center><h1>");
		out.write("<font color=#43A047>"+reportTitle +" - "+getDateAsString()+"</font>");
		out.write("</h1></center>");
	}

	protected String getDateAsString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	protected String getDateTimeAsString() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	protected String getDateTime(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return dateFormat.format(date);
	}
	/**
	 * Generate Test Summary section
	 * @param out
	 * @throws IOException
	 */
	protected void testSummarySection(FileWriter out) throws IOException {
		out.write("<h3>Test Summary</h3>");
		out.write("<hr>");
		out.write("<table border=\"1px\">");
		out.write("<tr>");
		out.write("<td style=\"padding-right:10px;font-weight: bold;\">Start Date</td>");
		out.write("<td>"+getDateTimeAsString()+"</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td style=\"padding-right:10px;font-weight: bold;\">Duration</td>");
		out.write("<td>"+totalMinutes+" minutes ("+totalMilis+" ms)</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td style=\"padding-right:10px;font-weight: bold;\">Test Status</td>");
		
		if(totalTestFailed>0 || totalTestSkipped>0)
			out.write("<td align=\"center\" bgcolor=\"#E53935\"><font color=\"white\">Failed</font></td>");
		else
			out.write("<td align=\"center\" bgcolor=\"#43A047\"><font color=\"white\">Passed</font></td>");
		
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td style=\"padding-right:10px;font-weight: bold;\">Total Tests</td>");
		out.write("<td>"+totalTestCase+"</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td style=\"padding-right:10px;font-weight: bold;\">Passed Tests</td>");
		out.write("<td>"+totalTestPass+"</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td style=\"padding-right:10px;font-weight: bold;\">Failed Tests</td>");
		out.write("<td>"+totalTestFailed+"</td>");
		out.write("</tr>");
		out.write("<tr>");
		out.write("<td style=\"padding-right:10px;font-weight: bold;\">Skipped Tests</td>");
		out.write("<td>"+totalTestSkipped+"</td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("<br>");
	}

	/**
	 * Calculate: total test case, total pass test case, total failed test case
	 * total skipped test case, total execution time in Test Summary section
	 * @param suites
	 */
	protected void caltotalNumbers(List<ISuite> suites) {
		int totalTCPassAllSuite=0;
		int totalTCFailedAllSuite=0;
		int totalTCSkippedAllSuite=0;
		long totalExecutionTimeAllSuiteByMilis=0;
		//Iterating over each suite included in the test
		for (ISuite suite : suites) {

			//Getting the results for the said suite
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			int numTCPass=0;
			int numTCFailed=0;
			int numTCSkipped=0;
			long numMilisExe=0;
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				numTCPass+=tc.getPassedTests().getAllResults().size();
				numTCFailed+=tc.getFailedTests().getAllResults().size();
				numTCSkipped+=tc.getSkippedTests().getAllResults().size();
				long durationExeTime=tc.getEndDate().getTime()-tc.getStartDate().getTime();
				numMilisExe+=durationExeTime;
			}
			totalTCPassAllSuite+=numTCPass;
			totalTCFailedAllSuite+=numTCFailed;
			totalTCSkippedAllSuite+=numTCSkipped;
			totalExecutionTimeAllSuiteByMilis+=numMilisExe;
		}
		totalTestPass=totalTCPassAllSuite;
		totalTestFailed=totalTCFailedAllSuite;
		totalTestSkipped=totalTCSkippedAllSuite;
		totalTestCase=totalTestPass+totalTestFailed+totalTestSkipped;
		totalMilis=totalExecutionTimeAllSuiteByMilis;
		totalMinutes=totalMilis/1000/60;
	}
    
	/**
	 * Generate Test Method Detail
	 * @param out
	 * @throws IOException
	 */
	protected void testMethodDetail(FileWriter out,List<ISuite> suites) throws IOException {
		out.write("<h3>Test Method Summary</h3>");
		out.write("<hr>");
		out.write("<table border=\"1\" style=\"width:100%\">");
		out.write("<tr>");
		out.write("<th>Suite Name</th>");
		out.write("<th>Passed</th>");
		out.write("<th>Failed</th>");
		out.write("<th>Skipped</th>");
		out.write("<th>Execution Time</th>");
		out.write("<th>Start Time</th>");
		out.write("<th>End Time</th>");
		out.write("</tr>");
		
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			
			for (ISuiteResult sr : suiteResults.values()) {
				
				ITestContext tc = sr.getTestContext();
				long milis = tc.getEndDate().getTime()-tc.getStartDate().getTime();
				out.write("<tr>");
				out.write("<td>"+tc.getSuite().getName()+"</td>");
				out.write("<td align=\"center\" bgcolor=\"#43A047\"><font color=\"white\">"+tc.getPassedTests().size()+"</font></td>");
				out.write("<td align=\"center\" bgcolor=\"#E53935\"><font color=\"white\">"+tc.getFailedTests().size()+"</font></td>");
				out.write("<td align=\"center\" bgcolor=\"#FFEB3B\"><font color=\"white\">"+tc.getSkippedTests().size()+"</font></td>");
				out.write("<td align=\"center\" bgcolor=\"#FFFFFF\"><font color=\"Black\">"+milis/1000/60+" minutes ("+milis+" ms)</font></td>");
				out.write("<td align=\"center\" bgcolor=\"#FFFFFF\"><font color=\"Black\">"+getDateTime(tc.getStartDate())+"</font></td>");
				out.write("<td align=\"center\" bgcolor=\"#FFFFFF\"><font color=\"Black\">"+getDateTime(tc.getEndDate())+"</font></td>");
				out.write("</tr>");
			}
		}
		
		out.write("</table>");
		out.write("<br>");
		out.write("<br>");
		out.write("</h2>");
		out.write("<br>");

	}
	/**
	 * Generate test detail
	 * @param out
	 * @param suites
	 * @throws IOException
	 */
	protected void testDetailSection(FileWriter out,List<ISuite> suites) throws IOException {
		out.write("<h3>Test Results Detail</h3>");
		out.write("<hr>");
		out.write("<table border=\"1\" style=\"width:100%\">");
		out.write("<tr>");
		out.write("<th>Test Cases Name</th>");
		out.write("<th>Test Class Name</th>");
		out.write("<th>Test Priority</th>");
		out.write("<th>Test Results</th>");
		out.write("<th>Suite Name</th>");
		out.write("<th>Error Message</th>");
		out.write("</tr>");
		
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				
				IResultMap passTest = tc.getPassedTests();
				Collection<ITestNGMethod> passMethods = passTest.getAllMethods();
				for(ITestNGMethod md : passMethods){
					out.write("<tr>");
					out.write("<td>"+md.getMethodName()+"</td>");
					out.write("<td style=\"padding-right:10px;\">"+md.getTestClass().getName()+"</td>");
					out.write("<td align=\"center\">"+md.getPriority()+"</td>");
					out.write("<td align=\"center\" bgcolor=\"#43A047\"><font color=\"white\">Passed</font></td>");
					out.write("<td style=\"padding-right:10px;\">"+tc.getSuite().getName()+"</td>");
					String errorMessage=null;
					out.write("<td>"+errorMessage+"</td>");
					out.write("</tr>");
	
				}
				
				IResultMap failedTest = tc.getFailedTests();
				Collection<ITestNGMethod> failedMethods = failedTest.getAllMethods();
				for(ITestNGMethod md : failedMethods){
					out.write("<tr>");
					out.write("<td>"+md.getMethodName()+"</td>");
					out.write("<td style=\"padding-right:10px;\">"+md.getTestClass().getName()+"</td>");
					out.write("<td align=\"center\">"+md.getPriority()+"</td>");
					out.write("<td align=\"center\" bgcolor=\"#E53935\"><font color=\"white\">Failed</font></td>");
					out.write("<td style=\"padding-right:10px;\">"+tc.getSuite().getName()+"</td>");
					
					Set<ITestResult> resultSet = failedTest.getResults(md);
					String errorMessage=null;
					for (ITestResult testResult : resultSet) {
						errorMessage=testResult.getThrowable().getMessage();
					}
					out.write("<td>"+errorMessage+"</td>");
					out.write("</tr>");
				}
				
				IResultMap skippedTest = tc.getFailedTests();
				Collection<ITestNGMethod> skippedMethods = skippedTest.getAllMethods();
				
				for(ITestNGMethod md : skippedMethods){
					out.write("<tr>");
					out.write("<td>"+md.getMethodName()+"</td>");
					out.write("<td style=\"padding-right:10px;\">"+md.getTestClass().getName()+"</td>");
					out.write("<td align=\"center\">"+md.getPriority()+"</td>");
					out.write("<td align=\"center\" bgcolor=\"#FFEB3B\"><font color=\"white\">Skipped</font></td>");
					out.write("<td style=\"padding-right:10px;\">"+tc.getSuite().getName()+"</td>");
					
					Set<ITestResult> resultSet = skippedTest.getResults(md);
					String errorMessage=null;
					for (ITestResult testResult : resultSet) {
						errorMessage=testResult.getThrowable().getMessage();
					}
					out.write("<td>"+errorMessage+"</td>");
					out.write("</tr>");
				}
				
			}
			
		}		
		
		out.write("</table>");
		out.write("<br>");
		out.write("<br>");
		out.write("</h2>");
		out.write("<br>");
		out.write("</body>");
		out.write("</html>");
	}

}
