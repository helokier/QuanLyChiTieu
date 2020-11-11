package com.example.quanlychitieu.ui.thu;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.adapter.ItemClickListener;
import com.example.quanlychitieu.adapter.LoaiThuRecylerView;
import com.example.quanlychitieu.digalof.LoaiThuDIalog;
import com.example.quanlychitieu.digalof.LoaiThuDetailDIalog;
import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.ui.chi.LoaiChiViewModel;

import java.util.List;

public class LoaiThuFragment extends Fragment {
 private RecyclerView rce;
 private LoaiThuRecylerView res;
 private LoaiThuViewModel mViewModel;

    public static LoaiThuFragment newInstance() {
        return new LoaiThuFragment();
    }

    public LoaiThuViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loai_thu_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rce = view.findViewById(R.id.recylerView);
        res = new LoaiThuRecylerView(getActivity()); // adapter
       rce.setLayoutManager(new LinearLayoutManager(getActivity()));
       rce.setAdapter(res);
        final LoaiThuFragment fragment1 = this;
       res.setOnItemEditClickListener(new ItemClickListener() {
           @Override
           public void onItemClick(int position) {
               LoaiThu loaiThu = res.getItem(position);
               LoaiThuDIalog dIalog = new LoaiThuDIalog(getActivity(),fragment1,loaiThu);
               dIalog.show();
           }
       });
       res.setOnItemVewClickListener(new ItemClickListener() {
           @Override
           public void onItemClick(int position) {
               LoaiThu loaiThu = res.getItem(position);
               LoaiThuDetailDIalog dIalog = new LoaiThuDetailDIalog(getActivity(),fragment1,loaiThu);
               dIalog.show();
           }
       });
        super.onViewCreated(view, savedInstanceState);
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT| ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                 int position = viewHolder.getAdapterPosition();
                 LoaiThu tl = res.getItem(position);
                Toast.makeText(getActivity(),"Loại Thu Đã Được Xóa",Toast.LENGTH_LONG).show();
                mViewModel.delete(tl);

            }
        });
       helper.attachToRecyclerView(rce);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoaiThuViewModel.class);
        mViewModel.getLoaithu().observe(getActivity(), new Observer<List<LoaiThu>>() {
            @Override
            public void onChanged(List<LoaiThu> loaiThus) {
                res.setList(loaiThus);
            }
        });

    }

}