package com.example.quanlychitieu;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.example.quanlychitieu.digalof.ChiDIalog;
import com.example.quanlychitieu.digalof.LoaiChiDIalog;
import com.example.quanlychitieu.digalof.ThuDIalog;
import com.example.quanlychitieu.ui.chi.KhoanChiFragment;
import com.example.quanlychitieu.ui.chi.LoaiChiFragment;
import com.example.quanlychitieu.ui.thu.KhoanThuFragment;
import com.example.quanlychitieu.ui.thu.LoaiThuFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.quanlychitieu.digalof.LoaiThuDIalog;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        final  MainActivity  currentContext = this;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Fragment> fragments = getSupportFragmentManager().getFragments();
                Fragment fragment = fragments.get(fragments.size() - 1);
                if (fragment instanceof LoaiThuFragment) {
                    LoaiThuDIalog dIalog = new LoaiThuDIalog(currentContext, (LoaiThuFragment) fragment);
                    dIalog.show();
                } else if (fragment instanceof KhoanThuFragment) {
                    ThuDIalog dIalog = new ThuDIalog(currentContext, (KhoanThuFragment) fragment);
                    dIalog.show();
                }else if (fragment instanceof LoaiChiFragment) {
                            LoaiChiDIalog dIalog2 = new LoaiChiDIalog(currentContext, (LoaiChiFragment) fragment);
                            dIalog2.show();
                        } else if (fragment instanceof KhoanChiFragment) {
                            ChiDIalog dIalog2 = new ChiDIalog(currentContext, (KhoanChiFragment) fragment);
                            dIalog2.show();
                        }


                }

        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId()== R.id.nav_thoat){
                    finish();
                }
            }
        });
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}