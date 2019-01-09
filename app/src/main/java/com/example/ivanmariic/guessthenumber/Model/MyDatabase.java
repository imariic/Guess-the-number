package com.example.ivanmariic.guessthenumber.Model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {PlayerEntity.class},version = 2)
public abstract class MyDatabase extends RoomDatabase {

    public abstract PlayerDAO getPlayerDAO();
}
