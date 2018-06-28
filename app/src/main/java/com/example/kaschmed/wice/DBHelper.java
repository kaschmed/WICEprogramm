package com.example.kaschmed.wice;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import java.util.List;


/**
 * Created by Manu on 04.05.18.
 */

public class DBHelper extends SQLiteOpenHelper {


    private static final String DB_FILE_NAME ="NewIntolerance.db";//Tabelle

    public static final int DB_VERSION = 1;
    public static final String Table_Intolerance = "intolerance";//Table
    public static final String COLUMN_ID = "into_id";//Spalte
    public static final String COLUMN_NAME = "name";
    public static  final String COLUMN_ENumber = "E-Number";

    private static final String DB_FILE_NAME2 = "NewUser.db";
    public static final int DB_VERSION2 = 1;
    public static final String Table_User = "user";
    public static final String COLUMN_UserID = "user_id";
    public static final String COLUMN_Mail = "mailaddress";
    public static final String COLUMN_Username = "username";
    public static final String COLUMN_Password = "password";
    public static final String COLUMN_IMAGE ="image"; //speichern nut verweise auf Bild u nicht ganzes Bild



    SQLiteDatabase db;

    public static final String SQL_CREATEUser =
            "create table " +Table_User + " (" +
                    COLUMN_UserID + " integer primary key not null , " +
                    COLUMN_Mail + " text not null , " +
                    COLUMN_Username + " text not null , " +
                    COLUMN_Password + " text not null);" ;




    public static final String SQL_CREATE =
            "create table " +Table_Intolerance + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_NAME + " text not null, " +
                    COLUMN_ENumber + " text not null);" ;

//Constructor
    public DBHelper(Context context) {

        super(context, DB_FILE_NAME, null, DB_VERSION );
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        // Intolerance_Table.onCreate(db);
        db.execSQL(SQL_CREATE);
        db.execSQL(SQL_CREATEUser);

        db.execSQL("INSERT into User VALUES (1,'abc','abc','abc')");
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //löschen der aktuellen dabelle
        String dropTAble = " drop table if exists " +Table_Intolerance;
        String dropTAbleUser = " drop table if exists " +Table_User;
        db.execSQL(dropTAbleUser);
        db.execSQL(dropTAble);

        //neue tabelle wird erzeugt
        this.onCreate(db);

    }

    public void insertUSer(User user){
        db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        String query = "select * from User";
        Cursor c = db.rawQuery(query,null); // lassen durchlaufen für primary key zum zählen
        int count = c.getCount();// count wird einem int angehängt
        values.put(COLUMN_UserID,count);//zählt hier den user für die vergabe des primary keys
        values.put(COLUMN_Mail,user.getEmail());
        values.put(COLUMN_Username,user.getUsername());
        values.put(COLUMN_Password,user.getPassword());
        db.insert(Table_User,null,values);
        db.close();


    }

    public String searchPassword(String mail) {
        db = this.getReadableDatabase();
        String query = "select Mailaddress, Password from " + Table_User;
        Cursor cursor = db.rawQuery(query, null);
        String found, notFound;
        notFound = "not Found";
        if (cursor.moveToFirst()) {
            do {
                found = cursor.getString(0);
                if (found.equals(mail)) {
                    notFound = cursor.getString(1);
                    break;
                }
            } while (cursor.moveToNext());
        }
        return notFound;
    }


}
