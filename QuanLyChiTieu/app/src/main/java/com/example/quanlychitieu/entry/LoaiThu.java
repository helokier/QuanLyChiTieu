package com.example.quanlychitieu.entry;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class LoaiThu {
    @PrimaryKey(autoGenerate = true)
    public  int Lid;
    @ColumnInfo( name ="name")
    public String name;
}
