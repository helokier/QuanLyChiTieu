package com.example.quanlychitieu.ui.chi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quanlychitieu.Reponsy.LoaiChiReposi;
import com.example.quanlychitieu.Reponsy.ChiReposi;
import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.entry.Chi;

import java.util.List;

public class KhoanChiViewModel extends AndroidViewModel {
    private ChiReposi ChiReposis;
    private LoaiChiReposi loaiChiReposi;
    private LiveData<List<Chi>> loaithus;
    private LiveData<List<LoaiChi>> mlloaithus;
    public KhoanChiViewModel(@NonNull Application application) {
        super(application);
        ChiReposis =new ChiReposi(application);
        loaithus = ChiReposis.getAllChi();
        loaiChiReposi = new LoaiChiReposi(application);
        mlloaithus = loaiChiReposi.getAllLoaiChi();
    }
    public LiveData<List<LoaiChi>> getLoaithu() {
        return mlloaithus;
    }

    public LiveData<List<Chi>> getaLoaithu() {
        return loaithus;
    }
    public void insert(Chi Chi){
        ChiReposis.insert(Chi);
    }
    public void delete(Chi Chi){
        ChiReposis.delete(Chi);
    }
    public void update(Chi Chi){
        ChiReposis.update(Chi);
    }
}