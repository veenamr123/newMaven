package com.TestNG;

import org.testng.annotations.Test;

public class SampleTest {
	
	@Test(groups="regression")
	public void sample1Test()
	{
		System.out.println("---s1---");
	}
	
	@Test(groups= {"smoke","regression"})
	public void sample2Test()
	{
		System.out.println("---s2---");
	}
	
	@Test(groups= {"smoke","regression"})
	public void sample3Test()
	{
		System.out.println("---s3---");
	}
	
	@Test(groups="regression")
	public void sample4Test()
	{
		System.out.println("---s4--");
	}
}