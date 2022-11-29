package com.etl.common;

import static com.etl.common.TestLogger.error;
import static com.etl.common.TestLogger.info;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class Utils {

	private static Scanner scanner; 

	
	/**************************DATE TIME*******************************************************
	 * *********************************************************************************************
	 */
	/**
	 * function get current Date of system follow a format
	 * @param format
	 * @return current Date of system
	 */
	public String getCurrentDate(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return (dateFormat.format(date)); 
	}
	/**
	 * Get current date with time zone
	 * @param format
	 * @param local
	 * @return current Date with correct time zone
	 */
	public String getCurrentDate(String format,String local){
		DateFormat df = new SimpleDateFormat(format);
		Date date = new Date();
		df.setTimeZone(TimeZone.getTimeZone(local));
		System.out.println("Date and time in"+local+": " + df.format(date));
		return df.format(date);
	}

	/**
	 * Add 1 minute to current date time
	 * @param min
	 * @param format
	 * @return string minute
	 */
	public String addMinuteToCurrentDateTime(int min, String...format){
		DateFormat dateFormat = format.length > 0 ? new SimpleDateFormat(format[0]) : new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, min);
		return (dateFormat.format(cal.getTime()));	
	}

	/** Get date in format "dd"
	 * @param gap distance from current date
	 * @return date in format "dd"
	 */
	public String getDate(int gap, String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, gap);
		info(dateFormat.format(cal.getTime()));
		return (dateFormat.format(cal.getTime()));	
	}
	/**
	 * Get date from firstDayOf Week
	 * @param gap
	 * @param format
	 * @return date in format
	 */
	public String getDateFromFirstDayOfWeek(int gap, String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		calendar.add(Calendar.DAY_OF_MONTH, gap);
		String getDateFromFirstDayOfWeek = dateFormat.format(calendar.getTime());
		info("getDateFromFirstDayOfWeek:"+getDateFromFirstDayOfWeek);
		return getDateFromFirstDayOfWeek;
	}

	/** Get day of week
	 * @param gap distance from current date
	 * @return day of week (monday, tuesday,..., sunday)
	 */
	public int getDayOfWeek(int gap){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, gap);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Get day of the next month
	 * @param format
	 * @return date
	 */
	public String getDayOfNextMonth(String format,int dayNum,int weekNum){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();

		Calendar nextMonth = Calendar.getInstance();
		nextMonth.setTime(calendar.getTime());
		nextMonth.add(Calendar.DAY_OF_WEEK_IN_MONTH,weekNum);
		nextMonth.add(Calendar.DAY_OF_MONTH,dayNum);
		String dayOfNextMonth= dateFormat.format( nextMonth.getTime());
		System.out.println("dayOfNextMonth:"+dayOfNextMonth);
		return dayOfNextMonth;

	}
	/**
	 * Get the day of next year
	 * @param format
	 * @param year
	 * @return dayOfYear
	 */
	public String getDayOfNextYear(String format,int year){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();

		Calendar nextYear = Calendar.getInstance();
		nextYear.setTime(calendar.getTime());
		nextYear.add(Calendar.YEAR,year);
		nextYear.add(Calendar.MONTH,12);
		String dayOfYear= dateFormat.format(nextYear.getTime());
		System.out.println("dayOfYear:"+dayOfYear);
		return dayOfYear;
	}
	/**
	 * Get the day of next week
	 * @param format
	 * @return
	 */
	public String getDayOfNextWeek(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar calendar = Calendar.getInstance();
		String dayOfNextMonth1= dateFormat.format(  calendar.getTime());
		System.out.println("dayOfNextMonth1:"+dayOfNextMonth1);

		Calendar nextWeek = Calendar.getInstance();
		nextWeek.setTime(calendar.getTime());
		nextWeek.add(Calendar.DATE,7);
		String dayOfNextWeek= dateFormat.format(nextWeek.getTime());
		return dayOfNextWeek;

	}
	/**
	 * Get the number of current week
	 * @return weekNum
	 */
	public int getWeekNumber(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DAY_OF_WEEK);
	}


	public int getDayNumber(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.DATE);
	}
	/**
	 * Get current month/day/year
	 * @param format as MMM for month, dd for day, or yyyy for year
	 * @return dateFormat.format(now.getTime())
	 */
	public String getCurrentMonthDayYear(String format){
		DateFormat dateFormat = new SimpleDateFormat (format);
		Calendar now = Calendar.getInstance();
		return dateFormat.format(now.getTime());
	}
	/**
	 * Get minute in format "mm" from current date
	 * @return minute
	 * 
	 */
	public int getMinute(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		int minute = cal.get(Calendar.MINUTE);
		return (minute); 
	}
	
	/**
	 * Get minute in format "HH" from current date
	 * @return hours
	 * 
	 */
	public int getHours(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date); 
		int minute = cal.get(Calendar.HOUR);
		return (minute); 
	}
	
	/**
	 * Get date by text format
	 * ex. Saturday, Febuary 16, 2015
	 * @param format
	 */
	public String getDateByTextFormat(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		info(date);
		return date;
	}
	/**
	 * Get first day of week
	 * @param format
	 * @return firstDayOfWeek
	 */
	public String getFirstDayOfWeek(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, 2);
		String firstDayOfWeek = dateFormat.format(calendar.getTime());
		info("firstDayOfWeek:"+firstDayOfWeek);
		return firstDayOfWeek;
	}

	/**
	 * Get last day of week
	 * @param format
	 * @return firstDayOfWeek
	 */
	public String getLastDayOfWeek(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Calendar currentDate = Calendar.getInstance();
		int firstDayOfWeek = currentDate.getFirstDayOfWeek();

		Calendar startDate = Calendar.getInstance();
		startDate.setTime(currentDate.getTime());
		int days = (startDate.get(Calendar.DAY_OF_WEEK) + 7 - firstDayOfWeek) % 7;
		startDate.add(Calendar.DATE, -days);

		Calendar endDate = Calendar.getInstance();
		endDate.setTime(startDate.getTime());
		endDate.add(Calendar.DATE, 5);
		String lastDayOfWeek = dateFormat.format(endDate.getTime());
		info("lastDayOfWeek:"+lastDayOfWeek);
		return lastDayOfWeek;
	}

	/******************************************RANDOM VALUES*******************************************************
	 * ************************************************************************************************************
	 */
	/**
	 * get random string
	 * @return random string
	 */
	public String getRandomString(){
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/**
	 * get a list of random numbers
	 * @return random numbers
	 */
	public String getRandomNumber() {
		char[] chars = "0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		return sb.toString();
	}

	/******************************************LIST**********************************************************
	 * ************************************************************************************************************
	 */
	/**
	 * Create a String list by size
	 * @param name
	 *             is the name of array's members
	 * @param size
	 * @return value
	 */
	public ArrayList<String> getListData(String name,int size){
		ArrayList<String> array = new ArrayList<String>();
		for(int i=1;i<size;i++){
			String item = name+" "+String.valueOf(i);
			array.add(item);
		}
		return array;
	}

	/**
	 * Get difference values between 2 lists
	 * @param list1
	 * @param list2
	 * @return
	 */
	public static List<Object> diffValuesBetweenLists(List<Object> list1, List<Object> list2) {
		List<Object> differences = list1.stream()
				.filter(element -> !list2.contains(element))
				.collect(Collectors.toList());
		return differences;
	}

	
	/******************************************EXTERNAL FILE**********************************************************
	 * ************************************************************************************************************
	 */
	/**
	 * This function returns a absolute path from a relative path
	 * @param relativeFilePath
	 * @return - FQA-2092: Run and check calendar sniff on IE and FF
	 */
	public static String getAbsoluteFilePath(String relativeFilePath){
		String fs = File.separator;
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + "/src/main/resources/" + relativeFilePath;
		absolutePath=absolutePath.replace("/", fs).replace("\\", fs);;
		return absolutePath;
	}
	/**
	 * this function returns a absolution path from a relative path
	 * @param relativeFilePath
	 * @return
	 */
	public static String getAbsolutePath(String relativeFilePath){
		String fs = File.separator;
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativeFilePath;
		absolutePath=absolutePath.replace("/", fs).replace("\\", fs);;
		return absolutePath;
	}

	/**
	 * Get a File Content
	 * @param filePath
	 * @return fileContent
	 */
	public String getFileContent(String filePath){
		String path = getAbsoluteFilePath(filePath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			error("Failed to find location of... " + filePath);
		}
		scanner = new Scanner(fis,"UTF-8");
		String inputStreamString = scanner.useDelimiter("\\A").next();		
		return inputStreamString;	
	}


	/**
	 *  This function returns a absolute path from a relative path that get from excel file
	 * @param relativeFilePath
	 * @return absolutePath
	 */
	public static String getAbsoluteFilePathFromFile(String relativeFilePath) {
		String curDir = System.getProperty("user.home");
		String absolutePath = curDir + relativeFilePath;
		info("absolutePath:" + absolutePath);
		return absolutePath;
	}

	/**
	 * function: check a file existed in folder
	 * @param file file name (eg: export.zip)
	 * @return true -> file exist
	 * false-> file is not exist
	 */
	public static boolean checkFileExisted(String file){
		boolean found = false;

		if (new File(file).isFile()){
			found = true;
		}
		info("File exists: " + file + " is " + found);
		return found;
	}

	/**
	 * function delete file in folder test output
	 * @param file file name
	 */
	public static void deleteFile(String file){
		File Files = new File(file);
		if(checkFileExisted(file)){
			Files.setWritable(true);
			Files.delete();
		}
		if (checkFileExisted(file) == false){
			info("Delete file successfully");
		}else info("Have error when delete file");
	}

	/**
	 * cutPasteFileFromOutputToTestData
	 * @param fileName
	 */
	public void cutPasteFileFromOutputToTestData(String fileName){
		String fs = File.separator;
		String source = System.getProperty("user.dir") + "/src/main/resources/TestData/TestOutput/" + fileName;
		source=source.replace("/", fs);
		//directory where file will be copied
		String target = System.getProperty("user.dir") + "/src/main/resources/TestData/";
		target=target.replace("/", fs);

		//name of source file
		File sourceFile = new File(source);
		String name = sourceFile.getName();

		File targetFile = new File(target+name);

		//copy file from one location to other
		try {
			FileUtils.copyFile(sourceFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//delete file in TestOutput
		deleteFile("TestOutput/" + fileName);
	}
	
	/**
	 * Get path of an test data excel file in test-data-excel folder
	 * @param fileName
	 * @return
	 */
	public static String getFilePath(String fileName) {
		String pathfile=Utils.getAbsoluteFilePath(fileName);
		return pathfile;
	}
	/**
	 * Verify a list
	 * @param objList
	 */
	public static void verify(List<Object> objList) {
		if(objList !=null) {
			assert false : "Values returns as:"+objList;
		}else assert true;
	}
	

}
