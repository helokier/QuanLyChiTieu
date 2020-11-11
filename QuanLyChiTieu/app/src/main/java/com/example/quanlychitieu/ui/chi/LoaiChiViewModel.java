package com.example.quanlychitieu.ui.chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quanlychitieu.Reponsy.LoaiChiReposi;
import com.example.quanlychitieu.entry.LoaiChi;

import java.util.List;

public class LoaiChiViewModel extends AndroidViewModel {
    private LoaiChiReposi loaiChiReposis;
    private LiveData<List<LoaiChi>> loaithus;
    public LoaiChiViewModel(@NonNull Application application) {
        super(application);
        loaiChiReposis =new LoaiChiReposi(application);
        loaithus = loaiChiReposis.getAllLoaiChi();
    }

    public LiveData<List<LoaiChi>> getLoaithu() {
        return loaithus;
    }
    public void insert(LoaiChi loaiChi){
        loaiChiReposis.insert(loaiChi);
    }
    public void delete(LoaiChi loaiChi){
        loaiChiReposis.delete(loaiChi);
    }
    public void update(LoaiChi loaiChi){
        loaiChiReposis.update(loaiChi);
    }
}