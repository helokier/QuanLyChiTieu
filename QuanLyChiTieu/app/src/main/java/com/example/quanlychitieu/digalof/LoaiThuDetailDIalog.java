package com.example.quanlychitieu.digalof;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.ui.thu.LoaiThuFragment;
import com.example.quanlychitieu.ui.thu.LoaiThuViewModel;

public class LoaiThuDetailDIalog {
    private LoaiThuViewModel loaiThuViewModel;
    private LayoutInflater inflater;
    private AlertDialog Mdiaglog;
    private TextView tvid,tvname;
    private boolean editmode;


    public LoaiThuDetailDIalog(final Context context, LoaiThuFragment fragment, LoaiThu loaiThu){
        loaiThuViewModel = fragment.getViewModel();
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_detail_loaithu,null);
        tvid = view.findViewById(R.id.tvid);
        tvname = view.findViewById(R.id.tvname2);
        tvid.setText(""+loaiThu.Lid);
        tvname.setText(loaiThu.name);
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
