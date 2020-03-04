package com.motorgy.myapplication.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.motorgy.myapplication.data.local.dao.UserDao;
import com.motorgy.myapplication.data.local.entity.AddressModelLocalDB;
import com.motorgy.myapplication.data.local.entity.GeoLocal;
import com.motorgy.myapplication.data.local.entity.UserEntity;

@Database(entities = {UserEntity.class, AddressModelLocalDB.class, GeoLocal.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
