package productinventory.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class DBConnection 
{
	private static final String URL = "jdbc:mysql://localhost:3306/product_inventory";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "root";
	
	public static Connection getConnection()
	{
		Connection conn = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(
						URL,
						USER,
						PASSWORD
			);
			
			System.out.println("DataBase Connected Successfully.");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}
