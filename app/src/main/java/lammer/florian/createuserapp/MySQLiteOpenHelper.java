package lammer.florian.createuserapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //DatabaseVersion
    private static final int DATABASE_VERSION = 2;
    //DatabaseName
    private static final String DATABASE_NAME = "Login.db";
    //Tabel Name
    private static final String TABLE_NAME = "TABLE_LOGIN";
    //Column names
    public static final String COL_1 = "DB_ID";
    public static final String COL_2 = "USER_ID";
    public static final String COL_3 = "USER_PW";
    //Database
    SQLiteDatabase db;


    //Create Anweisung
    private static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (DB_ID integer PRIMARY KEY NOT NULL , " +
                                                "USER_ID TEXT NOT NULL, USER_PW TEXT NOT NULL)";

    /*
    private static final String DATABASE_CREATE =   "CREATE TABLE DATABASE_NAME ( " +
                                                    "DB_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                    "USER_ID TEXT, "+
                                                    "USER_PW TEXT )";
    */

    //Construktor
    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }


    /*
    public void insertData(String userID, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, userID);
        contentValues.put(COL_3, password);
    }
    */

    public void insertContact(Contact c){
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        values.put(COL_1, count);
        values.put(COL_2, c.getUser_ID());
        values.put(COL_3, c.getPassword());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String user_name){
        db = this.getReadableDatabase();
        String query = "SELECT USER_ID, USER_PW FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a,b;

        b = "not found";

        if(cursor.moveToFirst()){
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);

                if(a.equals(user_name)){
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }

        return b;
    }


    /*
    public Cursor getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT " + COL_2 + " from " + TABLE_NAME, null);
        return res;
    }

    public Cursor query(String login){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT " + COL_2 + " FROM " + TABLE_NAME + " WHERE " + COL_2 + "='" + login + "';", null);
        return res;
    }
    */

}
