package productinventory.main;

import productinventory.dao.ProductDao;

public class TestLowStock {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		
		dao.displayLowStock();
	}
}
