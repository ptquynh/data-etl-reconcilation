package com.etl.generate.classJava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import com.etl.common.ExcelToObjectMapper;
import com.etl.common.TestCaseModel;
import com.etl.common.Utils;


import static com.etl.common.TestLogger.info;

public class GenerateTestScriptClass {

	/**
	 * Generate Test scripts
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		//Set parameters of the class
		String excelFile = Utils.getFilePath("input-excel-file/test-cases/VETC-OPS-CYC_INTF.xlsx");
		ExcelToObjectMapper mapper = new ExcelToObjectMapper(excelFile,0);
		List<TestCaseModel> testcases= mapper.map(TestCaseModel.class);
		String packageName = "com.data.test.testscripts";
		String sheetName=mapper.getSheetName(0);
		String clsName="Test"+upperCase(sheetName.toLowerCase()).replace("_","");
		String testConfigName="TestConfig";
		
		//Generate header information of the class
		PrintWriter out= writerHeaderClass(packageName,clsName,testConfigName);
		
		System.out.println("----------------Start generating------------------");
		//Generate content of test scripts
		for (TestCaseModel testcase : testcases) {
            
            String testID=testcase.getTestID();
            String testTitle=testcase.getSummary();
            String testPrecondition=testcase.getPrecondition();
            String testPriority=testcase.getPriority();
            String testComponent=testcase.getComponents();
            String labels=testcase.getLabels();
            String steps=testcase.getSteps();
            String sourceDB=testcase.getSourceDB();
            String targetDB=testcase.getTargetDB();
            String sourceQuery=testcase.getSourceQuery().replace("\n"," ").replace("\\d","\\\\d");
            String targetQuery=testcase.getTargetQuery().replace("\n"," ").replace("\\d","\\\\d");
            String expectedResults=testcase.getExpectedResult();
            
            genTestScript(testID,testTitle,testPrecondition,testPriority,labels,testComponent,steps,sourceDB,
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
	public static void genTestScript(String testID,String testTitle,String testPrecondition,String testPriority,
			String labels,String testComponent,String steps,String sourceDB,String targetDB,String sourceQuery,
			String targetQuery,String expectedResults,PrintWriter out) throws IOException {
		    if(testPriority.contentEquals("High")) testPriority="1";
		    else if(testPriority.contentEquals("Medium")) testPriority="2";
		    else if(testPriority.contentEquals("Low")) testPriority="3";
		    else testPriority="4";
		    out.append("\n\n");
		    out.append("\t\t@Test(")
		        .append("priority="+testPriority+",")
		        .append("groups={\""+labels+"\",\""+testComponent+"\"")
		        .append("})\n")
		        .append("\t\tpublic void "+testID+"_"+testTitle.replace("[","_")
		                                                       .replace("]","_")
		                                                       .replace("\"","")
		                                                       .replace(" ","")+"() throws SQLException {"+"\n");
		        //Generate test case description
		        out.append("\t\t/**\n");
				out.append("\t\t* Test case ID:"+testID+"\n");
				out.append("\t\t* Test case name:"+ testTitle + "\n");
				out.append("\t\t* Precondition:"+ testTitle + "\n");
				out.append("\t\t* Priority:"+ testPriority + "\n");
				out.append("\t\t* Labels:"+ labels + "\n");
				out.append("\t\t* SourceDB: "+sourceDB+"\n");
				out.append("\t\t* TargetDB:"+targetDB+"\n");
				out.append("\t\t* Test details:\n");
				out.append("\t\t* 1. Run Source Query: "+sourceQuery+"\n");
				out.append("\t\t* 2. Run Target Query:"+targetQuery+"\n");
				out.append("\t\t* Expected Results: "+expectedResults+"\n");
				out.append("\t\t*/\n");
				
				//Generate test script code
				if(sourceQuery!=null && targetQuery!=null) {
					String diffFunct="DatabaseUtils.getDiffResultQueries(1,2,3,4)";
					String srcQuery=sourceQuery.replace("\"","\\\"");
					String tgQuery=targetQuery.replace("\"","\\\"");
					out.append("\t\t\tString sourceQuery=\""+ srcQuery +"\""+";\n");
					out.append("\t\t\tString targetQuery=\""+ tgQuery +"\""+";\n");
					out.append("\t\t\tList<Object> diffResultQueries="
					+ diffFunct.replace("1","sourceQuery")
                    .replace("2","targetQuery")
                    .replace("3","srcConn")
                    .replace("4","tagConn"));
					out.append(";\n");
					out.append("\t\t\tUtils.verify(diffResultQueries);\n");
				}else {
					info("Source Query or Target Query are not available");
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
		out.println("import com.data.common.database.DatabaseUtils;");
		out.println("import java.util.List;");
		out.println("import com.data.test.testconfig.TestConfig;");
		out.println("import java.sql.SQLException;");
		out.println("import com.data.common.Utils;");
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
