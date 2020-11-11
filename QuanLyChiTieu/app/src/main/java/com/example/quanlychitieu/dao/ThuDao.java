package com.example.quanlychitieu.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.entry.Thu;

import java.util.List;

@Dao
public interface ThuDao {
    @Query("SELECT *FROM thu")
    LiveData<List<Thu>> findall();

    @Insert
    void insert(Thu Thu);

    @Update
    void update(Thu Thu);
   @Delete
    void delete(Thu Thu);

}
