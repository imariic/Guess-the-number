package com.example.ivanmariic.guessthenumber.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.ivanmariic.guessthenumber.GuessTheNumber;
import com.example.ivanmariic.guessthenumber.model.PlayerEntity;

@Database(entities = {PlayerEntity.class},version = 3)
public abstract class PlayerDatabase extends RoomDatabase {

    public abstract PlayerDAO getPlayerDAO();

    private static PlayerDatabase playerDatabase = null;

    public static PlayerDatabase getInstance(){
        if(playerDatabase == null){
            return Room.databaseBuilder(GuessTheNumber.getInstance(), PlayerDatabase.class,"my_database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return playerDatabase;
    }
}
