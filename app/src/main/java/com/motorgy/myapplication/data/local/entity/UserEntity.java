package com.motorgy.myapplication.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "UserTbl")
public class UserEntity {
    @PrimaryKey(autoGenerate = true)
    public int id = 0;
    @ColumnInfo(name = "idItem")
    public int idItem = 0;
    @ColumnInfo(name = "name")
    public String name = "";
    @ColumnInfo(name = "username")
    public String userName = "";
    @ColumnInfo(name = "email")
    public String email = "";
    @Embedded
    public AddressModelLocalDB address;

}
