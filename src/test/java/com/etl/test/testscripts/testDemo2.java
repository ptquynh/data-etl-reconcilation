package com.etl.test.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.etl.test.testconfig.TestDemoConfig;

import static com.etl.common.TestLogger.info;

public class testDemo2 extends TestDemoConfig {
  @Test
  public void f1() {
	  info("testing demo 1");
	  Assert.assertTrue(true);
	  System.out.println("testing demo 1");
  } 
  
  @Test
  public void f2() {
	  info("testing demo 2");
	  Assert.assertTrue(false);
	  System.out.println("testing demo 2");
  } 

}
