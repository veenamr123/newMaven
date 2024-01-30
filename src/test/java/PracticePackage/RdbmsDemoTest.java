package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class RdbmsDemoTest {

	public static void main(String[] args) throws SQLException  {
		Connection con=null;
		try {
			
		//step 1:register driver
        Driver driver	=new Driver();
        DriverManager.registerDriver(driver);
         
        //step2: get connection to database
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet53","root","root");
        
	    //step3: create statement
         Statement state = con.createStatement();
         String query="select * from rmg;";
         
        //step4: Execute /update
         ResultSet result = state.executeQuery(query);
         
         while(result.next())
         {
        	 System.out.println(result.getString(1)+" " +result.getString(2)+" "+result.getString(3));
         }	 
         }
         catch(Exception e)
		{
        	 }
		//step5:close connection
		con.close();
		
		}
}