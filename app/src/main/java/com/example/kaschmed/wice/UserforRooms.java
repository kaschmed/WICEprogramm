package com.example.kaschmed.wice;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import java.lang.ref.WeakReference;


/**
 * Created by Manu on 10.07.18.
 */

@Entity(tableName = "users")

public class UserforRooms {

   private Database database;

    @PrimaryKey
    @NonNull
    private String username;


    @NonNull
    @ColumnInfo(name = "Password")
    private String password;

    @NonNull
    @ColumnInfo(name = "Email")
    private String emailadress;


    public UserforRooms(@NonNull String username, @NonNull String password, @NonNull String emailadress) {
        this.username = username;
        this.password = password;
        this.emailadress = emailadress;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailadress() {
        return emailadress;
    }

    public void setEmailadress(String emailadress) {
        this.emailadress = emailadress;
    }

    @Override
    public String toString() {
        return new StringBuilder(username).append("/n").append(password).append("/n").append(emailadress).toString();
    }


}




