package lammer.florian.createuserapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText _userID;
    private EditText _userPW;
    private EditText _userPWreenterd;
    private Button _submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        _userID = findViewById(R.id.inputUserID);
        _userPW = findViewById(R.id.inputPassword);
        _userPWreenterd = findViewById(R.id.inputPasswordReenter);
        _submit = findViewById(R.id.buttonSubmit);


        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (_userID.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter a user ID!", Toast.LENGTH_SHORT).show();
                }else if (_userPW.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter a Password!", Toast.LENGTH_SHORT).show();
                }else if (_userPWreenterd.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please confirm your Password!", Toast.LENGTH_SHORT).show();
                }else if (_userPW.getText().toString().equals(_userPWreenterd.getText().toString())){
                    MySQLiteOpenHelper dbHelper = new MySQLiteOpenHelper(getApplicationContext());
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("userID", String.valueOf(_userID.getText()));
                    db.insert("login", null, values);
                    values.put("userPW", String.valueOf(_userPW.getText()));
                    db.insert("login", null, values);
                    db.close();
                    dbHelper.close();
                    Toast.makeText(getApplicationContext(), "Thank you, user profile submitted!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Password doesn't match the confirm password!", Toast.LENGTH_SHORT).show();
                }



                /*DEBUG
                Toast.makeText(getApplicationContext(), "button clicked", Toast.LENGTH_SHORT).show();
                Log.d("Button clicked", "Der Submit Button wurde geklickt");
                */
            }
        });

    }

}
