package com.etl.test.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.etl.test.testconfig.TestDemoConfig;

import static com.etl.common.TestLogger.info;

public class testDemo extends TestDemoConfig {

  
  @Test
  public void f1() {
	  info("testing 1");
	  Assert.assertTrue(false);
	  System.out.println("testing 1");
	  //info("testing 1");
  } 
  
  @Test
  public void f2() {
	  info("testing 2");
	  Assert.assertTrue(false);
	  System.out.println("testing 2");
  } 

}
