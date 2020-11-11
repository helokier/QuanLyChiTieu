package com.example.quanlychitieu.ui.thu;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.annotation.SuppressLint;
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
import com.example.quanlychitieu.adapter.ThuRecylerView;
import com.example.quanlychitieu.digalof.ChiDIalog;
import com.example.quanlychitieu.digalof.LoaiThuDIalog;
import com.example.quanlychitieu.digalof.LoaiThuDetailDIalog;
import com.example.quanlychitieu.digalof.ThuDIalog;
import com.example.quanlychitieu.entry.Chi;
import com.example.quanlychitieu.entry.LoaiThu;
import com.example.quanlychitieu.entry.Thu;

import java.util.List;

public class KhoanThuFragment extends Fragment {

    private KhoanThuViewModel mViewModel;
    private RecyclerView Rkv;
    private ThuRecylerView Madapter;
    final KhoanThuFragment fragment1 = this;

    public static KhoanThuFragment newInstance() {
        return new KhoanThuFragment();
    }
    public KhoanThuViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Rkv = view.findViewById(R.id.Reciel1);
        Madapter = new ThuRecylerView(getActivity());
        Rkv.setLayoutManager( new LinearLayoutManager(getActivity()));
        Rkv.setAdapter(Madapter);

        Madapter.setOnItemEditClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
               Thu thu = Madapter.getItem(position);
                ThuDIalog dIalog = new ThuDIalog(getActivity(),fragment1,thu);
                dIalog.show();
            }
        });
        Madapter.setOnItemVewClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Thu thu = Madapter.getItem(position);
                ThuDIalog dIalog = new ThuDIalog(getActivity(),fragment1,thu);
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
                Thu tl = Madapter.getItem(position);
                Toast.makeText(getActivity(),"Khoản Thu Đã Được Xóa",Toast.LENGTH_LONG).show();
                mViewModel.delete(tl);

            }
        });
        helper.attachToRecyclerView(Rkv);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.khoan_thu_fragment, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KhoanThuViewModel.class);
        mViewModel.getaLoaithu().observe(this, new Observer<List<Thu>>() {
            @Override
            public void onChanged(List<Thu> thus) {
                Madapter.setList(thus);
            }
        });

    }

}