package productinventory.main;

import productinventory.dao.ProductDao;

public class TestSearchById 
{
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		
		dao.searchById(103);
		
	}
}
