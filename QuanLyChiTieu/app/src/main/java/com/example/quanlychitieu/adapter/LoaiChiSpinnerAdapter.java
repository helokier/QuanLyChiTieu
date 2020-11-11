package com.example.quanlychitieu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiChi;

import java.util.List;

public class LoaiChiSpinnerAdapter extends BaseAdapter {
    private List<LoaiChi> list;
    private LayoutInflater layoutInflater;
    public LoaiChiSpinnerAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<LoaiChi> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (list == null)
        return 0;
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        if (list==null)
        return null;
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        KhoanChiViewHoder hoder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.spinner_chi_item,null,false);
            hoder = new KhoanChiViewHoder(view);
            view.setTag(hoder);
        }else {
            hoder = (KhoanChiViewHoder) view.getTag();
        }
         hoder.tvname.setText(list.get(i).name);
        return view;
    }



    public static class  KhoanChiViewHoder{
        public TextView tvname;
        public  KhoanChiViewHoder(View view){
            tvname = view.findViewById(R.id.tvname2);
        }
    }
}
