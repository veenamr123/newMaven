package PracticePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RdbmsNonSelectDemoTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			//step 1: register driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//step2: get database connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet53","root","root");
			
		//step3:create statement
			Statement state = con.createStatement();
			String query = "insert into rmg values('prakash','java',1),('ashish','manual',1);";
			
           //step4: update query
			int result = state.executeUpdate(query);
			
			if(result>1)
				System.out.println("data added successfully");
			else
				System.out.println("data not added");
		
}
	catch(Exception e) {
		
	}
		//step5:close connection
				con.close();
}
}