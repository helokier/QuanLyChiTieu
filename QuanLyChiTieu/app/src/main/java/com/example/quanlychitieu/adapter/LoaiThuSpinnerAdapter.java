package com.example.quanlychitieu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiThu;

import java.util.List;

public class LoaiThuSpinnerAdapter extends BaseAdapter {
    private List<LoaiThu> list;
    private LayoutInflater layoutInflater;
    public LoaiThuSpinnerAdapter(Context context){
        layoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<LoaiThu> list) {
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
        KhoanThuViewHoder hoder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.spinner_thu_item,null,false);
            hoder = new KhoanThuViewHoder(view);
            view.setTag(hoder);
        }else {
            hoder = (KhoanThuViewHoder) view.getTag();
        }
         hoder.tvname.setText(list.get(i).name);
        return view;
    }



    public static class  KhoanThuViewHoder{
        public TextView tvname;
        public  KhoanThuViewHoder(View view){
            tvname = view.findViewById(R.id.tvname2);
        }
    }
}
