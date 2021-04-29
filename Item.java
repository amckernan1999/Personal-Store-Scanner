package Model;

import java.util.*;
//import javax.ImageIO;

public class Item
{
	private String name;
	private String description;
	private double price;
    //	private BufferedImage image;
	
	public Item(String nm, String descript, double prc)
	{
		name = nm;
		description = descript;
		price = prc;
	//	image = ImageIO.read(new File ("empty.png"));

	}
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
/*Not yet functional
*
*   public File getImage()
*	{
*		return image;
*   }
*/
	public double getPrice()
	{
		return price;
	}
}
