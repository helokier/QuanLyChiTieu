package com.example.quanlychitieu.dao;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.entry.Thu;
import com.example.quanlychitieu.entry.Chi;

@Database(entities = {LoaiThu.class, Thu.class, LoaiChi.class,Chi.class},version = 6)
public abstract class AdapterDatabase extends RoomDatabase {
    public abstract LoaiThuDao loaiThuDao();
    public abstract ThuDao ThuDao();
    public abstract ChiDao ChiDao();
    public abstract LoaiChiDao LoaiChiDao();


    public static AdapterDatabase INSTANCE;
    private static RoomDatabase.Callback callback =new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
            new PopulateData(INSTANCE).execute();
        }
    };

    public static AdapterDatabase getDatabase(final Context context) {
     if (INSTANCE==null){
         synchronized (AdapterDatabase.class){
             INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AdapterDatabase.class,"persanal_db").fallbackToDestructiveMigration()
                     .addCallback(callback).build();
         }
     }
        return INSTANCE;
    }




    public static class PopulateData extends AsyncTask<Void,Void,Void>{
            private LoaiThuDao loaiThuDao;
            private ThuDao thuDao;


        public PopulateData(AdapterDatabase db) {
           loaiThuDao = db.loaiThuDao();
           thuDao = db.ThuDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            String[] loaithus =new String[]{"Lương","Thưởng","Cổ Phiếu"};
            for (String it : loaithus){
                LoaiThu IT = new LoaiThu();
                IT.name =it;
                loaiThuDao.insert(IT);
            }
            Thu thu = new Thu();
            thu.name = "Lương Tháng 1 :";
            thu.sotien = 3000;
            thu.Tid = 2;
            thu.ghichu = "";
            thuDao.insert(thu);
            Log.d("BudgetPro","inser Data");
            return null;
        }
    }


    }

