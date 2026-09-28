package productinventory.main;

import productinventory.dao.ProductDao;

public class TestDeleteProduct 
{
	public static void main(String[] args) 
	{
		ProductDao dao = new ProductDao();
		
		int result = dao.deleteProduct(106);
		
		if(result > 0)
		{
			System.out.println("Product deleted successfully!");
		}else
		{
			System.out.println("Product not found!");
		}
		
	}
}
