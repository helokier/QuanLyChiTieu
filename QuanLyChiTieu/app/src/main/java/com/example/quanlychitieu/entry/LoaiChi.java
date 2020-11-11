package com.example.quanlychitieu.entry;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LoaiChi {
    @PrimaryKey(autoGenerate = true)
    public  int Lid;
    @ColumnInfo( name ="name")
    public String name;
}
