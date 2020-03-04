package com.motorgy.myapplication.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import com.motorgy.myapplication.data.local.entity.UserEntity;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM  UserTbl")
    List<UserEntity> findAll();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(UserEntity usrEntity);
}
