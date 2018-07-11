package com.example.kaschmed.wice;

import android.arch.persistence.room.ColumnInfo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import org.w3c.dom.Text;


/**
 * Created by Manu on 10.07.18.
 */


@Entity(tableName = "intolerances")
public class IntolerancesforRooms {

    @NonNull
    @PrimaryKey
    private String intolerancesname;


    @NonNull
    @ColumnInfo(name = "Enumber")
    private String enumber;


    public IntolerancesforRooms(@NonNull String intolerancesname, @NonNull String enumber) {
        this.intolerancesname = intolerancesname;
        this.enumber = enumber;
    }

    public String getIntolerancesname() {
        return intolerancesname;
    }

    public void setIntolerancesname(String intolerancesname) {
        this.intolerancesname = intolerancesname;
    }

    public String getEnumber() {
        return enumber;
    }

    public void setEnumber(String enumber) {
        this.enumber = enumber;
    }

    @Override
    public String toString() {
        return new StringBuilder(intolerancesname).append("/n").append(enumber).toString();
    }

}
