package com.example.hotspots1;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class HotSpotDataSource {
    DBHelper myhelper;

    public HotSpotDataSource(Context context) {
        myhelper = new DBHelper(context);
    }

    public long insertData(String name, String dish, String rating) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.estName, name);
        contentValues.put(DBHelper.address, dish);
        contentValues.put(DBHelper.WineR, rating);
        contentValues.put(DBHelper.MusicR, rating);
        contentValues.put(DBHelper.BeerR, rating);
        long id = dbb.insert(DBHelper.table, null, contentValues);
        return id;
    }


    static class DBHelper extends SQLiteOpenHelper {
        private static final String database_name = "myDatabase";    // Database Name
        private static final String table = "myTable";   // Table Name
        private static final int database_version = 1;   // Database Version
        private static final String nameID = "_nameID";     // Column I (Primary Key)
        private static final String estName = "Establishment";    //Column II
        private static final String address = "Address";    // Column III
        private static final String BeerR = "BeerSelectionRating";//column IV
        private static final String WineR = "WineSelectionRating";
        private static final String MusicR = "MusicSelectionRating";
        private static final String create_table = "CREATE TABLE " + table +
                " (" + nameID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + estName + " VARCHAR(255) ," + address + " VARCHAR(225)," + BeerR + "  VARCHAR(50)," + WineR + "  VARCHAR(50)," + MusicR + "  VARCHAR(50));";
        private static final String drop = "DROP TABLE IF EXISTS " + table;
        private Context context;

        public DBHelper(Context context) {
            super(context, database_name, null, database_version);
            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(create_table);
            } catch (Exception e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Toast.makeText(context, "Upgrade of Database", Toast.LENGTH_LONG).show();
                db.execSQL(drop);
                onCreate(db);
            } catch (Exception e) {
                Toast.makeText(context, "" + e, Toast.LENGTH_LONG).show();
            }
        }


    }
}

