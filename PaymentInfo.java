package Model;

import java.util.*;
public class PaymentInfo
{
	public String billingAddress;
	public String nameOnCard;
	public String zipcode;
	public String expDate;
	public String ccNum;
	public boolean saveInfo; 

	public PaymentInfo()
	{
		billingAddress = "";
		nameOnCard = "";
		zipcode = "";
		expDate = "";
		ccNum = "";
		saveInfo = false;
	}
	
	public PaymentInfo(String adr, String name, String zip, String exp, String cc, boolean save)
	{
	    billingAddress = adr;
		nameOnCard = name;
		zipcode = zip;
		expDate = exp;
		ccNum = cc;
		saveInfo = save;
	}
	
}