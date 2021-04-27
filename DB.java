package com.example.MyApplication;

// Accessing the SQLite libraries.
import android.context.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class FeedReaderContract {

    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "Items";
        public static final String COLUMN_CODE = "Code";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "Price";
        public static final String COLUMN_DESCRIPTION = "Description";
    }
}

//Creating the SQL items table.
private static final String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
        FeedEntry.COLUMN_CODE + " char(12) PRIMARY KEY, " +
        FeedEntry.COLUMN_NAME + " varchar(50) NOT NULL, " +
        FeedEntry.COLUMN_PRICE + " double NOT NULL, " +
        FeedEntry.COLUMN_DESCRIPTION + " varchar(100) NOT NULL);";

private static final String SQL_DELETE_ENTRIES =
        "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

public static final FeedReaderDbHelper dbHelper = new FeedReaderDbHelper(getContext());

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "GroceryItems.db";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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
    values.put(FeedEntry.COLUMN_CODE, '123123123123');
    values.put(FeedEntry.COLUMN_CODE, '234234234234');
    values.put(FeedEntry.COLUMN_CODE, '345345345345');
    values.put(FeedEntry.COLUMN_CODE, '456456456456');
    values.put(FeedEntry.COLUMN_CODE, '567567567567');
    values.put(FeedEntry.COLUMN_NAME, "Kellogg's Special K");
    values.put(FeedEntry.COLUMN_NAME, 'Jif Peanut Butter');
    values.put(FeedEntry.COLUMN_NAME, 'Doritos Chips');
    values.put(FeedEntry.COLUMN_NAME, "Dave's Killer Bread");
    values.put(FeedEntry.COLUMN_NAME, 'Chobani Greek Yogurt');
    values.put(FeedEntry.COLUMN_PRICE, 6.99);
    values.put(FeedEntry.COLUMN_PRICE, 5.99);
    values.put(FeedEntry.COLUMN_PRICE, 3.49);
    values.put(FeedEntry.COLUMN_PRICE, 7.99);
    values.put(FeedEntry.COLUMN_PRICE, 4.99);
    values.put(FeedEntry.COLUMN_DESCRIPTION, 'Frosted cereal with red berries. 1 Box');
    values.put(FeedEntry.COLUMN_DESCRIPTION, 'All natural smooth peanut butter. 1 Jar');
    values.put(FeedEntry.COLUMN_DESCRIPTION, 'Nacho Cheese flavored. 8 Oz Bag');
    values.put(FeedEntry.COLUMN_DESCRIPTION, '21 whole grain bread. 1 Pack');
    values.put(FeedEntry.COLUMN_DESCRIPTION, 'Strawberry flavored. Pack of 4');

    // Insert the new row, returning the primary key value of the new row
    // Inserting the values into the table.
    long newCodeInsert = db.insert(FeedEntry.TABLE_NAME, FeedEntry.COLUMN_CODE, values);
    long newNameInsert = db.insert(FeedEntry.TABLE_NAME, FeedEntry.COLUMN_NAME, values);
    long newPriceInsert = db.insert(FeedEntry.TABLE_NAME, FeedEntry.COLUMN_PRICE, values);
    long newDescriptionInsert = db.insert(FeedEntry.TABLE_NAME, FeedEntry.COLUMN_DESCRIPTION, values);
}

private ArrayList<>() selectItemCodes(String Barcode) {
    // Getting data from the database.
    SQLiteDatabase db = dbHelper.getReadableDatabase();

    // Defines a projection that specifies which columns from the database
    // you will actually use after this query is executed.
    String[] projection = {
        BaseColumns.COLUMN_CODE,
        FeedEntry.COLUMN_NAME,
        FeedEntry.COLUMN_PRICE,
        FeedEntry.COLUMN_DESCRIPTION
    };

    // This is the SSQL where clause arg
    String selection = FeedEntry.COLUMN_CODE + " = ?";
    // Insert the scanner class object for the barcade
    String[] selectionArgs = { Barcode };

    // This is the query being called
    Cursor cursor = db.query(
        FeedEntry.TABLE_NAME,
        projection,
        selection,
        selectionArgs,
        null,
        null,
        sortOrder
        );

    // Gets all item information from barcode and creates a list
    List itemData = new ArrayList<>();
    while(cursor.moveToNext()){
        Long itemCode = cursor.getLong(
            cursor.getColumnIndex(FeedEntry.COLUMN_CODE));
        itemData.add(itemCode);
        String itemName = cursor.getString(
                cursor.getColumnIndex(FeedEntry.COLUMN_NAME));
        itemData.add(itemName);
        Long itemPrice = cursor.getLong(
                cursor.getColumnIndex(FeedEntry.COLUMN_PRICE));
        itemData.add(itemPrice);
        String itemDescpt = cursor.getString(
                cursor.getColumnIndex(FeedEntry.COLUMN_DESCRIPTION));
        itemData.add(itemDescpt);
    }
    cursor.close();
    return itemData;
}

// Allows DB to be open as long as possible until DB activity is to be closed
@Override
protected void onDestroy(){
    dbHelper.close();
    super.onDestroy();
}
