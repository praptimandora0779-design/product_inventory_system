package productinventory.main;

import productinventory.dao.ProductDao;
import productinventory.bean.Product;

public class TestUpdateProduct 
{
	public static void main(String[] args) {
		Product product = new Product(
				106,
				"LED Monitor",
				"Electronics",
				15,
				9000
				);
		
		ProductDao dao = new ProductDao();
		
		int result = dao.updateProduct(product);
		
		if(result>0)
		{
			System.out.println("Product Updated Successfully!");
		}
		else
		{
			System.out.println("Product Not Found!");
		}
	}
}
