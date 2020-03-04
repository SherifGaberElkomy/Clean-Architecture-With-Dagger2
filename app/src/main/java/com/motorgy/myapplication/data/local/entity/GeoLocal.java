package com.motorgy.myapplication.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "geoLoc_table")
public class GeoLocal {
    @PrimaryKey(autoGenerate = true)
    public int idGeo = 0;
    @ColumnInfo(name = "lat")
    public Double lat = 0.0;
    @ColumnInfo(name = "lng")
    public Double lng = 0.0;
}
