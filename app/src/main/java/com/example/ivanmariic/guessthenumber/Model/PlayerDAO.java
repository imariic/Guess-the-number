package com.example.ivanmariic.guessthenumber.Model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PlayerDAO {

    @Insert
    void insertPlayer(PlayerEntity player);

    @Delete
    void deletePlayer(PlayerEntity player);

    @Query("SELECT user_name FROM PlayerEntity WHERE user_name = :username")
    String getUsername(String username);

    @Query("SELECT password FROM PlayerEntity WHERE password = :password")
    String getPassword(String password);


}
