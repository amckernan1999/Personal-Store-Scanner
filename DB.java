package Model;
import java.util.*;

// Accessing the SQLite libraries.

import android.database.Cursor;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DB
{/*
    public final FeedReaderDbHelper dbHelper;
    Context context = this.context;

    public DB(){
        dbHelper = new FeedReaderDbHelper(context);
        insertRecords();
    }

    public static final class FeedReaderContract {

        private FeedReaderContract() {}

        // Inner class that defines the table contents
        public static class FeedEntry implements BaseColumns {
            public static final String TABLE_NAME = "Items";
            public static final String COLUMN_CODE = "Code";
            public static final String COLUMN_NAME = "name";
            public static final String COLUMN_PRICE = "Price";
            public static final String COLUMN_DESCRIPTION = "Description";
        }
    }

    //Creating the SQL items table.



    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;



    public class FeedReaderDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "GroceryItems.db";
        public String DATABASE_PATH;

        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                        FeedReaderContract.FeedEntry.COLUMN_CODE + " char(12) PRIMARY KEY, " +
                        FeedReaderContract.FeedEntry.COLUMN_NAME + " varchar(50) NOT NULL, " +
                        FeedReaderContract.FeedEntry.COLUMN_PRICE + " double NOT NULL, " +
                        FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION + " varchar(100) NOT NULL);";

        public FeedReaderDbHelper(Context context) {

            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            DATABASE_PATH = context.getDatabasePath(DATABASE_NAME).getPath();
        }

        // This is called the first time the database is accessed.
        // This is creating the items database table.
        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(SQL_CREATE_ENTRIES);
        }
        // This is called if the database version number changes. It prevents previous users apps from crashing.
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }

    private void insertRecords() {
        // Putting data into the database.
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        // Setting the values that will be inserted into the table.
        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_CODE, "381370036012");
        values.put(FeedReaderContract.FeedEntry.COLUMN_CODE, "190198001757");
        values.put(FeedReaderContract.FeedEntry.COLUMN_CODE, "070330506060");
        values.put(FeedReaderContract.FeedEntry.COLUMN_CODE, "041508800082");
        values.put(FeedReaderContract.FeedEntry.COLUMN_CODE, "787148244069");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME, "Aveeno Lotion");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME, "Lightning to 3.5MM Adapter");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME, "Bic White-out");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME, "San Pelligrino Mineral water");
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME, "Taylor Lane Organic Coffee");
        values.put(FeedReaderContract.FeedEntry.COLUMN_PRICE, 8.54);
        values.put(FeedReaderContract.FeedEntry.COLUMN_PRICE, 7.99);
        values.put(FeedReaderContract.FeedEntry.COLUMN_PRICE, 6.51);
        values.put(FeedReaderContract.FeedEntry.COLUMN_PRICE, 1.45);
        values.put(FeedReaderContract.FeedEntry.COLUMN_PRICE, 17.99);
        values.put(FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION, "18 Fl Oz daily moisturizer ");
        values.put(FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION, "Apple lightning to headphone jack adapter");
        values.put(FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION, "2 Pack quick dry correction fluid");
        values.put(FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION, "12oz Single Can");
        values.put(FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION, "10oz Goat Rock Roast");

        // Insert the new row, returning the primary key value of the new row
        // Inserting the values into the table.
        long newCodeInsert = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, FeedReaderContract.FeedEntry.COLUMN_CODE, values);
        long newNameInsert = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, FeedReaderContract.FeedEntry.COLUMN_NAME, values);
        long newPriceInsert = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, FeedReaderContract.FeedEntry.COLUMN_PRICE, values);
        long newDescriptionInsert = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION, values);
        dbHelper.close();
    }

    private ArrayList<String> selectItemCodes(String Barcode) {
        // Getting data from the database.
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Defines a projection that specifies which columns from the database
        // you will actually use after this query is executed.
        String[] projection = {
                FeedReaderContract.FeedEntry.COLUMN_CODE,
                FeedReaderContract.FeedEntry.COLUMN_NAME,
                FeedReaderContract.FeedEntry.COLUMN_PRICE,
                FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION
        };

        // This is the SSQL where clause arg
        String selection = FeedReaderContract.FeedEntry.COLUMN_CODE + " = ?";
        // Insert the scanner class object for the barcade
        String[] selectionArgs = { Barcode };

        // This is the query being called
        Cursor cursor = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        // Gets all item information from barcode and creates a list
        ArrayList itemData = new ArrayList<String>();
        while(cursor.moveToNext()){
            String itemCode = cursor.getString(
                    cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_CODE));
            itemData.add(itemCode);
            String itemName = cursor.getString(
                    cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME));
            itemData.add(itemName);
            String itemPrice = cursor.getString(
                    cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_PRICE));
            itemData.add(itemPrice);
            String itemDescpt = cursor.getString(
                    cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_DESCRIPTION));
            itemData.add(itemDescpt);
        }
        cursor.close();
        return itemData;
    }
    public Item getItem(String code) {

        ArrayList<String> tempItem = selectItemCodes(code);
        Item item = new Item(tempItem.get(1), tempItem.get(3), Double.parseDouble(tempItem.get(2)));
        return item;

    }
    // Allows DB to be open as long as possible until DB activity is to be closed
    *//*
    @Override
    protected void onDestroy(){
        dbHelper.close();
        super.onDestroy();
    }*//*
*/}