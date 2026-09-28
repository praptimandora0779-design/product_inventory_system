package productinventory.main;

import java.util.Scanner;

import productinventory.dao.ProductDao;
import productinventory.bean.Product;

public class ProductInventoryApp 
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ProductDao dao = new ProductDao();
		
		int choice;
		
		do
		{
			System.out.println();
			
			System.out.println("=============================================================================");
			System.out.println("PRODUCT INVENTORY MANAGEMENT SYSTEM");
			System.out.println("=============================================================================");
			System.out.println("1. Add Product");
			System.out.println("2. Update Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Display All Products");
			System.out.println("5. Search Products By ID");
			System.out.println("6. Search Products By NAME");
			System.out.println("7. Sort Products");
			System.out.println("8. Display Low Stock Products");
			System.out.println("9. Count Total Products");
			System.out.println("10. Exit");
			
			System.out.println("=============================================================================");
			
			System.out.println("Enter Your Choice : ");
			
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1: 
				System.out.println();
				System.out.println("-----------ADD PRODUCT------------");
				System.out.println("Enter Product ID : ");
				int pid = sc.nextInt();
				sc.nextLine();
				
				System.out.print("Enter Product Name : ");
                String pname = sc.nextLine();

                System.out.print("Enter Category : ");
                String category = sc.nextLine();

                System.out.print("Enter Quantity : ");
                int quantity = sc.nextInt();

                System.out.print("Enter Price : ");
                double price = sc.nextDouble();

                Product product = new Product(
                        pid,
                        pname,
                        category,
                        quantity,
                        price
                );

                int result = dao.addProduct(product);

                if (result > 0) {
                    System.out.println("Product Added Successfully!");
                } else {
                    System.out.println("Product Not Added!");
                }

                break;

            case 2:

                System.out.println();
                System.out.println("----- UPDATE PRODUCT -----");

                System.out.print("Enter Product ID : ");
                int updatePid = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter New Product Name : ");
                String updateName = sc.nextLine();

                System.out.print("Enter New Category : ");
                String updateCategory = sc.nextLine();

                System.out.print("Enter New Quantity : ");
                int updateQuantity = sc.nextInt();

                System.out.print("Enter New Price : ");
                double updatePrice = sc.nextDouble();

                Product updateProduct = new Product(
                        updatePid,
                        updateName,
                        updateCategory,
                        updateQuantity,
                        updatePrice
                );

                int updateResult = dao.updateProduct(updateProduct);

                if (updateResult > 0) {
                    System.out.println("Product Updated Successfully!");
                } else {
                    System.out.println("Product Not Found!");
                }

                break;
                
            case 3:

                System.out.println();
                System.out.println("----- DELETE PRODUCT -----");

                System.out.print("Enter Product ID : ");
                int deletePid = sc.nextInt();

                int deleteResult = dao.deleteProduct(deletePid);

                if (deleteResult > 0) {
                    System.out.println("Product Deleted Successfully!");
                } else {
                    System.out.println("Product Not Found!");
                }

                break;

            case 4:

                System.out.println();
                System.out.println("----- ALL PRODUCTS -----");

                dao.displayAllProducts();

                break;

            case 5:

                System.out.println();
                System.out.println("----- SEARCH PRODUCT BY ID -----");

                System.out.print("Enter Product ID : ");
                int searchPid = sc.nextInt();

                dao.searchById(searchPid);

                break;

            case 6:

                System.out.println();
                System.out.println("----- SEARCH PRODUCT BY NAME -----");

                sc.nextLine();

                System.out.print("Enter Product Name : ");
                String searchName = sc.nextLine();

                dao.searchByName(searchName);

                break;

            case 7:

                System.out.println();
                System.out.println("----- SORT PRODUCTS -----");
                System.out.println("1. Product Name - Ascending");
                System.out.println("2. Price - Ascending");
                System.out.println("3. Price - Descending");

                System.out.print("Enter Your Choice : ");

                int sortChoice = sc.nextInt();

                switch (sortChoice) {

                case 1:
                    dao.sortByName();
                    break;

                case 2:
                    dao.sortByPriceAsc();
                    break;

                case 3:
                    dao.sortByPriceDesc();
                    break;

                default:
                    System.out.println("Invalid Sort Choice!");
                }

                break;

            case 8:

                System.out.println();
                System.out.println("----- LOW STOCK PRODUCTS -----");

                dao.displayLowStock();

                break;

            case 9:

                System.out.println();
                System.out.println("----- TOTAL PRODUCTS -----");

                int total = dao.countProducts();

                System.out.println("Total Products : " + total);

                break;

            case 10:

                System.out.println();
                System.out.println("Thank You For Using Product Inventory Management System!");

                break;

            default:

                System.out.println("Invalid Choice! Please Enter 1 to 10.");

            }

        } while (choice != 10);

        sc.close();

			}
	}

