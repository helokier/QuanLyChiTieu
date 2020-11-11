package com.example.quanlychitieu.entry;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Thu {
    @PrimaryKey(autoGenerate = true)
    public  int Tid;
    @ColumnInfo( name ="ltid")
    public int ltid;
    @ColumnInfo( name ="name")
    public String name;
    @ColumnInfo( name ="sotien")
    public float sotien;
    @ColumnInfo( name ="ghichu")
    public String ghichu;
}
