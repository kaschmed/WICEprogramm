package com.example.kaschmed.wice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**git remote add origin git@github.com:kaschmed/WICE.git
        git push -u origin master**/

public class MainActivity extends AppCompatActivity {



    DBHelper db = new DBHelper(this);
    //IntentLoginService con = new IntentLoginService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void onClickSwitchtoCreateActivity(View view) {
        Intent intent = new Intent(this, createAccount.class);
        startActivity(intent);
    }


    public void onClickSwitchtProfileActivity(View view) {
        Intent intent = new Intent(this, appProfile.class);
        startActivity(intent);



        /*TextView login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText email = findViewById(R.id.editText);
                EditText pass = findViewById(R.id.editText2);
                String em = email.getText().toString();
                String pas = pass.getText().toString();
                String password = db.searchPassword(em);
                if (pas.equals(password)) {
                    Intent i = new Intent(getApplicationContext(), appProfile.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "geht net", Toast.LENGTH_LONG).show();
                }
            }
        });



        startService(intent);
        }*/


        //String password = db.searchPassword(em);

        //Toast.makeText(MainActivity.this, "aaa", Toast.LENGTH_LONG).show();
        /*if (pas.equals(password)) {
            Intent i = new Intent(getApplicationContext(), appProfile.class);
            startActivity(i);
        } else {
            Toast.makeText(MainActivity.this, "geht net", Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(MainActivity.this, "geht net", Toast.LENGTH_LONG).show();*/
    }
}




