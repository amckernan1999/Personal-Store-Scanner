
//This class is used primarily for testing, as well as seeing showing
//the functions should be utilized within the actual view

public class Main
{
	public static void main(String[] args) {
		
		//sample items used for testing
		Item gum = new Item("Spearmint Gum", "36 pack of minty gum", 3.05);
		Item soda = new Item("Rootbeer", "12oz can of rootbeer", .99);
		Item canBeans = new Item("Black Beans", "12oz organic sustainably sourced Black Beans", 1.95);
		
		//Basic Test showing Item properly stores all values
		System.out.format("****BASIC ITEM TEST****\nName: " + canBeans.getName() + "\nDescription: " + canBeans.getDescription() + "\nPrice: %.2f", canBeans.getPrice());
		System.out.println("");
	
		
		//tests that the cart stores items properly
		Cart andrewCart = new Cart();
		andrewCart.addItem(canBeans, 1);
		andrewCart.addItem(gum, 1);
		andrewCart.addItem(soda, 2);
		
		//calculateTotal is working
		System.out.format("\n****BASIC CALCULATE TOTAL TEST****\nExpected total = 6.98\nActual total = %.2f", andrewCart.calculateTotal());
		System.out.println("");
		
		//removeItem is working
		andrewCart.removeItem(soda, 1);
		System.out.format("\n****BASIC REMOVE ITEM****\nExpected total = 5.99\nActual total = %.2f", andrewCart.calculateTotal());
		System.out.println("");
		
		//clearCart is functional
		andrewCart.clearCart();
	    System.out.format("\n****BASIC CLEAR CART TEST****\nExpected total = 0\nActual total = %.2f", andrewCart.calculateTotal());
	    System.out.println("");
	    
	    //cart filled up
	    andrewCart.addItem(canBeans, 100);
		andrewCart.addItem(gum, 100);
		andrewCart.addItem(soda, 101);
		
		//calculateTotal stress test
		System.out.format("\n****STRESS CALCULATE TOTAL TEST****\nExpected total = 599.99\nActual total = %.2f", andrewCart.calculateTotal());
		System.out.println("");
	
		//simulates the checkout proccess 
		andrewCart.storePurchaseInfo();
		System.out.format("\n****ORDER ID TEST****\nExpected order id: 1\nActual order id: %d\n" , andrewCart.getOrderID());
		System.out.format("\n****ORDER DATE/TIME test****\nExpected Date/time: *current date/time*\nActual Date/time: " + andrewCart.getPurchaseTime() + "\n");
		
		User andrew = new User();
		
		//sets user password and name
		andrew.setUsername("mckernana");
		andrew.setPassword("password123");
		
		//inputs wrong username
		System.out.println("\n****Test Wrong Username****");
		if(andrew.checkUsername("wrong"))
		{
		    System.out.println("Access granted");
		}
		else
		{
		    System.out.println("Access denied");
		}
		
		//inputs right username
		System.out.println("\n****Test Right Username****");
		if(andrew.checkUsername("mckernana"))
		{
		    System.out.println("Access granted");
		}
		else
		{
		    System.out.println("Access denied");
		}
		
		//inputs wrong username
		System.out.println("\n****Test Wrong Password****");
		if(andrew.checkPassword("wrong"))
		{
		    System.out.println("Access granted");
		}
		else
		{
		    System.out.println("Access denied");
		}
		
		//inputs wrong username
		System.out.println("\n****Test Right Password****");
		if(andrew.checkPassword("password123"))
		{
		    System.out.println("Access granted");
		}
		else
		{
		    System.out.println("Access denied");
		}
		
		//testing carts are stored properly
		andrew.storeCartHistory(andrewCart);
		System.out.format("\n****STORED CART TOTAL TEST****\nExpected total = 599.99\nActual total = %.2f", andrew.getCartInHistory(0).calculateTotal());
		System.out.println("");
		
		PaymentInfo andrewCard = new PaymentInfo("123 Main Street", "Andrew McKernan", "12345", "1/23", "1234 5678 9123 4567", true); 
		andrew.savePay(andrewCard);
		
		System.out.println("\n****Testing Stored PaymentInfo****");
		System.out.println("Address: " + andrew.getPayment(0).billingAddress);
		System.out.println("Full Name: " + andrew.getPayment(0).nameOnCard);
		System.out.println("Zipcode: " + andrew.getPayment(0).zipcode);
		System.out.println("Expiration Date: " + andrew.getPayment(0).expDate);
		System.out.println("Credit Card Number: " + andrew.getPayment(0).ccNum);
		System.out.println("Save Preference: " + andrew.getPayment(0).saveInfo);
		
		
		
		
		
		
		
	}
}
