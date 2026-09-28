package productinventory.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import productinventory.util.DBConnection;
import productinventory.bean.Product;

public class ProductDao 
{
	public int addProduct(Product product)
	{
		int rowsAffected = 0;
		
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "INSERT INTO product VALUES("
					+ product.getPid() + ", '"
					+ product.getPname() + "', '"
					+ product.getCategory() + "', "
					+ product.getQuantity() + ", "
					+ product.getPrice() + ")";
					
			System.out.println("Query : " + query);
			
			rowsAffected = stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowsAffected;
	}
	
	public int updateProduct(Product product)
	{
		int rowsAffected = 0;
		
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "UPDATE product SET "
					+ "pname = '" + product.getPname() + "', "
					+ "category = '" + product.getCategory() + "', "
					+ "quantity = " + product.getQuantity() + ", "
					+ "price = " + product.getPrice()
					+ " WHERE pid = " + product.getPid();
			
			System.out.println("Query : " + query);
			
			rowsAffected = stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowsAffected;
	}
	
	public int deleteProduct(int pid)
	{
		int rowsAffected = 0;
		
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "DELETE FROM product WHERE pid = " + pid;
			
			System.out.println("Query = " + query);
			
			rowsAffected = stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rowsAffected;
	
	}
	
	public void displayAllProducts()
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM product";
			
			System.out.println("Query : " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println();
			
			System.out.println("======================================================================");
			
			System.out.println("PID\tNAME\t\tCATEGORY\tQUANTITY\tPRICE");
			
			System.out.println("=======================================================================");
			
			while(rs.next())
			{
				int pid = rs.getInt("pid");
				
				String pname = rs.getString("pname");
				
				String category = rs.getString("category");
				
				int quantity = rs.getInt("quantity");
				
				double price = rs.getDouble("price");
				
				System.out.println(pid + "\t" + pname + "\t\t" + category + "\t" + quantity + "\t\t" + price);
				
			}
			
			System.out.println("=======================================================================");
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void searchById(int pid)
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM product WHERE pid = " + pid;
			
			System.out.println("Query = " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next())
			{
				System.out.println();
				
				System.out.println("Product Found!");
				
				System.out.println("----------------------------------------");
				
				System.out.println("Product ID : " + rs.getInt("pid"));
				
				System.out.println("Product Name : " + rs.getString("pname"));
				
				System.out.println("Category : " + rs.getString("category"));
				
				System.out.println("Quantity : " + rs.getInt("quantity"));
				
				System.out.println("Price : " + rs.getDouble("price"));
				
				System.out.println("-----------------------------------------");
				
			}else
			{
				System.out.println("Product Not found!");
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void searchByName(String pname)
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM product WHERE pname = '" + pname + "'";
			
			System.out.println("Query : " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			boolean found = false;
			
			while(rs.next()) {
				found = true;
				
				System.out.println();
				
				System.out.println("Product Found");
				
				System.out.println("----------------------------------------");
				
				System.out.println("Product ID : " + rs.getInt("pid"));
				
				System.out.println("Product Name : " + rs.getString("pname"));
				
				System.out.println("Category : " + rs.getString("category"));
				
				System.out.println("Quantity : " + rs.getInt("quantity"));
				
				System.out.println("Price : " + rs.getDouble("price"));
				
				System.out.println("-----------------------------------------");
			}
				
			if(!found)
			{
				System.out.println("Product Not Found !");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void sortByName()
	{
		try
		{
			Connection conn = DBConnection.getConnection();
		
			Statement stmt = conn.createStatement();
			 
			String query = "SELECT * FROM product ORDER BY pname ASC";
			
			System.out.println("Query : " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println();
			
			System.out.println("=========================================================================");
			
			System.out.println("PRODUCTS SORTED BY NAME (ASCENDING)");
			
			System.out.println("==========================================================================");
			
			System.out.println("PID\tNAME\t\tCATEGORY\tQUANTITY\t\tPRICE");
			
			System.out.println("===========================================================================");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("pid") + "\t" + rs.getString("pname") + "\t\t" + rs.getString("category") + "\t" + rs.getInt("quantity") + "\t\t" + rs.getDouble("price"));
				
			}
			
			System.out.println("============================================================================");
			
			rs.close();
			stmt.close();
			conn.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void sortByPriceAsc()
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM product ORDER BY price ASC";
			
			System.out.println("Query : " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println();
			
			System.out.println("==============================================================================");
			
			System.out.println("PRODUCTS SOARTED BY PRICE (LOW TO HIGH) : ");
			
			System.out.println("===============================================================================");
			
			System.out.println("PID\tname\t\tCATEGORY\tQUANTITY\t\tPRICE");
			
			System.out.println("================================================================================");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("pid") + "\t" + rs.getString("pname") + "\t\t" + rs.getString("category") + rs.getInt("quantity") + "\t\t" + rs.getDouble("price"));
				
			}
			
			System.out.println("=================================================================================");
			
			rs.close();
			stmt.close();
			conn.close();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	public void sortByPriceDesc()
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM product ORDER BY price DESC";
			
			System.out.println("Query : " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println();
			
			System.out.println("==============================================================================");
			
			System.out.println("PRODUCTS SOARTED BY PRICE (HIGH TO LOW) : ");
			
			System.out.println("===============================================================================");
			
			System.out.println("PID\tname\t\tCATEGORY\tQUANTITY\t\tPRICE");
			
			System.out.println("================================================================================");
			
			while(rs.next())
			{
				System.out.println(rs.getInt("pid") + "\t" + rs.getString("pname") + "\t\t" + rs.getString("category") + rs.getInt("quantity") + "\t\t" + rs.getDouble("price"));
				
			}
			
			System.out.println("=================================================================================");
			
			rs.close();
			stmt.close();
			conn.close();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
	}
	
	public void displayLowStock()
	{
		try
		{
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT * FROM product WHERE quantity < 10";
			
			System.out.println("Query = " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			System.out.println();
			
			System.out.println("========================================================================================");
			
			System.out.println("LOW STOCK PRODUCTS");
			
			System.out.println("=========================================================================================");
			
			System.out.println("PID\tNAME\t\tQUANTITY");
			
			System.out.println("=========================================================================================");
			
			boolean found = false;
			
			while(rs.next()) {
				found = true;
				
				System.out.println(rs.getInt("pid") + "\t" + rs.getString("pname") + "\t\t" + rs.getInt("quantity"));
				
			}
			
			if(!found)
			{
				System.out.println("No Low Stock Prodcuts Found.");
				
			}
			
			System.out.println("===========================================================================================");
			
			rs.close();
			stmt.close();
			conn.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public int countProducts()
	{
		int count = 0;
		
		try {
			Connection conn = DBConnection.getConnection();
			
			Statement stmt = conn.createStatement();
			
			String query = "SELECT COUNT(*) FROM product";
			
			System.out.println("Query : " + query);
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				count = rs.getInt(1);
				
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	
}
