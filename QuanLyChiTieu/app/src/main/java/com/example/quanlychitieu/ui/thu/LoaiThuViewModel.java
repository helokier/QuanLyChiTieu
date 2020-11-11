package com.example.quanlychitieu.ui.thu;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.quanlychitieu.Reponsy.LoaiThuReposi;
import com.example.quanlychitieu.entry.LoaiThu;

import java.util.List;

public class LoaiThuViewModel extends AndroidViewModel {
    private LoaiThuReposi loaiThuReposis;
    private LiveData<List<LoaiThu>> loaithus;
    public LoaiThuViewModel(@NonNull Application application) {
        super(application);
        loaiThuReposis =new LoaiThuReposi(application);
        loaithus = loaiThuReposis.getAllLoaithu();
    }

    public LiveData<List<LoaiThu>> getLoaithu() {
        return loaithus;
    }
    public void insert(LoaiThu loaiThu){
        loaiThuReposis.insert(loaiThu);
    }
    public void delete(LoaiThu loaiThu){
        loaiThuReposis.delete(loaiThu);
    }
    public void update(LoaiThu loaiThu){
        loaiThuReposis.update(loaiThu);
    }
}