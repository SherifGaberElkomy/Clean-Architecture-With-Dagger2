package com.motorgy.myapplication.di.module;

import android.content.Context;

import androidx.room.Room;

import com.motorgy.myapplication.ApplicationApp;
import com.motorgy.myapplication.data.local.AppDatabase;
import com.motorgy.myapplication.data.local.dao.UserDao;
import com.motorgy.myapplication.di.qualifiers.DatabaseInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {



    private final Context mContext = ApplicationApp.sContext;

    @DatabaseInfo
    private final String mDBName = "test_database.db";


    @Singleton
    @Provides
    AppDatabase provideDatabase () {
        return Room.databaseBuilder(
                mContext,
                AppDatabase.class,
                mDBName
        ).fallbackToDestructiveMigration().build();
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() { return mDBName; }

    @Singleton
    @Provides
    UserDao providePersonDao(AppDatabase db) { return db.userDao(); }


}

