package com.example.quanlychitieu.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.quanlychitieu.entry.Chi;

import java.util.List;

@Dao
public interface ChiDao {
    @Query("SELECT *FROM Chi")
    LiveData<List<Chi>> findalls();

    @Insert
    void insert(Chi chi);

    @Update
    void update(Chi chi);
   @Delete
    void delete(Chi chi);

}
