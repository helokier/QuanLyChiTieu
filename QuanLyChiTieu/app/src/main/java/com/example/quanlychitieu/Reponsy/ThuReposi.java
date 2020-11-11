package com.example.quanlychitieu.Reponsy;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quanlychitieu.dao.AdapterDatabase;
import com.example.quanlychitieu.dao.ThuDao;
import com.example.quanlychitieu.entry.Thu;

import java.util.List;

public class ThuReposi {
    private ThuDao mThuDao;
    private LiveData<List<Thu>> allThu;

    public ThuReposi(Application application){
        this.mThuDao = AdapterDatabase.getDatabase(application).ThuDao();
        allThu = mThuDao.findall();
    }
    public LiveData<List<Thu>>getAllThu(){
        return allThu;
    }
    public void insert(Thu Thu){
        new InsertAsyncTask(mThuDao).execute(Thu);
    }
    public void delete( Thu Thu){
        new DeletetAsyncTask(mThuDao).execute(Thu);
    }
    public void update(Thu Thu){
        new UpdateAsyncTask(mThuDao).execute(Thu);
    }



    class InsertAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDao ThuDao;
        public InsertAsyncTask(ThuDao ThuDao) {
            this.ThuDao = ThuDao;
        }

        @Override
        protected Void doInBackground(Thu... Thus) {
            mThuDao.insert(Thus[0]);
            return null;
        }
    }
    class DeletetAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDao ThuDao;
        public DeletetAsyncTask(ThuDao ThuDao) {
            this.ThuDao = ThuDao;
        }

        @Override
        protected Void doInBackground(Thu... Thus) {
            mThuDao.delete(Thus[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<Thu,Void,Void>{
        private ThuDao ThuDao;
        public UpdateAsyncTask(ThuDao ThuDao) {
            this.ThuDao = ThuDao;
        }

        @Override
        protected Void doInBackground(Thu... Thus) {
            mThuDao.update(Thus[0]);
            return null;
        }
    }
}
