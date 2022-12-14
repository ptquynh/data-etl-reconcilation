package com.etl.generate.classJava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Assert;

import com.etl.common.ExcelToObjectMapper;
import com.etl.common.TestCaseModel;
import com.etl.common.Utils;

public class CreateTestScriptClass {

	/**
	 * Generate Test scripts
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		//Set parameters of the class
		String excelFile=Utils.getFilePath(args[0]);
		String indexSheet=args[1];
		String testConfigName="TestConfig";
		
		ExcelToObjectMapper mapper = new ExcelToObjectMapper(excelFile,Integer.valueOf(indexSheet));
		List<TestCaseModel> testcases= mapper.map(TestCaseModel.class);
		String packageName = "com.etl.test.testscripts";
		String sheetName=mapper.getSheetName(Integer.valueOf(indexSheet));
		String clsName="Test"+upperCase(sheetName.toLowerCase()).replace("_","");
		
		//Generate header information of the class
		PrintWriter out= writerHeaderClass(packageName,clsName,testConfigName);
		
		System.out.println("----------------Start generating------------------");
		//Generate content of test scripts
		for (TestCaseModel testcase : testcases) {
            
            String testID=testcase.getTestID();
            String testTitle=testcase.getSummary();
            String testDescription=testcase.getDescription();
            String testPrecondition=testcase.getPrecondition();
            String testPriority=testcase.getPriority();
            String testComponent=testcase.getComponents();
            String labels=testcase.getLabels();
            String steps=testcase.getSteps();
            String sourceDB=testcase.getSourceDB();
            String targetDB=testcase.getTargetDB();
            String sourceQuery=null;
            if(testcase.getSourceQuery().toString()!="")
            	sourceQuery=testcase.getSourceQuery().replace("\n"," ").replace("\\d","\\\\d");
            String targetQuery=testcase.getTargetQuery().replace("\n"," ").replace("\\d","\\\\d");
            String expectedResults=testcase.getExpectedResult();
            
            genTestScript(testID,testTitle,testDescription,testPrecondition,testPriority,labels,testComponent,steps,sourceDB,
            		targetDB,sourceQuery,targetQuery,expectedResults,out);
        }
		
		out.print("\t\t\n");
		out.print("}");
		out.close();
		System.out.println("-----------End generating----------------------");
				
	}
	

	/**
	 * Generate contents of Test Scripts
	 * @param testID
	 * @param testTitle
	 * @param testPrecondition
	 * @param testPriority
	 * @param labels
	 * @param testComponent
	 * @param steps
	 * @param sourceDB
	 * @param targetDB
	 * @param sourceQuery
	 * @param targetQuery
	 * @param expectedResults
	 * @param out
	 * @throws IOException
	 */
	public static void genTestScript(String testID,String testTitle,String testDescription,String testPrecondition,String testPriority,
			String labels,String testComponent,String steps,String sourceDB,String targetDB,String sourceQuery,
			String targetQuery,String expectedResults,PrintWriter out) throws IOException {
		    if(testPriority.contentEquals("High")) testPriority="1";
		    else if(testPriority.contentEquals("Medium")) testPriority="2";
		    else if(testPriority.contentEquals("Low")) testPriority="3";
		    else testPriority="4";
		    out.append("\n\n");
		    out.append("\t\t@Test(")
		        .append("priority="+testPriority+",")
		        .append("groups={\""+labels+"\",\""+ testComponent+"\"")
		        .append("})\n");
		    
		         if(sourceDB.equals("EXCEL_FILE")) {
		        	 out.append("\t\tpublic void "+testID+"_"+testTitle.replace("[","_")
                     .replace("]","_")
                     .replace("\"","")
                     .replace(" ","")+"() throws SQLException,FilloException {"+"\n");
		         }else {
		        	 out.append("\t\tpublic void "+testID+"_"+testTitle.replace("[","_")
                     .replace("]","_")
                     .replace("\"","")
                     .replace(" ","")+"() throws SQLException {"+"\n");
		         }
		        	 
		        //Generate test case description
		        out.append("\t\t/**\n");
				out.append("\t\t* Test case ID:"+testID+"\n");
				out.append("\t\t* Test case name:"+ testTitle + "\n");
				out.append("\t\t* Test Description:"+ testDescription + "\n");
				out.append("\t\t* Precondition:"+ testPrecondition + "\n");
				out.append("\t\t* Priority:"+ testPriority + "\n");
				out.append("\t\t* Labels:"+ labels + "\n");
				out.append("\t\t* SourceDB: "+sourceDB+"\n");
				out.append("\t\t* TargetDB:"+targetDB+"\n");
				out.append("\t\t* Test details:\n");
				out.append("\t\t* 1. Run Source Query: "+sourceQuery+"\n");
				out.append("\t\t* 2. Run Target Query:"+targetQuery+"\n");
				out.append("\t\t* Expected Results: "+expectedResults+"\n");
				out.append("\t\t*/\n");
				
				String getColValueFromDB="DatabaseUtils.getColumnValues(1,2)";
				String getColValueFromExcel="ExcelUtils.getColumnValues(1,2)";
				String diffList="Utils.getDiffList(1,2)";
				

				if(testComponent.equals("Reconcilation Testing")) {
					
					if(((sourceQuery.equals("")||sourceQuery.equals("N/A")||sourceQuery.equals(null))) || 
							((targetQuery.equals("")||targetQuery.equals("N/A")||targetQuery.equals(null)))){
						Assert.fail("SourceQuery or Target Query is invalid");
					} else {
						
						String tgQuery=targetQuery.replace("\"","\\\"");
						String srcQuery=sourceQuery.replace("\"","\\\"");
						out.append("\t\t\tString targetQuery=\""+ tgQuery +"\""+";\n");
						out.append("\t\t\tString sourceQuery=\""+ srcQuery +"\""+";\n");
						out.append("\t\t\tList<String> targList="
								+ getColValueFromDB.replace("1","targetQuery")
			                    .replace("2","tagConn"));
						out.append(";\n");
						
						if(sourceDB.equals("EXCEL_FILE")) {
							out.append("\t\t\tList<String> srcList="
									+ getColValueFromExcel.replace("1","sourceQuery")
				                    .replace("2","srcExcelConn"));
							out.append(";\n");
							
						}else {
							out.append("\t\t\tList<String> srcList="
									+ getColValueFromDB.replace("1","sourceQuery")
				                    .replace("2","srcConn"));
							out.append(";\n");
						}
						
						out.append("\t\t\tList<String> diffSrcInTarg="
								+ diffList.replace("1","srcList")
			                    .replace("2","targList"));
						out.append(";\n");
						
						out.append("\t\t\tList<String> diffTargInSrc="
								+ diffList.replace("1","targList")
			                    .replace("2","srcList"));
						
						out.append(";\n");
						out.append("\t\t\tUtils.verify(diffSrcInTarg,\"Not found in Source List\");\n");
						out.append("\t\t\tUtils.verify(diffTargInSrc,\"Not found in Target List\");\n");
					}
					
				}else {
					String tgQuery=targetQuery.replace("\"","\\\"");
					out.append("\t\t\tString targetQuery=\""+ tgQuery +"\""+";\n");
					out.append("\t\t\tList<String> targList="
							+ getColValueFromDB.replace("1","targetQuery")
		                    .replace("2","tagConn"));
					out.append(";\n");
					out.append("\t\t\tUtils.verify(targList,\"Not return 0 values\");\n");
				}
				
		        out.append("\t\t}\n");
	}
	
	
	/**
	 * Generate Header information of the class
	 * @param packageName
	 * @param clsName
	 * @param testConfigName
	 * @return
	 * @throws IOException
	 */
	public static PrintWriter writerHeaderClass(String packageName,String clsName,String testConfigName) throws IOException {
		
		String packagePath = packageName.replace(".", "\\");
		System.out.println("packagePath:" + packagePath);
		String directoryOfjavaFile =Utils.getAbsolutePath("/src/test/java");
		System.out.println("directoryOfjavaFile:" + directoryOfjavaFile);
		String javaOutputDirPath = directoryOfjavaFile + "/" + packagePath+ "/";
		System.out.println("creating directory:" + javaOutputDirPath);
		
		File f = new File(javaOutputDirPath);
		if (f.mkdirs()) {
			System.out.println("directory :" + javaOutputDirPath
					+ " created succesfully..");
		} else {
			System.out.println("directory :" + javaOutputDirPath
					+ " already exist..");
		}
		
		String javaOutputFilePath = directoryOfjavaFile + "/" + packagePath
				+ "/" + clsName + ".java";
		File javaOutPutFile = new File(javaOutputFilePath);
		javaOutPutFile.createNewFile();
		
		PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(javaOutputFilePath)));
		System.out.println("generating class..");
		out.println("package " + packageName + ";");
		out.println("import org.testng.annotations.Test;");
		out.println("import com.etl.common.database.DatabaseUtils;");
		out.println("import com.etl.common.database.ExcelUtils;");
		out.println("import com.codoid.products.exception.FilloException;");
		out.println("import java.util.List;");
		out.println("import com.etl.test.testconfig.TestConfig;");
		out.println("import java.sql.SQLException;");
		out.println("import com.etl.common.Utils;");
		out.append("\n\n");
		out.println("public class " + clsName + " extends TestConfig {");
		return out;
		
	}
	
	/**
	 * This function returns a new string with upper case after mark "_"
	 * @param phrase
	 * @return
	 */
	public static String upperCase(String phrase) {
        StringBuilder sb= new StringBuilder(phrase);
        for (int i=0; i<phrase.length(); i++) {
            if(i==0 || phrase.charAt(i-1)=='_') {
                sb.replace(i,i+1,phrase.substring(i,i+1).toUpperCase());
            }
        }
        return sb.toString();
    }
	
}
