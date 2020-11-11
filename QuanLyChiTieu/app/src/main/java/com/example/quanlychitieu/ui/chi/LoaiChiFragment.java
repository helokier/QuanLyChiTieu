package com.example.quanlychitieu.ui.chi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.adapter.ItemClickListener;
import com.example.quanlychitieu.adapter.LoaiChiRecylerView;
import com.example.quanlychitieu.digalof.LoaiChiDIalog;
import com.example.quanlychitieu.digalof.LoaiChiDetailDIalog;
import com.example.quanlychitieu.entry.LoaiChi;
import com.example.quanlychitieu.ui.chi.LoaiChiViewModel;

import java.util.List;

public class LoaiChiFragment extends Fragment {
 private RecyclerView rce;
 private LoaiChiRecylerView res;
 private LoaiChiViewModel mViewModel;

    public static LoaiChiFragment newInstance() {
        return new LoaiChiFragment();
    }

    public LoaiChiViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.loai_chi_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        rce = view.findViewById(R.id.anbc);
        res = new LoaiChiRecylerView(getActivity()); // adapter
       rce.setLayoutManager(new LinearLayoutManager(getActivity()));
       rce.setAdapter(res);
        final LoaiChiFragment fragment1 = this;
       res.setOnItemEditClickListener(new ItemClickListener() {
           @Override
           public void onItemClick(int position) {
               LoaiChi loaiChi = res.getItem(position);
               LoaiChiDIalog dIalog = new LoaiChiDIalog(getActivity(),fragment1,loaiChi);
               dIalog.show();
           }
       });
       res.setOnItemVewClickListener(new ItemClickListener() {
           @Override
           public void onItemClick(int position) {
               LoaiChi loaiChi = res.getItem(position);
               LoaiChiDetailDIalog dIalog = new LoaiChiDetailDIalog(getActivity(),fragment1,loaiChi);
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
                 LoaiChi tl = res.getItem(position);
                Toast.makeText(getActivity(),"Loại Chi Đã Được Xóa",Toast.LENGTH_LONG).show();
                mViewModel.delete(tl);

            }
        });
       helper.attachToRecyclerView(rce);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoaiChiViewModel.class);
        mViewModel.getLoaithu().observe(getActivity(), new Observer<List<LoaiChi>>() {
            @Override
            public void onChanged(List<LoaiChi> loaiChis) {
                res.setList(loaiChis);
            }
        });

    }

}