package lammer.florian.createuserapp;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static lammer.florian.createuserapp.MySQLiteOpenHelper.COL_2;
import static lammer.florian.createuserapp.MySQLiteOpenHelper.COL_3;

public class UserProfile extends AppCompatActivity{

    TextView userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        userID = findViewById(R.id.labelUserID);

        final MySQLiteOpenHelper dbHelper = new MySQLiteOpenHelper(this);

        Cursor res = dbHelper.query("read1");


        userID.setText(res.getString(res.getColumnIndex(COL_2)));






    }
}
