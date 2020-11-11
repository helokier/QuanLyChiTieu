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
import com.example.quanlychitieu.adapter.LoaiChiSpinnerAdapter;
import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.entry.Chi;
import com.example.quanlychitieu.entry.Thu;
import com.example.quanlychitieu.ui.chi.KhoanChiFragment;
import com.example.quanlychitieu.ui.chi.KhoanChiViewModel;
import com.example.quanlychitieu.ui.thu.KhoanThuFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class ChiDIalog {
    private KhoanChiViewModel loaiChiViewModel;
    private LayoutInflater inflater;
    private AlertDialog Mdiaglog;
    private TextInputEditText  edid,edid2,editPrice,editNote;
    private Spinner spinner;
    private LoaiChiSpinnerAdapter adapter;
    private boolean editmode;


    public ChiDIalog(final Context context, KhoanChiFragment fragment, Chi...Chi){
        loaiChiViewModel = fragment.getViewModel();
        inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_chi,null);
        edid = view.findViewById(R.id.abc2);
        edid2 = view.findViewById(R.id.abc4);
        editPrice = view.findViewById(R.id.abc5);
        editNote = view.findViewById(R.id.abc6);
        spinner = view.findViewById(R.id.abc3);
        adapter = new LoaiChiSpinnerAdapter(fragment.getActivity());
       loaiChiViewModel.getLoaithu().observe(fragment.getActivity(), new Observer<List<LoaiChi>>() {
           @Override
           public void onChanged(List<LoaiChi> loaiChis) {
               adapter.setList(loaiChis);
           }
       });
        spinner.setAdapter(adapter);
        if (Chi !=null && Chi.length>0){
            edid.setText(""+Chi[0].Tid);
            edid2.setText(Chi[0].name);
            editPrice.setText(""+Chi[0].sotien);
            editNote.setText(Chi[0].ghichu);
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
        }).setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Chi tl= new Chi();
                        tl.name = edid2.getText().toString();
                        tl.sotien = Float.parseFloat(editPrice.getText().toString());
                        tl.ghichu = editNote.getText().toString();
                        tl.Tid = ((LoaiChi) adapter.getItem(spinner.getSelectedItemPosition())).Lid;
                        if (editmode){
                            tl.Tid = Integer.parseInt(edid.getText().toString());
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
