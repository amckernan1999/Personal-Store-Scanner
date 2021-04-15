import java.util.*;
import PaymentInfo;
import Item;

public class Cart
{
	private ArrayList<Item> shoppingCart = new ArrayList<Item>();
	
	private String purchaseTime;
	private int orderID;
	private PaymentInfo pInfo;
	
	public void addItem(Item product, int quantity)
	{
		
	}
	
	public void removeItem( Item product, int quantity)
	{
		
	}
	
	public double calculateTotal() 
	{
		double total = 0;
		
		return total;
	}
	
	public void clearCart()
	{
		
	}
	
	public Item getItemInCart(int loc)
	{
		Item i = new Item();
		return i;
	}
	
	private PaymentInfo getPaymentInfo()
	{
		PaymentInfo pay = new PaymentInfo();
	}
	
	public void storePaymentInfo(PaymentInfo pay)
	{
		
	}
	
	public void storePurchaseInfo()
	{
		
	}
	
	private void createPurchaseTime()
	{
		
	}
	
	private void createOrderId()
	{
		
	}
}
