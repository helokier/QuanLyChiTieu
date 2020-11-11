package com.example.quanlychitieu.Reponsy;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.quanlychitieu.dao.AdapterDatabase;
import com.example.quanlychitieu.dao.ChiDao;
import com.example.quanlychitieu.entry.Chi;

import java.util.List;

public class ChiReposi {
    private ChiDao mChiDao;
    private LiveData<List<Chi>> allChi;

    public ChiReposi(Application application){
        this.mChiDao = AdapterDatabase.getDatabase(application).ChiDao();
        allChi = mChiDao.findalls();
    }
    public LiveData<List<Chi>>getAllChi(){
        return allChi;
    }
    public void insert(Chi Chi){
        new InsertAsyncTask(mChiDao).execute(Chi);
    }
    public void delete( Chi Chi){
        new DeletetAsyncTask(mChiDao).execute(Chi);
    }
    public void update(Chi Chi){
        new UpdateAsyncTask(mChiDao).execute(Chi);
    }



    class InsertAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDao ChiDao;
        public InsertAsyncTask(ChiDao ChiDao) {
            this.ChiDao = ChiDao;
        }

        @Override
        protected Void doInBackground(Chi... Chis) {
            mChiDao.insert(Chis[0]);
            return null;
        }
    }
    class DeletetAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDao ChiDao;
        public DeletetAsyncTask(ChiDao ChiDao) {
            this.ChiDao = ChiDao;
        }

        @Override
        protected Void doInBackground(Chi... Chis) {
            mChiDao.delete(Chis[0]);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<Chi,Void,Void>{
        private ChiDao ChiDao;
        public UpdateAsyncTask(ChiDao ChiDao) {
            this.ChiDao = ChiDao;
        }

        @Override
        protected Void doInBackground(Chi... Chis) {
            mChiDao.update(Chis[0]);
            return null;
        }
    }
}
