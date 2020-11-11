package com.example.quanlychitieu.ui.thongke;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.adapter.ThuViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class ThongkeFragment extends Fragment {
    private ViewPager2 mvb;
    private TabLayout mt2;


    public ThongkeFragment() {
        // Required empty public constructor
    }


    public static ThongkeFragment newInstance(String param1, String param2) {
        ThongkeFragment fragment = new ThongkeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mvb = view.findViewById(R.id.abcdf12);
        mt2 = view. findViewById(R.id.tabLayout3);
        ThuViewAdapter adapter =new ThuViewAdapter(getActivity());
        mvb.setAdapter(adapter);


        new TabLayoutMediator(mt2,mvb,new TabLayoutMediator.TabConfigurationStrategy() {


            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position ==0){
                    tab.setText("Thống Kê Chi");
                    tab.setIcon(R.drawable.asd);
                }else{
                    tab.setText("Thống Kê Thu");
                    tab.setIcon(R.drawable.qwe);
                }
            }
        }).attach();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_thongke, container, false);
    }
}