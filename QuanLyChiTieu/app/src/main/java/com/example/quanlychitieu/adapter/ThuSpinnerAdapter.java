package com.example.quanlychitieu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.entry.Thu;

import java.util.List;

public class ThuSpinnerAdapter extends BaseAdapter {
    private List<Thu> list;
    private LayoutInflater layoutInflater;
    public  ThuSpinnerAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<Thu> list) {
        this.list = list;
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
        KhoanThuViewHoder hoder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.spinner_thu_item,null,false);
            hoder = new KhoanThuViewHoder(view);
            view.setTag(hoder);
        }else {
            hoder = (KhoanThuViewHoder) view.getTag();
        }

        return view;
    }



    public static class  KhoanThuViewHoder{
        public TextView tvname;
        public  KhoanThuViewHoder(View view){
            tvname = view.findViewById(R.id.tvname2);
        }
    }
}
