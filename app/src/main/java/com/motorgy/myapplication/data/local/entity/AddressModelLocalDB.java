package com.motorgy.myapplication.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "addressLoc_table")
public class AddressModelLocalDB {
    @PrimaryKey(autoGenerate = true)
    public int idAdress = 0;
    @ColumnInfo(name = "street")
    public String street = "";
    @ColumnInfo(name = "suite")
    public String suite = "";
    @ColumnInfo(name = "city")
    public String city = "";
    @ColumnInfo(name = "zipcode")
    public String zipcode = "";
    @Embedded
    public GeoLocal geo;

}
