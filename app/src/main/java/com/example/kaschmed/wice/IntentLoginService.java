package com.example.kaschmed.wice;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Manu on 11.05.18.
 */

public class IntentLoginService extends Service {
    final static String EXAMPLE_ACTION = "example_action"; // Example action for client communication
    final static String EXAMPLE_CATEGORY = "example_cat";
    final static String EXAMPLE_CATEGORY2 = "example_cat"; // Example category to filter extra infor form client
    final static String EXAMPLE_NAME = "Example IntentLoginService";     // Name of the service







    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String email = intent.getStringExtra(EXAMPLE_CATEGORY);
        String pass = intent.getStringExtra(EXAMPLE_CATEGORY2);
        String user = intent.getStringExtra(EXAMPLE_NAME);

        //Here we define how the password should be composed
        //boolean valid = true;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCase = "(.*[a-z].*)";
        String sonderZeichen = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        String leerZeichen = "(.*\\s.*)";
        String zahlen = "(.*[0-9].*)";
        // here we are going to validate the E-mail, comparing it to strings
        if (email.matches(".[@]{2,}.")) {
            Toast.makeText(IntentLoginService.this, "Zu viele @",
                    Toast.LENGTH_LONG).show();
            System.out.println("FEHLER");
            stopSelf();
        } else if (email.matches(".[\\.]{2,}.")) {
            Toast.makeText(IntentLoginService.this, "Zu viele Punkte hintereinander",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches(".@\\..")) {
            // Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die Domain nicht mit einem Punkt starten darf
            Toast.makeText(IntentLoginService.this, "Die Domain darf nicht mit einem Punkt starten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
//
        } else if (email.matches(".\\.@.")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die e_mail nicht mit einem Punkt enden darf
            Toast.makeText(IntentLoginService.this, "Die E-mail darf nicht mit einen Punkt enden",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches("^[.].*")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die e_mail nicht mit einem Punkt starten darf
            Toast.makeText(IntentLoginService.this, "Die E-mail darf nicht mit einem Punkt Starten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches("^[.].\\.@.")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die e_mail nicht mit einem Punkt starten und enden darf
            Toast.makeText(IntentLoginService.this, "Die E-mail darf nicht mit einem Punkt starten und enden",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches(".*\\.[a-zA-Z]+[0-9]$")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die domain nur aus Buchstaben bestehen darf
            Toast.makeText(IntentLoginService.this, "Die Domain darf nur Buchstaben beinhalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } /*else if (!email.matches("[_a-zA-Z0-9-\\.]\\.@\\.")) {

            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die email keine Sonderzeichen beinhalten darf
            Toast.makeText(IntentLoginService.this, "Die E-mail, darf keine Sonderzeichen enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } */ else if (email.isEmpty()) {
            Toast.makeText(IntentLoginService.this, "Bitte geben Sie eie E-Mail ein",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (pass.length() < 8) {
            Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort ist zu kurz!Bitte mindestens 8 Zeichen!",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (!pass.matches(upperCaseChars)) {
            Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindesten einen Großbuchtstaben enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (!pass.matches(lowerCase)) {
            Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindestens einen Kleinbuchstaaben enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (!pass.matches(sonderZeichen)) {
            Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindestens ein Sonderzeichen enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (pass.matches(leerZeichen)) {
            Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort darf keine Leerzeichen enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (!pass.matches(zahlen)) {
            Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindestens eine Zahl enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (user.isEmpty()) {
            Toast.makeText(IntentLoginService.this, "Bitte geben Sie eie E-Mail ein",
                    Toast.LENGTH_LONG).show();
            stopSelf();

        } else if (user.matches(leerZeichen)) {
            Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort darf keine Leerzeichen enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else {
            Toast.makeText(IntentLoginService.this, "Ihre Eingaben sind gültig",
                    Toast.LENGTH_LONG).show();
            broadcastExampleInfo();

        }
        return super.onStartCommand(intent, flags, startId);


    }



    /*protected void onHandleIntent(Intent intent) {

        String email = intent.getStringExtra(EXAMPLE_CATEGORY);
        String pass = intent.getStringExtra(EXAMPLE_CATEGORY2);
        String user = intent.getStringExtra(EXAMPLE_NAME);

        //Here we define how the password should be composed
        //boolean valid = true;
        String upperCaseChars = "(.*[A-Z].*)";
        String lowerCase = "(.*[a-z].*)";
        String sonderZeichen = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        String leerZeichen = "(.*\\s.*)";
        String zahlen = "(.*[0-9].*)";
        // here we are going to validate the E-mail, comparing it to strings
        if (email.matches(".[@]{2,}.")) {
            Toast.makeText(IntentLoginService.this, "Zu viele @",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches(".[\\.]{2,}.")) {
            Toast.makeText(IntentLoginService.this, "Zu viele Punkte hintereinander",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches(".@\\..")) {
            // Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die Domain nicht mit einem Punkt starten darf
            Toast.makeText(IntentLoginService.this, "Die Domain darf nicht mit einem Punkt starten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
//
        } else if (email.matches(".\\.@.")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die e_mail nicht mit einem Punkt enden darf
            Toast.makeText(IntentLoginService.this, "Die E-mail darf nicht mit einen Punkt enden",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches("^[.].*")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die e_mail nicht mit einem Punkt starten darf
            Toast.makeText(IntentLoginService.this, "Die E-mail darf nicht mit einem Punkt Starten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches("^[.].\\.@.")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die e_mail nicht mit einem Punkt starten und enden darf
            Toast.makeText(IntentLoginService.this, "Die E-mail darf nicht mit einem Punkt starten und enden",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.matches(".*\\.[a-zA-Z]+[0-9]$")) {
            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die domain nur aus Buchstaben bestehen darf
            Toast.makeText(IntentLoginService.this, "Die Domain darf nur Buchstaben beinhalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (!email.matches("[_a-zA-Z0-9-\\.].@.")) {

            //Hier erzeugen wir einen Toast der dem Benutzer sagen soll, dass die email keine Sonderzeichen beinhalten darf
            Toast.makeText(IntentLoginService.this, "Die E-mail, darf keine Sonderzeichen enthalten",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else if (email.isEmpty()) {
            Toast.makeText(IntentLoginService.this, "Bitte geben Sie eie E-Mail ein",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        } else

            if (pass.length() < 8) {
                Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort ist zu kurz!Bitte mindestens 8 Zeichen!",
                        Toast.LENGTH_LONG).show();
                stopSelf();
            } else if (!pass.matches(upperCaseChars)) {
                Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindesten einen Großbuchtstaben enthalten",
                        Toast.LENGTH_LONG).show();
                stopSelf();
            } else if (!pass.matches(lowerCase)) {
                Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindestens einen Kleinbuchstaaben enthalten",
                        Toast.LENGTH_LONG).show();
                stopSelf();
            } else if (!pass.matches(sonderZeichen)) {
                Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindestens ein Sonderzeichen enthalten",
                        Toast.LENGTH_LONG).show();
                stopSelf();
            } else if (pass.matches(leerZeichen)) {
                Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort darf keine Leerzeichen enthalten",
                        Toast.LENGTH_LONG).show();
                stopSelf();
            } else if (pass.matches(zahlen)) {
                Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort muss mindestens eine Zahl enthalten",
                        Toast.LENGTH_LONG).show();
                stopSelf();
            } else
                if (user.isEmpty()) {
                    Toast.makeText(IntentLoginService.this, "Bitte geben Sie eie E-Mail ein",
                            Toast.LENGTH_LONG).show();
                    stopSelf();

                } else if (user.matches(leerZeichen)) {
                    Toast.makeText(IntentLoginService.this, "Ihr eigegebenes Passwort darf keine Leerzeichen enthalten",
                            Toast.LENGTH_LONG).show();
                    stopSelf();
                } else {
                    Toast.makeText(IntentLoginService.this, "Ihre Eingaben sind gültig",
                            Toast.LENGTH_LONG).show();
                    stopSelf();
                }

         /*if(REGEX == true) {
            broadcastExampleInfo();
        }
        broadcastExampleInfo();

    }*/

    /*private void broadcastExampleInfo(String msg, boolean b){
        Intent intent = new Intent();
        intent.setAction(EXAMPLE_ACTION);
        intent.putExtra(EXAMPLE_CATEGORY, msg);
        intent.putExtra(REGEX, b);
        sendBroadcast(intent);*/
        private void broadcastExampleInfo(){
        Intent intent = new Intent(this, appProfile.class);
        intent.setAction(EXAMPLE_ACTION);
        sendBroadcast(intent);
            startActivity(intent);
            System.out.println("HELLO");
    }
}

