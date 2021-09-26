package com.biancaesquibel.armywhy.view;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.biancaesquibel.armywhy.R;
import com.biancaesquibel.armywhy.view.fragment.HomeFragment ;
import com.biancaesquibel.armywhy.view.fragment.ProfileFragment;
import com.biancaesquibel.armywhy.view.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        //noinspection Convert2Lambda
        bottomNavigationView.setOnNavigationItemSelectedListener (
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;

                        switch (item.getItemId()){
                            case R.id.search:
                                selectedFragment = new SearchFragment();
                                break;
                            case R.id.home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.profile:
                                selectedFragment = new ProfileFragment();
                                break;
                        }

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container_frame, selectedFragment)
                                .commit();

                        return true;
                    }
                }
                );

    }
}