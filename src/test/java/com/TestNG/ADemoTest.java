package com.TestNG;

import org.testng.annotations.Test;

import com.genericUtility.BaseClass;

public class ADemoTest extends BaseClass {
	@Test(groups="smoke")
	public void demo1Test()
	{
		System.out.println("----a1--");
	}
	
	@Test(groups= {"smoke","regression"})
	public void demo2Test()
	{
		System.out.println("----a2----");
	}

}
