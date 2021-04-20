import java.util.*;
public class PaymentInfo
{
	public String billingAddress;
	public String nameOnCard;
	public String zipcode;
	public String expDate;
	public String ccNum;
	public Bool saveInfo; 

	public PaymentInfo()
	{
		billingAddress = "";
		nameOnCard = "";
		zipcode = "";
		expDate = "";
		ccNum = "";
		saveInfo = false;
	}
	
}