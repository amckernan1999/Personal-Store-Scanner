package Model;

import java.util.*;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter; 
//import PaymentInfo;
//import Item;
//import View;

public class Cart
{
	private ArrayList<Item> shoppingCart;
	private String purchaseTime;
	private int orderID;
	private PaymentInfo pInfo;

	public Cart()
	{
		shoppingCart = new ArrayList<Item>();
		purchaseTime = "";
		orderID = 0;
		pInfo = new PaymentInfo();	
	}
	//returns the size of the cart
	public int cartSize(){
		return shoppingCart.size();
	}
	
	//adds n products into the shopping cart
	public void addItem(Item product, int quantity)
	{
		for( int i = 0; i < quantity; i++)
		{
			shoppingCart.add(product);
		}	
	}
	
	//removes n of a single product from the shopping cart
	//If a request to remove more products than the cart has it will remove all products of the given type
	public void removeItem( Item product, int quantity)
	{
		while( shoppingCart.contains(product) && quantity > 0)
		{
			shoppingCart.remove(product);
			quantity--;
		}
	}
	
	// Calculates total price of all items in the cart
	// Returns total cost of all items in cart
	public double calculateTotal() 
	{
		double total = 0;

		for( int i = 0; i < shoppingCart.size(); i++)
		{
			total += shoppingCart.get(i).getPrice();
		}
		
		return total;
	}
	
	//removes all items from cart
	public void clearCart()
	{
		shoppingCart.clear();
	}
	
	//returns item at loc in shoppingCart
	public Item getItemInCart(int loc)
	{
		return shoppingCart.get(loc);
	}
	
	private PaymentInfo getPaymentInfo()
	{
		return pInfo;
	}
	
	public void storePaymentInfo(PaymentInfo pay)
	{
		pInfo = pay;
	}
	
	//creates and stores the purchas time of an order
	//format is 2021/04/19 06:15:10 
	private void createPurchaseTime()
	{
		LocalDateTime purchaseDateTime = LocalDateTime.now();
	    DateTimeFormatter DateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); 
		purchaseTime = DateTimeFormat.format(purchaseDateTime);
	}

	//OrderID starts at 0 and increases with each subsequent order.
	//NUMBERING SYSTEM NOT IMPLEMENTED YET
	private void createOrderId()
	{
		orderID = 1;
	}
	
	//used to store info relavent to a cart object.
	//should be called at purchase completion
	public void storePurchaseInfo()
	{
		createPurchaseTime();
		createOrderId();
	}
	
	public int getOrderID()
	{
	    return orderID;
	}
	
	public String getPurchaseTime()
	{
	    return purchaseTime;
	}
	
}
