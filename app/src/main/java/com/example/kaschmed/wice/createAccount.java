package com.example.kaschmed.wice;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;

import static com.example.kaschmed.wice.IntentLoginService.EXAMPLE_CATEGORY;
import static com.example.kaschmed.wice.IntentLoginService.EXAMPLE_CATEGORY2;
import static com.example.kaschmed.wice.IntentLoginService.EXAMPLE_NAME;

public class createAccount extends AppCompatActivity {

    NotificationCompat.Builder notification;
    public static final int notiid =1234;



    public NotificationCompat.Builder mBuilder;
    public NotificationManager mNotificationManager;

    DBHelper db = new DBHelper(this);
    //IntentLoginService con = new IntentLoginService();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        registerExampleBroadcastReceiver();
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);
        mBuilder =
                new NotificationCompat.Builder(createAccount.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("PillStar - Database")
                        .setContentText("Data successfully imported!");

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

    }
    public void onClickClose(View view) {
        finish();
    }

    private void registerExampleBroadcastReceiver(){
        // Create a broadcast receiver
        ExampleBroadcastReciever resultReciever = new ExampleBroadcastReciever();

        // Create an intent that indicates which broadcasts to listen for
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IntentLoginService.EXAMPLE_ACTION);

        // Register the receiver
        registerReceiver(resultReciever, intentFilter);
    }

    public void onClickSwitchtProfileActivity(View view) {

        //Build notification
        notification.setSmallIcon(R.drawable.ic_launcher);
        notification.setTicker("Wice");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Task wurde ausgeführt");

        //send user to Activity by clicking it
        Intent intent2 = new Intent(this,createAccount.class);
        // access for the Phone to the intent in the App
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,intent2,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Send notification to device
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(notiid,notification.build());

        Intent intent1 = new Intent(this, IntentLoginService.class);

        EditText email = findViewById(R.id.email);
        EditText pass = findViewById(R.id.pass);
        EditText user = findViewById(R.id.user);

        String em = email.getText().toString();
        String pas = pass.getText().toString();
        String use = user.getText().toString();

        intent1.putExtra(EXAMPLE_CATEGORY, em);
        intent1.putExtra(EXAMPLE_CATEGORY2, pas);
        intent1.putExtra(EXAMPLE_NAME,use);


        startService(intent1);

    }
    private class ExampleBroadcastReciever extends BroadcastReceiver {
        /**
         * This method is called when the BroadcastReceiver is receiving an Intent broadcast
         * @param context The Context in which the receiver is running
         * @param intent The Intent being received
         */
        @Override
        public void onReceive(Context context, Intent intent) {
            mNotificationManager.notify(001, mBuilder.build());
            // If a broadcast that we listen for is received,
            // we filter the extras and display it in the activity
            //String ex_info = intent.getStringExtra(ExampleIntentService.EXAMPLE_CATEGORY);
            //tv.setText(ex_info);
           /* boolean regex = intent.getBooleanExtra(IntentLoginService.REGEX);
            if (regex == false) {

                startActivity(intent1);
            } else {
                Toast.makeText(this, "Fehler", Toast.LENGTH_LONG).show();
            }*/
        }
    }
}



