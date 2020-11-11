package com.example.quanlychitieu.digalof;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.adapter.LoaiThuSpinnerAdapter;
import com.example.quanlychitieu.entry.Chi;
import com.example.quanlychitieu.entry.LoaiThu;

import com.example.quanlychitieu.entry.Thu;
import com.example.quanlychitieu.ui.chi.KhoanChiFragment;
import com.example.quanlychitieu.ui.thu.KhoanThuFragment;
import com.example.quanlychitieu.ui.thu.KhoanThuViewModel;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ThuDIalog {
    private KhoanThuViewModel loaiThuViewModel;
    private LayoutInflater inflater;
    private AlertDialog Mdiaglog;
    private TextInputEditText  edid,edid2,editPrice,editNote;
    private Spinner spinner;
    private LoaiThuSpinnerAdapter adapter;
    private boolean editmode;


    public ThuDIalog(final Context context, KhoanThuFragment fragment, Thu...Thu){
        loaiThuViewModel = fragment.getViewModel();
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_thu,null);
        edid = view.findViewById(R.id.edit1);
        edid2 = view.findViewById(R.id.etName);
        editPrice = view.findViewById(R.id.etPrice);
        editNote = view.findViewById(R.id.etNote);
        spinner = view.findViewById(R.id.spType);
        adapter = new LoaiThuSpinnerAdapter(fragment.getActivity());
       loaiThuViewModel.getLoaithu().observe(fragment.getActivity(), new Observer<List<LoaiThu>>() {
           @Override
           public void onChanged(List<LoaiThu> loaiThus) {
               adapter.setList(loaiThus);
           }
       });
        spinner.setAdapter(adapter);
        if (Thu !=null && Thu.length>0){
            edid.setText(""+Thu[0].Tid);
            edid2.setText(Thu[0].name);
            editPrice.setText(""+Thu[0].sotien);
            editNote.setText(Thu[0].ghichu);
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
                        Thu tl= new Thu();
                        tl.name = edid2.getText().toString();
                        tl.sotien = Float.parseFloat(editPrice.getText().toString());
                        tl.ghichu = editNote.getText().toString();
                        tl.Tid = ((LoaiThu) adapter.getItem(spinner.getSelectedItemPosition())).Lid;
                        if (editmode){
                            tl.Tid = Integer.parseInt(edid.getText().toString());
                            loaiThuViewModel.update(tl);
                        }else {
                            loaiThuViewModel.insert(tl);
                            Toast.makeText(context,"Loại Thu Được Lưu",Toast.LENGTH_LONG).show();
                        }
                    }
                });
        Mdiaglog = builder.create();
    }


    public void show(){
        Mdiaglog.show();
    }
}
