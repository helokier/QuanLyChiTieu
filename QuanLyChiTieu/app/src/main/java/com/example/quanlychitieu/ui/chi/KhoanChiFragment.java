package com.example.quanlychitieu.ui.chi;

import android.annotation.SuppressLint;
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
import com.example.quanlychitieu.adapter.ChiRecylerView;
import com.example.quanlychitieu.adapter.ItemClickListener;
import com.example.quanlychitieu.digalof.ChiDIalog;
import com.example.quanlychitieu.digalof.ChiDIalog;
import com.example.quanlychitieu.entry.Chi;
import com.example.quanlychitieu.entry.Chi;
import com.example.quanlychitieu.entry.Thu;
import com.example.quanlychitieu.ui.chi.KhoanChiViewModel;
import com.example.quanlychitieu.ui.chi.KhoanChiFragment;


import java.util.List;

public class KhoanChiFragment extends Fragment {

    private KhoanChiViewModel mViewModel;
    private RecyclerView Rkv;
    private ChiRecylerView Madapter;
    final KhoanChiFragment fragment = this;

    public static KhoanChiFragment newInstance() {
        return new KhoanChiFragment();
    }
    public KhoanChiViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Rkv = view.findViewById(R.id.abcd);
        Madapter = new ChiRecylerView(getActivity());
        Rkv.setLayoutManager( new LinearLayoutManager(getActivity()));
        Rkv.setAdapter(Madapter);

        Madapter.setOnItemEditClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
               Chi chi = Madapter.getItem(position);
                ChiDIalog dIalog = new ChiDIalog(getActivity(),fragment,chi);
                dIalog.show();
            }
        });
        Madapter.setOnItemVewClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Chi chi =  Madapter.getItem(position);
                ChiDIalog dIalog = new ChiDIalog(getActivity(),fragment,chi);
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
                Chi tl = Madapter.getItem(position);
                Toast.makeText(getActivity(),"Khoản Chi Đã Được Xóa",Toast.LENGTH_LONG).show();
                mViewModel.delete(tl);

            }
        });
        helper.attachToRecyclerView(Rkv);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.khoan_chi_fragment, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KhoanChiViewModel.class);
        mViewModel.getaLoaithu().observe(this, new Observer<List<Chi>>() {
            @Override
            public void onChanged(List<Chi> thus) {
                Madapter.setList(thus);
            }
        });

    }

}