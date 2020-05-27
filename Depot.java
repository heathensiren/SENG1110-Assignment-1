/* Author: Mirak Bumnanpol and Lewis Baber
Student number: 3320409,  3321644
Start date 21/04/2019
Name of document: Depot.java
Assignment 1 SENG1110*/
public class Depot
{
	//Instance Variables
	private String depotName;
	private Product p1, p2, p3;
	private int duplicate, invalid;
	
	//Depot constructors 
	public Depot (){
		depotName = "Enter in New Depot";
		p1 = new Product();
		p2 = new Product();
		p3 = new Product();
	}

	//Getters and Setters 
	public void setDepotName(String newDepotName){
		depotName = newDepotName;
	}

	public String getDepotName(){
		return depotName;
	}

	//These methods are for products
	//This method sets the products in the depot
	public String setProductInDepot(String productName, Double productPrice, Double productWeight, int productQuantity)
	{
		String displayMessage = "";
		int duplicate = 0;

		if (this.p1.getProductName().equals(""))
		{
			p1.setProduct(productName, productPrice, productWeight, productQuantity);
		}

			else if (this.p2.getProductName().equals(""))
			{
				p2.setProduct(productName, productPrice, productWeight, productQuantity);
			}
		
		
				else if (this.p3.getProductName().equals(""))
				{
					p3.setProduct(productName, productPrice, productWeight, productQuantity);
				}

		else 
		{
			displayMessage=("Product is filled: " + this.getDepotName());
		}

		if (displayMessage.equals(""))
		{
			displayMessage=("Product is empty");
		}

		return "";
	}

	//This method checks for any duplicate product names 
	public int setProductDuplicate(String productName)
	{
		int duplicate = 1;


		if(this.p1.getProductName().equalsIgnoreCase(productName))
		{
			duplicate = 0;
		}
			else if (this.p2.getProductName().equalsIgnoreCase(productName))
			{
				duplicate = 0;
			}

				else if (this.p3.getProductName().equalsIgnoreCase(productName))
				{
					duplicate = 0;
				}
			return duplicate;
	}

	//This method resets the quantity of products after checking for duplicates
	public void setDuplicateUpdateQuantity(String productName, int productQuantity)
	{
		int newProductQuantity = 0;

		if(this.p1.getProductName().equalsIgnoreCase(productName))
		{
			newProductQuantity = p1.getProductQuantity() + productQuantity;
			p1.setProductQuantity(newProductQuantity);
		}
			else if (this.p2.getProductName().equalsIgnoreCase(productName))
			{
				newProductQuantity = p1.getProductQuantity() + productQuantity;
				p2.setProductQuantity(newProductQuantity);
			}

				else if (this.p3.getProductName().equalsIgnoreCase(productName))
				{
					newProductQuantity = p1.getProductQuantity() + productQuantity;
					p3.setProductQuantity(newProductQuantity);
				}
	}
			
	//This method deletes the products in the depot
	public String setDeleteProductInDepot(String productName)
	{
		String displayMessage= "";
		if (productName.equalsIgnoreCase(p1.getProductName()))
		{
			this.p1.setProductQuantity(p1.getProductQuantity()-1);
			if (p1.getProductQuantity()==0)
			{
				displayMessage=("Product "+p1.getProductName()+" has been removed!");
				p1=new Product ();
			}
		}
		else if (productName.equalsIgnoreCase(p2.getProductName()))
			{
			this.p2.setProductQuantity(p2.getProductQuantity()-1);
			if (p1.getProductQuantity()==0)
			{
				displayMessage=("Product "+p2.getProductName()+" has been removed!");
				p2=new Product ();
			}
			}
		else if (productName.equalsIgnoreCase(p3.getProductName()))
				{
			this.p3.setProductQuantity(p3.getProductQuantity()-1);
			if (p1.getProductQuantity()==0)
			{
				displayMessage=("Product "+p3.getProductName()+" has been removed!");
				p3=new Product ();
			}
				}
		else
		{
			displayMessage = ("This product does not exist. Please try again.");
		}
		return displayMessage;
	}

	//This method queries for a list of products in depot

