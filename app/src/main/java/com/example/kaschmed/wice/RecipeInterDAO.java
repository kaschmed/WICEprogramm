package com.example.kaschmed.wice.Lokal;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kaschmed.wice.RecipesforRooms;
import com.example.kaschmed.wice.UserforRooms;

import java.util.List;



/**
 * Created by Manu on 10.07.18.
 */
@Dao
public interface RecipeInterDAO {
    @Query("SELECT * FROM recipes WHERE recipename =:name ")
    List<RecipesforRooms> getUserByName(String name);

    @Query("SELECT * FROM recipes ")
    List<RecipesforRooms> getAllRecipes();
    //insert
    @Insert
    void insertRecipe(RecipesforRooms...recipes);
    //update
    @Update
    void updateRecipe(RecipesforRooms...recipes);
    //delete
   @Delete
    void deleteRecipes(RecipesforRooms...recipes);

    @Query("DELETE FROM recipes ")
     void deleteAllRecipes();
}
