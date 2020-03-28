package ir.quantumsoft.al_sahifaal_sajjadiyya;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AliSalehi on 22/06/2017.
 */

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;
    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */

    public List<String> getArabicFvList (){

        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM arabicSahifa WHERE isMarked = 1 ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;


    }


    public String getArabicFavSupp (String title){

        Cursor cursor = database.rawQuery("SELECT * FROM arabicSahifa WHERE title = \"" + title + "\" ", null);
        cursor.moveToFirst();
        String supp = "";
        while (!cursor.isAfterLast()) {

            supp = cursor.getString(2);
            cursor.moveToNext();
        }


        return supp;
    }


    public void addToFavArabic (int position){

        database.execSQL("UPDATE arabicSahifa SET isMarked = 1 WHERE id ="+ position +"" );
        Log.i("Marked" , "is Marked");

    }

    public String getArabicSuppTitle (int position){
        String title = "";

        Cursor cursor = database.rawQuery("SELECT * FROM arabicSahifa WHERE id = " + position + "", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            title = cursor.getString(1);
            cursor.moveToNext();
        }

        return title;

    }

    public String getArabicSuppContext (int position) {

        Cursor cursor = database.rawQuery("SELECT * FROM arabicSahifa WHERE id = " + position + "", null);
        cursor.moveToFirst();
        String supp = "";
        while (!cursor.isAfterLast()) {
            supp = cursor.getString(2);
            cursor.moveToNext();
        }

        return supp;
    }

    public List<String> getTitles() {
        List<String> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM arabicSahifa", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            list.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}