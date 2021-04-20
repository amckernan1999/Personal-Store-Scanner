import java.util.*;
import PaymentInfo;
import Item;
import View;

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
			total += shoppingCart.get(i).price;
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
		PaymentInfo pay = new PaymentInfo();
	}
	
	public void storePaymentInfo(PaymentInfo pay)
	{
		
	}
	
	public void storePurchaseInfo()
	{
		
	}
	
	//creates and stores the purchas time of an order
	//format is 2021/04/19 06:15:10 
	private void createPurchaseTime()
	{
		Date time = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		purchaseTime = dateFormat.formate(time);

	}
	

	//OrderID starts at 0 and increases with each subsequent order.
	private void createOrderId()
	{
		orderId = View.currOrderId;
		View.currOrderId++;
	}
}
