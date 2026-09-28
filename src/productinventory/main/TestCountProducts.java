package productinventory.main;

import productinventory.dao.ProductDao;

public class TestCountProducts 
{
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		
		int total = dao.countProducts();
		
		System.out.println("Total Products : " + total);
	}
}
