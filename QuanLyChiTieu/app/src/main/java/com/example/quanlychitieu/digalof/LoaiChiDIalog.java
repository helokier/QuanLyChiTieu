package com.example.quanlychitieu.digalof;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.ui.chi.LoaiChiFragment;
import com.example.quanlychitieu.ui.chi.LoaiChiViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiChiDIalog {
    private LoaiChiViewModel loaiChiViewModel;
    private LayoutInflater inflater;
    private AlertDialog Mdiaglog;
    private TextInputEditText  edid,edid2;
    private boolean editmode;


    public LoaiChiDIalog(final Context context, LoaiChiFragment fragment, LoaiChi ...loaiChi){
        loaiChiViewModel = fragment.getViewModel();
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialogloaichi,null);
        edid = view.findViewById(R.id.abcs);
        edid2 = view.findViewById(R.id.abd);
        if (loaiChi !=null && loaiChi.length>0){
         edid.setText(""+loaiChi[0].Lid);
            edid2.setText(loaiChi[0].name);
           editmode = true;
       }else {
            editmode = false;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context).setView(view)
                .setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Mdiaglog.dismiss();
            }
        }).setPositiveButton("Luu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        LoaiChi tl= new LoaiChi();
                        tl.name = edid2.getText().toString();
                        if (editmode){
                            tl.Lid = Integer.parseInt(edid.getText().toString());
                            loaiChiViewModel.update(tl);
                        }else {
                            loaiChiViewModel.insert(tl);
                            Toast.makeText(context,"Loại Chi Được Lưu",Toast.LENGTH_LONG).show();
                        }
                    }
                });
        Mdiaglog = builder.create();
    }



    public void show(){
        Mdiaglog.show();
    }
}
