package productinventory.main;

import productinventory.dao.ProductDao;
import productinventory.bean.Product;

public class TestAddProduct 
{
	public static void main(String[] args) 
	{
		Product product = new Product(
					106,
					"Monitor",
					"Electronics",
					10,
					8500
				);
		
		ProductDao dao = new ProductDao();
		
		int result = dao.addProduct(product);
		
		if(result > 0)
		{
			System.out.println("Product Added Successfully!");
		}
		else
		{
			System.out.println("Product Not Added ! ");
		}
	}
}


