package com.example.quanlychitieu.ui.chi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.quanlychitieu.R;
import com.example.quanlychitieu.adapter.ChiViewAdapter;
import com.example.quanlychitieu.adapter.ThuViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class ChiFragment extends Fragment {
private ViewPager2 mvp;
private TabLayout mt1;


    public ChiFragment() {
        // Required empty public constructor
    }


    public static ChiFragment newInstance(String param1, String param2) {
        ChiFragment fragment = new ChiFragment();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mvp = view.findViewById(R.id.ViewPager222);
        mt1 = view. findViewById(R.id.tabLayout11);
        ChiViewAdapter adapter =new ChiViewAdapter(getActivity());
        mvp.setAdapter(adapter);


        new TabLayoutMediator(mt1,mvp,new TabLayoutMediator.TabConfigurationStrategy() {


            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position ==0){
                    tab.setText("Khoản Chi");
                    tab.setIcon(R.drawable.asd);
                }else{
                    tab.setText("Loại Khoản Chi");
                    tab.setIcon(R.drawable.qwe);
                }
            }
        }).attach();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chi, container, false);
    }


}