package com.example.quanlychitieu.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlychitieu.ui.thu.KhoanThuFragment;
import com.example.quanlychitieu.ui.thu.LoaiThuFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ThuViewAdapter extends FragmentStateAdapter {
    public ThuViewAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        if (position==0){
            fragment = KhoanThuFragment.newInstance();
        }else {
            fragment = LoaiThuFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
