package Model;
//import PaymentInfo;
//import Cart;
import java.util.*;

public class User
{
	
	private String username;
	private String password;
	
	private ArrayList<Cart> cartHistory; 
	private ArrayList<PaymentInfo> savedPayment;
	
	//null constructor assigns default values
	public User()
	{
		username = "";
		password = "";
		cartHistory = new ArrayList<Cart>();
		savedPayment = new ArrayList<PaymentInfo>();
	}

	//stores string in field to save username
	public void setUsername(String uName)
	{
		username = uName;
	}
	
	//stores string in field to save password
	public void setPassword(String pWord) 
	{
		password = pWord;
	}
	
	//compares by value saved username and input passed
	public boolean checkUsername(String uName)
	{
		return username.equals(uName);
	}
	
	//compares by value saved password and input passed
	public boolean checkPassword(String pWord)
	{
		return password.equals(pWord);
	}
	
	//stores cart in array list cart history for purchase records
	public void storeCartHistory(Cart info)
	{
		cartHistory.add(info);
	}
	
	// returns a cart in cart history for lookup later
	public Cart getCartInHistory(int loc) 
	{
		return cartHistory.get(loc);
	}
	
	//saves a payment for later transactions
	public void savePay(PaymentInfo pay)
	{
		savedPayment.add(pay);
	}
	
	//returns info of specific payment
	public PaymentInfo getPayment(int loc)
	{
		return savedPayment.get(loc);
	}

}
