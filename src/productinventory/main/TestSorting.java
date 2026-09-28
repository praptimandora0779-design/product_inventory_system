package productinventory.main;

import productinventory.dao.ProductDao;

public class TestSorting 
{
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		
		System.out.println("***************** Sort By Name ******************");
		
		dao.sortByName();
		
		System.out.println();
		
		System.out.println("**************** Sort By Price Ascending *****************");
		
		dao.sortByPriceAsc();
		
		System.out.println();
		
		System.out.println("99************* Sort By Price Descending *******************");
		
		dao.sortByPriceDesc();
		
	}
}
