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
import com.example.quanlychitieu.entry.LoaiChi;

import java.util.List;

public class LoaiChiRecylerView extends RecyclerView.Adapter<LoaiChiRecylerView.LoaiChiViewHoder> {
    private LayoutInflater layoutInflater;
    private List<LoaiChi>list;
   public static  ItemClickListener itemVewClickListener;
    public static  ItemClickListener itemEditClickListener;
    public LoaiChiRecylerView(Context context) {
        layoutInflater = LayoutInflater.from(context);

    }

    public void setOnItemEditClickListener(ItemClickListener itemEditClickListener) {
        LoaiChiRecylerView.itemEditClickListener = itemEditClickListener;
    }

    public void setOnItemVewClickListener(ItemClickListener itemVewClickListener) {
        LoaiChiRecylerView.itemVewClickListener = itemVewClickListener;
    }

    @NonNull
    @Override
    public LoaiChiViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recyclerview_chi_layout,parent,false);
        return new LoaiChiViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoaiChiViewHoder holder, int position) {
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
     public LoaiChi getItem(int position){
        if (list==null || position>=list.size()){
            return null;
        }
        return list.get(position);
     }
    public void setList(List<LoaiChi> list) {
        this.list = list;
        notifyDataSetChanged();
    }


    public static class LoaiChiViewHoder extends RecyclerView.ViewHolder{
       private TextView textView2;
       private ImageView imgview,editView3;
       public CardView cardView;
       public  int position;
        public LoaiChiViewHoder(@NonNull View itemView) {
            super(itemView);
            textView2 = itemView.findViewById(R.id.abcs);
            imgview = itemView.findViewById(R.id.abcg);
            editView3 = itemView.findViewById(R.id.abch);
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
