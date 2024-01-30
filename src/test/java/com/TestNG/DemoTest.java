package com.TestNG;

import org.testng.annotations.Test;

public class DemoTest {
	
	@Test(groups="smoke")
	public void demo1Test()
	{
		System.out.println("---d1--");
	}
	
	@Test(groups= {"smoke","regression"})
	public void demo2Test()
	{
		System.out.println("---d2----");
	}
	
	@Test(groups= {"smoke","gegression"})
	public void demo3Test()
	{
		System.out.println("---d3----");
	}

	@Test(groups="smoke")
	public void demo4Test()
	{
		System.out.println("---d4--");
	}
}
