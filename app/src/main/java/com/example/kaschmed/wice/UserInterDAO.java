package com.example.kaschmed.wice.Lokal;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kaschmed.wice.UserforRooms;

import java.util.List;



/**
 * Created by Manu on 10.07.18.
 */

@Dao
public interface UserInterDAO {
    //abfrage
    @Query("SELECT * FROM users WHERE username =:name ")
    List<UserforRooms> getUserByName(String name);

    @Query("SELECT * FROM users WHERE emailadress LIKE:emailadress ")
    UserforRooms checkadress(String emailadress);
    @Query("SELECT * FROM users ")
    List<UserforRooms>getAllUsers();

    //insert
    @Insert
    void insertUser(UserforRooms...users);
    //update
    @Update
    void updateUser(UserforRooms...users);
    //delete
   @Delete
    void deleteUser(UserforRooms...users);

    @Query("DELETE FROM users ")
    void deleteAllUsers();


}
