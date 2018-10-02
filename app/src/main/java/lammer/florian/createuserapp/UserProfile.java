package lammer.florian.createuserapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static lammer.florian.createuserapp.MySQLiteOpenHelper.COL_2;
import static lammer.florian.createuserapp.MySQLiteOpenHelper.COL_3;

public class UserProfile extends AppCompatActivity{

    TextView userID;
    Button b_logout;
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        userID = findViewById(R.id.hello);
        b_logout = findViewById(R.id.buttonLogout);

        //Namen von Login (MainActivity) Intent übernehmen und anzeigen
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        //Toast.makeText(UserProfile.this, ""+name,Toast.LENGTH_SHORT).show();
        userID.setText(getString(R.string.hello) + " " + name);

        //Logout
        b_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, MainActivity.class);
                finish();
                UserProfile.this.startActivity(intent);
            }
        });

    }

}
