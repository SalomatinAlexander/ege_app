package com.example.project2;

import android.app.Application;

import androidx.room.Room;




public class App extends Application {
    public static App instance;
  //  private QuestionDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
       // database = Room.databaseBuilder(this, QuestionDatabase.class,
         //       "database").build();
    }

    public static  App getInstance(){
        return instance;
    }

  /* public  QuestionDatabase getDatabase(){
        return database;
    }

   */
}
