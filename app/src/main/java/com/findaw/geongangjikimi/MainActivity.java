package com.findaw.geongangjikimi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private CheckPillFragment checkPillFragment;
    private AddPillFragment addPillFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                setFragment(menuItem.getItemId());
                return true;
            }
        });

        checkPillFragment = new CheckPillFragment();
        addPillFragment = new AddPillFragment();
        setFragment(R.id.page_check_pill);
        bottomNavigationView.setSelectedItemId(R.id.page_check_pill);


    }

    private void setFragment(int pageId){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        switch(pageId){
            case R.id.page_add_pill:
                Log.d("setFragment", "page_add_pill");
                ft.replace(R.id.main_frame, addPillFragment);
                ft.commit();
                break;
            case R.id.page_check_pill:
                Log.d("setFragment", "page_check_pill");
                ft.replace(R.id.main_frame, checkPillFragment);
                ft.commit();
                break;
        }

    }
}