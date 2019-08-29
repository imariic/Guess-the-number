package com.example.ivanmariic.guessthenumber;

import android.app.Application;
import android.content.Context;

public class GuessTheNumber extends Application {

    private static GuessTheNumber context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getInstance() {
        return context.getApplicationContext();
    }
}
