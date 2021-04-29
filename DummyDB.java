package Model;

import java.io.*;

public class DummyDB
{

    private String[][] itemTable = {
            { "381370036012", "Aveeno Lotion", "18 Fl Oz daily moisturizer", "8.54"},
            { "190198001757", "Lightning to 3.5MM Adapter", "Apple lightning to headphone jack adapter", "7.99"},
            { "070330506060", "Bic White-out", "2 Pack quick dry correction fluid", "6.51"},
            { "041508800082", "San Pelligrino Mineral water", "12oz Single Can", "1.45"},
            { "787148244069", "Taylor Lane Organic Coffee",	"10oz Goat Rock Roast",	"17.99"}
    };

    public Item getItem(String code)
    {


        for(int i = 0; i < itemTable.length; i++)
        {
            if( itemTable[i][0].equals(code))
            {
                return new Item(itemTable[i][1], itemTable[i][2], Double.parseDouble(itemTable[i][3]));
            }
        }

        return new Item("Item Not found", "",0);
    }

}