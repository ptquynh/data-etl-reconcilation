package com.etl.generate.classJava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.etl.common.Utils;
import com.etl.common.database.DBConn;
import com.etl.common.database.DatabaseUtils;
import com.etl.common.database.DatabaseUtils.DbTypes;

public class CreateTableModelClass {

	/**
	 * Create java class
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		String packageName = "com.etl.common.tables";
		//Connect to db and get columns and data type list
		String dbUrl=args[0];
		String dbUser=args[1];
		String dbPass=args[2];
		DbTypes dbType=DbTypes.valueOf(args[3]);
		//String tbName=args[4];
		String tbNameList=args[4];
		String[] list=tbNameList.split(",");
		
		Connection conn = DBConn.connectDB(dbUrl,dbUser,dbPass,dbType);
		for(String tbName:list) {
			String clsName=upperCase(tbName.toLowerCase()).replace("_","");
			List<Object> colList=DatabaseUtils.getColumnsMeta(tbName,"COLUMN_NAME",conn,dbType);
			List<Object> dataTypeList=DatabaseUtils.getColumnsMeta(tbName,"DATA_TYPE",conn,dbType);
			
			genObjectModel(packageName,clsName,colList,dataTypeList);
		}
	}
	/**
	 * this function generate class java from a table schema in database
	 * @param packageName
	 * @param clsName
	 * @param colList
	 * @param dataTypeList
	 * @throws IOException
	 */
	public static void genObjectModel(String packageName,String clsName,List<Object> colList,List<Object> dataTypeList) throws IOException {
		String packagePath = packageName.replace(".", "\\");
		System.out.println("packagePath:" + packagePath);
		String directoryOfjavaFile =Utils.getAbsolutePath("/src/main/java");
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
		out.println("import java.util.*;");
		out.println("public class " + clsName + " {");

		if(colList.size()!=0) {
			for (int i=0;i<colList.size();i++) {

				String field= colList.get(i).toString().toLowerCase();
				String type=dataTypeList.get(i).toString().toLowerCase()
						.replace("number","int")
						.replace("varchar2","String")
						.replace("date","Date")+" ";

				out.append("\t\tprivate ").append(type).append(field);
				out.append(";\n");
			}

			for (int i=0;i<colList.size();i++) {

				String field= upperCase(colList.get(i).toString().toLowerCase()).replace("_","");
				String fieldHasSpace= colList.get(i).toString().toLowerCase();

				String type=dataTypeList.get(i).toString().toLowerCase()
						.replace("number","int")
						.replace("varchar2","String")
						.replace("date","Date")+" ";


				out.append("\n\n");
				out.append("\tpublic ").append(type).append("get"+field+"(){"+"\n");
				out.append("\t\treturn this.").append(fieldHasSpace);
				out.append(";\n");
				out.append("\t\t\n\t}\n");
			}
		}


		out.print("\t\t\n");
		out.print("}");
		out.close();

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
