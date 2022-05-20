/* Author: Mirak Bumnanpol and Lewis Baber
Student number: 3320409, 3321644
Start date 21/04/2019
Name of document: Interface.java
Assignment 1 SENG1110*/
import java.util.*;
public class Interface 
{	
	//Instance Variables	
	private static Depot D1 = new Depot();
	private static Depot D2 = new Depot();
	private static String productName, depotName, depotDeletion, productDeletion;
	private static double productPrice, productWeight;
	private static int productQuantity;
	private static Scanner keyboard = new Scanner(System.in);

	public static void main (String[] args)
	{
		Interface intFace = new Interface();
		intFace.run();
	}

	private void run(){
		System.out.println("Alcoworths Supermarket System");
		int a, b, counter;
		counter = 2;
		do
		{
			//This is the main menu
			System.out.println("\n******MAIN MENU******");
			System.out.println("\nEnter the number next to the action you require to proceed");
			System.out.println(" (1) Add/Remove a Depot");
			System.out.println(" (2) Add/Remove a Product");
			System.out.println(" (3) Depot List");
			System.out.println(" (4) Product List");
			System.out.println(" (5) Cumulative Value");
			System.out.println(" (6) Close Program");
			a = keyboard.nextInt();
			//This is the switch for the main menu
			switch(a)
			{
				case 1:
					System.out.println("******ADD/REMOVE DEPOT******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("Selecting the number next to an existing Depot will it");
					System.out.println("(1)" + D1.getDepotName());
					System.out.println("(2)" + D2.getDepotName());
					System.out.println("Remove a depot (3)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					//This looks for a depot duplicate
					if((!D1.getDepotName().equalsIgnoreCase("Enter in New Depot")&&(b==1))||(!D2.getDepotName().equalsIgnoreCase("Enter in New Depot"))&&(b==2))
					{
						System.out.println("There is already a depot created");

					}
					else
					{
						changeDepot(b);
					}
					break;

				case 2:
					System.out.println("******ADD/REMOVE PRODUCT******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("Add a product (1)");
					System.out.println("Remove a product (2)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					changeProductDepot(b);
					break;

				case 3:
					System.out.println("******DEPOT LIST*******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("See all Depots (1)");
					System.out.println("Search for Depots by name (2)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					depotList(b);
					break;

				case 4:
					System.out.println("******PRODUCT LIST******");
					System.out.println("\nEnter the number next to the action you require to proceed");
					System.out.println("Search Products in Depots (1)");
					System.out.println("Search for Products by name (2)");
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					productList(b);
					break;

				case 5:
					System.out.println("******CUMULATIVE VALUE******");
					System.out.println("\nEnter in the Depot Name");
					depotName = keyboard.next();
					//This multiplies each respective depot's product's price to quantity 
					if(depotName.equalsIgnoreCase(D1.getDepotName()) || depotName.equalsIgnoreCase(D2.getDepotName()))
					{
						int depotPostion=0;
						if(depotName.equals(D1.getDepotName()))
						{
							depotPostion=1;
						}
						else if (depotName.equals(D2.getDepotName()))
						{
							depotPostion=2;
						}

						cumulativeValue(depotPostion);
					}
					else
					{
						System.out.println("This Depot does not exist");
					}
					System.out.println("Return to menu page (0)");
					b = keyboard.nextInt();
					break;

				case 6:
					System.out.println("******PROGRAM CLOSING******");
					System.exit(0);
					break;

				default: 
					System.out.println("Invalid Input");

				}

		}
		while (counter > 1);
		counter++;		
	}
	//Adding and Removing Depots 
	private static void changeDepot(int b)
	{
		depotName = "";
		switch(b)
		{
			//This is the switch case for adding depot 1 
			case 1:
				System.out.println("******ADDING TO DEPOT 1******");
				while(depotName.equals(""))
				{
					System.out.println("Add First Depot Name");
					depotName = keyboard.next();
					System.out.println("New Depot Added!");
					if(depotName.equalsIgnoreCase(D1.getDepotName()) || depotName.equalsIgnoreCase(D2.getDepotName())){
						System.out.println("This Depot already exists");
					}
					else
					{
					D1.setDepotName(depotName);
					}
				}
				break;
			//This is the switch case for adding depot 2
			case 2:
				System.out.println("******ADDING TO DEPOT 2******");
				while(depotName.equals(""))
				{
					System.out.println("Add Second Depot Name");
					depotName = keyboard.next();
					System.out.println("New Depot Added!");
					if(depotName.equalsIgnoreCase(D1.getDepotName()) || depotName.equalsIgnoreCase(D2.getDepotName())){
						System.out.println("This Depot already exists");
					}
					else
					{
					D2.setDepotName(depotName);
					}
				}
				break;
			//This is the switch case for removing depots 
			case 3:
				System.out.println("******DELETE DEPOTS******");
				
				{
					System.out.println("Enter name of depot you want to delete");
					depotDeletion = keyboard.next();
					if(depotDeletion.equalsIgnoreCase(D1.getDepotName()))
					{
						D1 = new Depot();
						break;
					}
					else if(depotDeletion.equalsIgnoreCase(D2.getDepotName()))
					{
						D2 = new Depot();
						break;
					}
					System.out.println("No Depot by that Name");
					//changeDepot(3);
					
				}
				break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");
		}

	}

	//Adding and Removing Products within the Depot
	private static void changeProductDepot(int b)
	{
		productName="";
		productPrice=0;
		productWeight=0;
		productQuantity=0;
		switch(b)
		{
			case 1:
				System.out.println("******ADDING PRODUCTS******");
				while(productName.equals(""))
				{
					System.out.println("Add Product Name");
					productName = keyboard.next();
				}

				if((D1.setProductDuplicate(productName)==0)||(D2.setProductDuplicate(productName)==0))
				{
					while(productQuantity<=0)
					{
					System.out.println("Enter Product's Quantity");
					productQuantity = keyboard.nextInt();
						if(productQuantity <= 0)
						{
							System.out.print("Invalid Input, Please enter a positive Integer");
						}
					}
					D1.setDuplicateUpdateQuantity(productName,productQuantity);
					D2.setDuplicateUpdateQuantity(productName,productQuantity);
					break;
				}

				while(productPrice<=0)
				{
					System.out.println("Enter Product's Price");
					productPrice = keyboard.nextDouble();
					if(productPrice <= 0)
					{
						System.out.print("Invalid Input, Please enter a positive Number");
					}
				}

				while(productWeight<=0)
				{
					System.out.println("Enter Product's Weight");
					productWeight = keyboard.nextDouble();
						if(productWeight <= 0)
						{
							System.out.print("Invalid Input, Please enter a positive Number");
						}
				}

				while(productQuantity<=0)
				{
					System.out.println("Enter Product's Quantity");
					productQuantity = keyboard.nextInt();
						if(productQuantity <= 0)
						{
							System.out.print("Invalid Input, Please enter a positive Integer");
						}
				}
				System.out.println("Add Product to Depot: ");
				depotName = keyboard.next();
				System.out.println("New Product Added!");
				if(depotName.equalsIgnoreCase(D1.getDepotName()))
				{

					System.out.println(D1.setProductDetails(productName, productPrice, productWeight, productQuantity));	
				}
				else if(depotName.equalsIgnoreCase(D2.getDepotName()))
				{
					System.out.println(D2.setProductDetails(productName, productPrice, productWeight, productQuantity));	
				}
				else 
				{
					System.out.println("No Depot by that name, try again\n");
				}
				break;
			//This is the switch case for removing products 
			case 2:
				System.out.println("******REMOVING PRODUCTS******");
				System.out.println("What Depot do you wish to remove a product from?: ");
				depotName = keyboard.next();
				if(depotName.equals(D1.getDepotName())){
					System.out.println("What product would you like to remove?");
					productDeletion = keyboard.next();
					System.out.println(D1.setDeleteProductInDepot(productDeletion));
				}
				else if(depotName.equals(D2.getDepotName())){
					System.out.println("What product would you like to remove?");
					productDeletion = keyboard.next();
					System.out.println(D2.setDeleteProductInDepot(productDeletion));
					
				}
				else {
					System.out.println("No Depot by that name, try again");
				}
		
				break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");
		}
	}

	//This method shows all the Depots in the depot list 
	private static void depotList(int a)
	{
		switch(a)
		{
			case 1:
				System.out.println("******ALL DEPOTS******");
				System.out.println(D1.getDepotName()+" has "+D1.numberOfProducts()+ " products");
				System.out.println(D2.getDepotName()+" has "+D2.numberOfProducts()+" products");
			break;

			case 2:
				System.out.println("******SEARCHING FOR DEPOT NAMES******");
				System.out.println("\nEnter the name of the Depot");
				depotName = keyboard.next();
				if(depotName.equalsIgnoreCase(D1.getDepotName()))
				{
					System.out.println(D1.getDepotName()+" has "+ D1.numberOfProducts()+ " products");
				}

				else if(depotName.equalsIgnoreCase(D2.getDepotName()))
				{
					System.out.println(D2.getDepotName()+" has "+ D2.numberOfProducts()+ " products");
				}
				else
				{
					System.out.println("No Depot by that name, try again");
				}
			break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");

		}
	}
	//This method shows all the products in their specific depot
	private static void productList(int a)
	{
		switch(a)
		{
			case 1:
				System.out.println("******ALL PRODUCTS******");
				System.out.println("\nEnter the name of the depot that the product is in");
				depotName = keyboard.next();
				if(depotName.equalsIgnoreCase(D1.getDepotName()))
				{
					System.out.println(D1.getProductDetails());
				}

				else if(depotName.equalsIgnoreCase(D2.getDepotName()))
				{
					System.out.println(D2.getProductDetails());
				}

				else {
					System.out.println("No Depots by that name, try again");
				}
			break;

			case 2:
				System.out.println("******ALL PRODUCTS******");
				System.out.println("\n Enter the product name");
				productName = keyboard.next();
				String message ="";
				message = D1.getProductsPresenceDepot(productName);
				if (message.equals(""))
				{
					message = D2.getProductsPresenceDepot(productName);
				}
				else if(message.equals(""))
				{
					System.out.println("Product does not exist");
				}
				else
				{
					System.out.println(message);
				}
			break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");

		}
	}
	//This is the method for seeing the cumulative value of a product's quantity and price
	private static void cumulativeValue(int a)
	{
		switch(a)
		{
			case 1:
				System.out.println("******CUMULATIVE VALUE******");
				System.out.println(D1.getDepotName()+" Cumulative Value is: $" + D1.getCumulative());
				
			break;

			case 2:
				System.out.println("******CUMULATIVE VALUE******");
				System.out.println(D2.getDepotName()+" Cumulative Value is: $" + D2.getCumulative());

			break;

			case 0:
			break;

			default: 
				System.out.println("Invalid Input");
		}
	}
}