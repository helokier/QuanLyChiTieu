package com.example.quanlychitieu.digalof;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.entry.Thu;
import com.example.quanlychitieu.ui.thu.KhoanThuFragment;
import com.example.quanlychitieu.ui.thu.LoaiThuFragment;
import com.example.quanlychitieu.ui.thu.LoaiThuViewModel;
import com.example.quanlychitieu.ui.thu.LoaiThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class LoaiThuDIalog {
    private LoaiThuViewModel loaiThuViewModel;
    private LayoutInflater inflater;
    private AlertDialog Mdiaglog;
    private TextInputEditText  edid,edid2;
    private boolean editmode;


    public LoaiThuDIalog(final Context context, LoaiThuFragment fragment, LoaiThu ...loaiThu){
        loaiThuViewModel = fragment.getViewModel();
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialogloaithu,null);
       edid = view.findViewById(R.id.edid2);
        edid2 = view.findViewById(R.id.edid22);
        if (loaiThu !=null && loaiThu.length>0){
            edid.setText(""+loaiThu[0].Lid);
            edid2.setText(loaiThu[0].name);
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
                        LoaiThu tl= new LoaiThu();
                        tl.name = edid2.getText().toString();
                        if (editmode){
                            tl.Lid = Integer.parseInt(edid.getText().toString());
                            loaiThuViewModel.update(tl);
                        }else {
                            loaiThuViewModel.insert(tl);
                            Toast.makeText(context,"Loại Thu Được Lưu",Toast.LENGTH_LONG).show();
                        }
                    }
                });
        Mdiaglog = builder.create();
    }

    public LoaiThuDIalog(FragmentActivity activity, KhoanThuFragment fragment1, Thu thu) {
    }


    public void show(){
        Mdiaglog.show();
    }
}
