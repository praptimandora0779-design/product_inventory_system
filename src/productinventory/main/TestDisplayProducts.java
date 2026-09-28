package productinventory.main;

import productinventory.dao.ProductDao;

public class TestDisplayProducts 
{
	public static void main(String[] args) 
	{
		ProductDao dao = new ProductDao();
		
		dao.displayAllProducts();
	}
}
