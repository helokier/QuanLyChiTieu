package com.example.quanlychitieu.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.entry.LoaiThu;

import java.util.List;

@Dao
public interface LoaiChiDao {
    @Query("SELECT *FROM loaichi")
    LiveData<List<LoaiChi>> findall();

    @Insert
    void insert(LoaiChi loaichi);

    @Update
    void update(LoaiChi loaichi);
   @Delete
    void delete(LoaiChi loaichi);

}
