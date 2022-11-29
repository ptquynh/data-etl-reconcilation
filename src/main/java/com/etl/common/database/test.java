package com.etl.common.database;


import java.util.Arrays; 
import java.util.List; 
import java.util.stream.Collectors; 
public class test { 
	private static final List<String> enrolledStudentList = Arrays .asList("Tom", "Robert", "Michel", "Brendon", "Krish", "Jimmy", "Kroos", "Harry"); 
	private static final List<String> passedStudentList = Arrays .asList("Robert", "Jimmy", "Brendon", "Michel"); 
	public static void main(String[] args) { 
		List<String> differenceBetweenTwoList = enrolledStudentList.stream() .filter(studentName -> !passedStudentList.contains(studentName)) 
				.collect(Collectors.toList()); 
		System.out.println(differenceBetweenTwoList); 
	} 
	}
