package com.example.kaschmed.wice;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


/**
 * Created by Manu on 10.07.18.
 */

@Entity(tableName = "recipes")
public class RecipesforRooms {

    @NonNull
    @PrimaryKey
    private String recipename;


    @NonNull
    @ColumnInfo(name = "Zudaten")
    private String zudaten;

    @NonNull
    @ColumnInfo(name = "Zubereitung")
    private String zubereitung;


    public RecipesforRooms(@NonNull String recipename, @NonNull String zudaten, @NonNull String zubereitung) {
        this.recipename = recipename;
        this.zudaten = zudaten;
        this.zubereitung = zubereitung;
    }

    public String getRecipename() {
        return recipename;
    }

    public void setRecipename(String recipename) {
        this.recipename = recipename;
    }

    public String getZudaten() {
        return zudaten;
    }

    public void setZudaten(String zudaten) {
        this.zudaten = zudaten;
    }

    public String getZubereitung() {
        return zubereitung;
    }

    public void setZubereitung(String zubereitung) {
        this.zubereitung = zubereitung;
    }

    @Override
    public String toString() {
        return new StringBuilder(recipename).append("/n").append(zudaten).append("/n").append(zubereitung).toString();
    }
}
