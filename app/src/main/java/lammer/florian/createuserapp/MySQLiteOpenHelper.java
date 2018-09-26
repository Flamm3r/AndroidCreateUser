package lammer.florian.createuserapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    //DatabaseVersion
    private static final int DATABASE_VERSION = 1;
    //DatabaseName
    private static final String DATABASE_NAME = "LoginDB";
    //Create Anweisung
    private static final String DATABASE_CREATE =   "CREATE TABLE login ( " +
                                                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                    "userID TEXT, "+
                                                    "userPW TEXT )";

    public MySQLiteOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /* TO-DO */
    }
}
