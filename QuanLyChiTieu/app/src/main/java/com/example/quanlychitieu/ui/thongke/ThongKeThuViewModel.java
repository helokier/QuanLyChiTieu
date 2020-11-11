package com.example.quanlychitieu.ui.thongke;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.quanlychitieu.Reponsy.LoaiThuReposi;
import com.example.quanlychitieu.Reponsy.ThuReposi;
import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.entry.Thu;

import java.util.List;

public class ThongKeThuViewModel extends AndroidViewModel {
    private ThuReposi ThuReposis;
    private LoaiThuReposi loaiThuReposi;
    private LiveData<List<Thu>> loaithus;
    private LiveData<List<LoaiThu>> mlloaithus;
    public ThongKeThuViewModel(@NonNull Application application) {
        super(application);
        ThuReposis =new ThuReposi(application);
        loaithus = ThuReposis.getAllThu();
        loaiThuReposi = new LoaiThuReposi(application);
        mlloaithus = loaiThuReposi.getAllLoaithu();
    }
    public LiveData<List<LoaiThu>> getLoaithu() {
        return mlloaithus;
    }

    public LiveData<List<Thu>> getaLoaithu() {
        return loaithus;
    }
    public void insert(Thu Thu){
        ThuReposis.insert(Thu);
    }
    public void delete(Thu Thu){
        ThuReposis.delete(Thu);
    }
    public void update(Thu Thu){
        ThuReposis.update(Thu);
    }
}