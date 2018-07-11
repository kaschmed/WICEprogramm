package com.example.kaschmed.wice.Lokal;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.kaschmed.wice.IntolerancesforRooms;


import java.util.List;

/**
 * Created by Manu on 10.07.18.
 */
@Dao
public interface IntoleranceInterDAO {

    //abfrage
    @Query("SELECT * FROM intolerances WHERE intolerancesname =:name ")
    List<IntolerancesforRooms> getIntoleranceByName(String name);
    //returntype                methodenname        parameter

    @Query("SELECT * FROM intolerances ")
    List<IntolerancesforRooms>getAllIntoTolerances();
    //insert
    @Insert
    void insertIntoTolerances(IntolerancesforRooms...intolerances);
    //update
    @Update
    void updateIntoTolerances(IntolerancesforRooms...intolerances);
    //delete
    @Delete
    void deletefromTolerances(IntolerancesforRooms...intolerances);

    @Query("DELETE FROM intolerances ")
    void deleteAllIntolerances();
}
