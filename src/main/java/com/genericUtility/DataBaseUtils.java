package com.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DataBaseUtils {
	
	Connection con=null;

	/**
	 * 
	 * @throws SQLException
	 */
	public void ConnectToDb() throws SQLException
	{
		//step1: register driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//step2:get db connection
		con = DriverManager.getConnection(IPathConstants.DBURL,IPathConstants.DBUsername,IPathConstants.DBPassword);	
			
	}
	
	public void closeDb() throws SQLException
	{
		con.close();
	}
	
	public String executeQueryGetData(String query,int columnindex,String expData) throws SQLException
	{
		String data=null;
		boolean flag=false;
		ResultSet result = con.createStatement().executeQuery(query);
        
		while(result.next())
		{
			data= result.getString(columnindex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("data not verified");
			return expData;
		}
		else
		{
			System.out.println("data not verified");
			return "";
		}
	
	}
	
	
	
}
