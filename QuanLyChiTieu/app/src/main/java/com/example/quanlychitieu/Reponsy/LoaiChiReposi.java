package com.example.quanlychitieu.Reponsy;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quanlychitieu.dao.AdapterDatabase;
import com.example.quanlychitieu.dao.LoaiChiDao;
import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.entry.LoaiChi;

import java.util.List;

public class LoaiChiReposi {
    private LoaiChiDao loaiChiDao;
    private LiveData<List<LoaiChi>> allLoaithu;

    public LoaiChiReposi(Application application){
        this.loaiChiDao = AdapterDatabase.getDatabase(application).LoaiChiDao();
        allLoaithu = loaiChiDao.findall();
    }
    public LiveData<List<LoaiChi>>getAllLoaiChi(){
        return allLoaithu;
    }
    public void insert(LoaiChi loaiChi){
        new InsertAsyncTask(loaiChiDao).execute(loaiChi);
    }
    public void delete(LoaiChi loaiChi){
        new DeletetAsyncTask(loaiChiDao).execute(loaiChi);
    }
    public void update(LoaiChi loaiChi){
        new UpdateAsyncTask(loaiChiDao).execute(loaiChi);
    }



    class InsertAsyncTask extends AsyncTask<LoaiChi,Void,Void>{
        private LoaiChiDao loaiChiDao;
        public InsertAsyncTask(LoaiChiDao loaiChiDao) {
            this.loaiChiDao = loaiChiDao;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiChis) {
            loaiChiDao.insert(loaiChis[0]);
            return null;
        }
    }
    class DeletetAsyncTask extends AsyncTask<LoaiChi,Void,Void>{
        private LoaiChiDao loaiChiDao;
        public DeletetAsyncTask(LoaiChiDao loaiChiDao) {
            this.loaiChiDao = loaiChiDao;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiChis) {
            loaiChiDao.delete(loaiChis[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<LoaiChi,Void,Void>{
        private LoaiChiDao loaiChiDao;
        public UpdateAsyncTask(LoaiChiDao loaiChiDao) {
            this.loaiChiDao = loaiChiDao;
        }

        @Override
        protected Void doInBackground(LoaiChi... loaiChis) {
            loaiChiDao.update(loaiChis[0]);
            return null;
        }
    }
}
