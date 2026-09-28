package productinventory.bean;

public class Product 
{
	private int pid;
	private String pname;
	private String category;
	private int quantity;
	private double price;
	
	public Product()
	{
		
	}
	
	public Product(int pid, String pname, String category, int quntity, double price)
	{
		this.pid= pid;
		this.pname = pname;
		this.category = category;
		this.quantity = quntity;
		this.price = price;
	}
	
	public int getPid()
	{
		return pid;
	}
	
	public void setPid(int pid)
	{
		this.pid = pid;
	}
	
	public String getPname()
	{
		return pname;
	}
	
	public void setPname(String pname)
	{
		this.pname = pname;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
}
