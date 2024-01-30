package demoV;

import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemoTest {
	
	@Test
	public void  hardTest()
	{
		int x=5;
		if(x==0) 
	      System.out.println("fail");
		else 
			System.out.println("pass");
		
		assertNotNull(x);                //true
		System.out.println("---line 1-----");   //executed
		
		assertNull(x);                   //false
		System.out.println("---line 2-----");   //not executed
	}
	
	@Test
	public void softTest()
	{
		int a=5;
		SoftAssert sa=new SoftAssert();
		sa.assertNotNull(sa);                    //true
		System.out.println("---line 3-----");    //executed
		
		sa.assertNull(a);                        //false
		System.out.println("---line 4-----");    //executed
	
		sa.assertAll();
	}

}
