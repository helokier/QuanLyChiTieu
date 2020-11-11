package com.example.quanlychitieu.Reponsy;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;

import com.example.quanlychitieu.dao.AdapterDatabase;
import com.example.quanlychitieu.dao.LoaiThuDao;
import com.example.quanlychitieu.entry.LoaiThu;

import java.util.List;

public class LoaiThuReposi {
    private LoaiThuDao loaiThuDao;
    private LiveData<List<LoaiThu>> allLoaithu;

    public LoaiThuReposi(Application application){
        this.loaiThuDao = AdapterDatabase.getDatabase(application).loaiThuDao();
        allLoaithu = loaiThuDao.findall();
    }
    public LiveData<List<LoaiThu>>getAllLoaithu(){
        return allLoaithu;
    }
    public void insert(LoaiThu loaiThu){
        new InsertAsyncTask(loaiThuDao).execute(loaiThu);
    }
    public void delete(LoaiThu loaiThu){
        new DeletetAsyncTask(loaiThuDao).execute(loaiThu);
    }
    public void update(LoaiThu loaiThu){
        new UpdateAsyncTask(loaiThuDao).execute(loaiThu);
    }

    class InsertAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDao loaiThuDao;
        public InsertAsyncTask(LoaiThuDao loaiThuDao) {
            this.loaiThuDao = loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            loaiThuDao.insert(loaiThus[0]);
            return null;
        }
    }
    class DeletetAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDao loaiThuDao;
        public DeletetAsyncTask(LoaiThuDao loaiThuDao) {
            this.loaiThuDao = loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            loaiThuDao.delete(loaiThus[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<LoaiThu,Void,Void>{
        private LoaiThuDao loaiThuDao;
        public UpdateAsyncTask(LoaiThuDao loaiThuDao) {
            this.loaiThuDao = loaiThuDao;
        }

        @Override
        protected Void doInBackground(LoaiThu... loaiThus) {
            loaiThuDao.update(loaiThus[0]);
            return null;
        }
    }
}
