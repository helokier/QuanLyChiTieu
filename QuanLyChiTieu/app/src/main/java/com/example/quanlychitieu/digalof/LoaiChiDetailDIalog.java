package com.example.quanlychitieu.digalof;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.ui.chi.LoaiChiFragment;
import com.example.quanlychitieu.ui.chi.LoaiChiViewModel;

public class LoaiChiDetailDIalog {
    private LoaiChiViewModel loaiChiViewModel;
    private LayoutInflater inflater;
    private AlertDialog Mdiaglog;
    private TextView tvid,tvname;
    private boolean editmode;


    public LoaiChiDetailDIalog(final Context context, LoaiChiFragment fragment2, LoaiChi loaiChi){
        loaiChiViewModel = fragment2.getViewModel();
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_detail_loaichi,null);
        tvid = view.findViewById(R.id.tvid);
        tvname = view.findViewById(R.id.tvname2);
        tvid.setText(""+loaiChi.Lid);
        tvname.setText(loaiChi.name);
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(view)
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Mdiaglog.dismiss();
            }
        });
        Mdiaglog = builder.create();
    }


    public void show(){
        Mdiaglog.show();
    }
}