	public String setProductDetails(String productName, double productPrice, double productWeight, int productQuantity)
	{
		String displayMessage = "";
		duplicate = 0;
		invalid = setProductDuplicate(productName);
		if (invalid==1)
		{
			if(this.p1.getProductName().equals(""))
			{
				p1.setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else if (this.p2.getProductName().equals(""))
			{
				p2.setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else if (this.p3.getProductName().equals(""))
			{
				p3.setProduct(productName, productPrice, productWeight, productQuantity);
				displayMessage =("Product name: " +productName+"\nPrice: "+productPrice+"\nWeight: "+productWeight+"\nQuantity: "+productQuantity);
			}

			else{
			displayMessage=("Only 3 Products per depot can be added. Product filled.");
			}
		}

		else 
		{
			displayMessage = ("This Product already exists");
		}

		return displayMessage;
	}
	//This method displays all the product's details
	public String getProductDetails()
	{
		String displayMessage = "";

			
			if(!p1.getProductName().equals(""))
			{
				displayMessage +=("Product name: " +p1.getProductName()+"\nPrice: "+p1.getProductPrice()+"\nWeight: "+p1.getProductWeight()+"\nQuantity: "+p1.getProductQuantity()+"\n");
			}

			if (!p2.getProductName().equals(""))
			{
				displayMessage +=("Product name: " +p2.getProductName()+"\nPrice: "+p2.getProductPrice()+"\nWeight: "+p2.getProductWeight()+"\nQuantity: "+p2.getProductQuantity()+"\n");
			}

			if (!p3.getProductName().equals(""))
			{
				displayMessage +=("Product name: " +p3.getProductName()+"\nPrice: "+p3.getProductPrice()+"\nWeight: "+p3.getProductWeight()+"\nQuantity: "+p3.getProductQuantity()+"\n");
			}

			if(displayMessage.equals(""))
			{
			displayMessage=("No Products In Depot.");
			}

		return displayMessage;
	}
	//This method tests for a product's presence in the depot
	public String getProductsPresenceDepot(String productName)
	{
		String displayMessage = "";
		if(this.p1.getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +p1.getProductName()+"\nQuantity: "+p1.getProductQuantity()+"\n");
		}
		else if(this.p2.getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +p1.getProductName()+"\nQuantity: "+p2.getProductQuantity()+"\n");
		}
		else if(this.p3.getProductName().equalsIgnoreCase(productName))
		{
			displayMessage = ("Depot name: " +depotName+"\nProduct name: " +p1.getProductName()+"\nQuantity: "+p3.getProductQuantity()+"\n");
		}
		return displayMessage;
	}


	//This method returns the cumulative total of products in  depot
	public double getCumulative()
	{
		double cumulativeValue = ((this.p1.getProductPrice()*this.p1.getProductQuantity()) + (this.p2.getProductPrice()*this.p2.getProductQuantity()) + (this.p3.getProductPrice()*this.p3.getProductQuantity()));
		return cumulativeValue;
	}
	//This method finds the number of products 
	public int numberOfProducts()
	{
		int counter = 3;
		if(this.p1.getProductName().equals(""))
		{
			counter--;
		}
		if(this.p2.getProductName().equals(""))
		{
			counter--;
		}
		if(this.p3.getProductName().equals(""))
		{
			counter--;
		}
		return counter;
	}

	//This method displays the product's name 
	public String getProductNameTwo(int measure)
    {
        String displayMessage = "";
        if (measure == 1)
        {
            displayMessage=p1.getProductName();
        }
        else if (measure == 2)
        {
            displayMessage=p2.getProductName();
        }
        else if (measure == 3)
        {
            displayMessage=p3.getProductName();
        }
        else
        {
        	displayMessage = ("Please Try Again.");
        }
        return displayMessage;
    }

	//This method displays the product's quantity 
	public int getProductQuantityTwo(int measure)
    {
        int displayMessage = 0;
        if (measure == 1)
        {
            displayMessage=p1.getProductQuantity();
        }
        else if (measure == 2)
        {
            displayMessage=p2.getProductQuantity();
        }
        else if (measure == 3)
        {
            displayMessage=p3.getProductQuantity();
        }
        return displayMessage;
    }

    //These methods are for the depot
	//This method checks for any duplicate depot names
	public int setDepotDuplicate(String depotName)
	{
		if(this.getDepotName().equals(depotName))
			{
				return 1;
			}
			else {
				return 0;
			}
	}

}
	