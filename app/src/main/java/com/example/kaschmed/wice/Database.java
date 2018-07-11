package com.example.kaschmed.wice.Lokal;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.kaschmed.wice.IntolerancesforRooms;
import com.example.kaschmed.wice.RecipesforRooms;
import com.example.kaschmed.wice.UserforRooms;

import static android.arch.persistence.room.Room.databaseBuilder;
import static com.example.kaschmed.wice.Lokal.Database.DATABASE_VERSION;

/**
 * Created by Manu on 10.07.18.
 */

@android.arch.persistence.room.Database(entities ={UserforRooms.class,RecipesforRooms.class, IntolerancesforRooms.class},version = DATABASE_VERSION )

public abstract class Database extends RoomDatabase {
    public static final int DATABASE_VERSION=2;
    public static final String DATABASE_NAME="WICE-Database-Room";

    public abstract UserInterDAO userInterDAO();
    public abstract RecipeInterDAO recipeInterDAO();
    public abstract IntoleranceInterDAO intoleranceInterDAO();

    private static Database mInstance;

    //datenbank bilden
    public static Database getInstance(Context context){

        if(mInstance == null){
            mInstance = databaseBuilder(context,Database.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }

}
