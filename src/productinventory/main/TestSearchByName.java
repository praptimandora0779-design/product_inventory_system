package productinventory.main;

import productinventory.dao.ProductDao;

public class TestSearchByName 
{
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		
		dao.searchByName("Mouse");
	}
}
