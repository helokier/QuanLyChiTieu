package com.example.quanlychitieu.ui.thu;

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


public class ThuFragment extends Fragment {
private ViewPager2 mvp;
private TabLayout mt1;


    public ThuFragment() {
        // Required empty public constructor
    }


    public static ThuFragment newInstance(String param1,String param2) {
        ThuFragment fragment = new ThuFragment();

        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mvp = view.findViewById(R.id.ViewPager22);
        mt1 = view. findViewById(R.id.tabLayout2);
        ThuViewAdapter adapter =new ThuViewAdapter(getActivity());
        mvp.setAdapter(adapter);


        new TabLayoutMediator(mt1,mvp,new TabLayoutMediator.TabConfigurationStrategy() {


            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if (position ==0){
                    tab.setText("Khoản Thu");
                    tab.setIcon(R.drawable.asd);
                }else{
                    tab.setText("Loại Khoản Thu");
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
        return inflater.inflate(R.layout.fragment_thu, container, false);
    }


}