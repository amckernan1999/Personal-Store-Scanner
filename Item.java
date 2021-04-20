import java.util.*;
import javax.ImageIO;

public class Item
{
	private String name;
	private String description;
	private double price;
	private BufferedImage image;
	
	public Item()
	{
		name = "";
		description = "";
		price = 0.0;
		image = ImageIO.read(new File ("empty.png"));

	}
	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public File getImage()
	{
		return image;
	}
	
	public double getPrice()
	{
		return double;
	}
}
