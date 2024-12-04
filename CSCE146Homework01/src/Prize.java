/*
 * Stores prize details
 */
public class Prize {
	private String name;
	private double price;
	public Prize(String name, double price) 
	{
		this.name = name;
		this.price = price;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public double getPrice() 
	{
		return price;
	}

}
