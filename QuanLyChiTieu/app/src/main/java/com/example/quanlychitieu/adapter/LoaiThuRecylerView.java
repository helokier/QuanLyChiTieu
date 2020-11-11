package com.example.quanlychitieu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.entry.LoaiThu;

import java.util.List;

public class LoaiThuRecylerView extends RecyclerView.Adapter<LoaiThuRecylerView.LoaiThuViewHoder> {
    private LayoutInflater layoutInflater;
    private List<LoaiThu>list;
   public static  ItemClickListener itemVewClickListener;
    public static  ItemClickListener itemEditClickListener;
    public LoaiThuRecylerView(Context context) {
        layoutInflater = LayoutInflater.from(context);

    }

    public void setOnItemEditClickListener(ItemClickListener itemEditClickListener) {
        LoaiThuRecylerView.itemEditClickListener = itemEditClickListener;
    }

    public void setOnItemVewClickListener(ItemClickListener itemVewClickListener) {
        LoaiThuRecylerView.itemVewClickListener = itemVewClickListener;
    }

    @NonNull
    @Override
    public LoaiThuViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_layout,parent,false);
        return new LoaiThuViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiThuViewHoder holder, int position) {
       if (list !=null){
          holder.textView2.setText(list.get(position).name);
          holder.position = position;
       }
    }

    @Override
    public int getItemCount() {
        if (list==null)
        return 0;
        return list.size();
    }
     public LoaiThu getItem(int position){
        if (list==null || position>=list.size()){
            return null;
        }
        return list.get(position);
     }
    public void setList(List<LoaiThu> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public static class LoaiThuViewHoder extends RecyclerView.ViewHolder{
       private TextView textView2;
       private ImageView imgview,editView3;
       public CardView cardView;
       public  int position;
        public LoaiThuViewHoder(@NonNull View itemView) {
            super(itemView);
            textView2 = itemView.findViewById(R.id.textView2s);
            imgview = itemView.findViewById(R.id.imgview);
            editView3 = itemView.findViewById(R.id.editView3);
            cardView = (CardView) itemView;

            imgview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemVewClickListener != null){
                        itemVewClickListener.onItemClick(position);
                    }
                }
            });
            editView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemEditClickListener !=null){
                        itemEditClickListener.onItemClick(position);
                    }
                }
            });

        }
    }
}
