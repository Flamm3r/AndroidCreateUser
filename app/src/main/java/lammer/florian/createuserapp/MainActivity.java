package lammer.florian.createuserapp;

import android.content.ContentValues;
import android.content.Intent;
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
    private Button _submit;
    private Button _register;

    MySQLiteOpenHelper helper = new MySQLiteOpenHelper(this);

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
        _submit = findViewById(R.id.buttonSubmit);
        _register = findViewById(R.id.buttonRegister);


        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = _userID.getText().toString();
                String password_input = _userPW.getText().toString();

                String password = helper.searchPass(name);
                if(password_input.equals(password)){
                    //new Intent
                    Toast.makeText(getApplicationContext(), getString(R.string.welcome) + name + "!", Toast.LENGTH_SHORT).show();

                    //new screen with user profile
                    Intent intent = new Intent(MainActivity.this, UserProfile.class);
                    intent.putExtra("name", name);
                    finish();
                    MainActivity.this.startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), R.string.wrongLogin, Toast.LENGTH_SHORT).show();
                }

            }
        });

        _register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                finish();
                startActivity(intent);
            }
        });

    }

}
