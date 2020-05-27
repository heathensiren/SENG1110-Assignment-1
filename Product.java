/* Author: Mirak Bumnanpol and Lewis Baber 
Student number: 3320409, 3321644
Start date 21/04/2019
Name of document: Product.java
Assignment 1 SENG1110*/
public class Product
{
	//Instance Variables
	private String productName;
	private double productPrice, productWeight;
	private int productQuantity;
	
	//Constructor to set values 
	public Product()
	{
		productName = "";
		productPrice = 0;
		productWeight = 0;
		productQuantity = 0;
	}

	public void setProduct(String newProductName, double newProductPrice, double newProductWeight, int newProductQuantity)
	{
		productName = newProductName.toLowerCase();
		productPrice = newProductPrice;
		productWeight = newProductWeight;
		productQuantity = newProductQuantity;
	}

	// Getters and Setters
	public void setProductName(String newProductName)
	{
		productName = newProductName.toLowerCase();
	}

	public String getProductName()
	{
		return productName;
	}

	public void setProductPrice(double newProductPrice)
	{
		productPrice = newProductPrice;
	}

	public double getProductPrice()
	{
		return productPrice;
	}

	public void setProductWeight(double newProductWeight)
	{
		productWeight = newProductWeight;
	}

	public double getProductWeight()
	{
		return productWeight;
	}

	public void setProductQuantity(int newProductQuantity)
	{
		productQuantity = newProductQuantity;
	}

	public int getProductQuantity()
	{
		return productQuantity;
	}

}