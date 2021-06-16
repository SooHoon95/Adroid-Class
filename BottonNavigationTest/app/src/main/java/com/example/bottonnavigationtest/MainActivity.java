package com.example.bottonnavigationtest;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottonnavigationtest.ui.Address.AddressFragment;
import com.example.bottonnavigationtest.ui.dashboard.DashboardFragment;
import com.example.bottonnavigationtest.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.bottonnavigationtest.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    BottomNavigationView bottomNavigationView;

    AddressFragment addressFragment = new AddressFragment();
    DashboardFragment dashboardFragment = new DashboardFragment();
    NotificationsFragment notificationsFragment = new NotificationsFragment();


    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("연락처");

        bottomNavigationView = findViewById(R.id.nav_view);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,addressFragment).commitAllowingStateLoss();
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                fragmentTransaction = fragmentManager.beginTransaction();
//                Intent intent = null;
//                String tempIP = "192.168.0.3";
                switch (item.getItemId()){
                    case R.id.navigation_Address:
//                        intent = new Intent(MainActivity.this, AddressFragment.class);
//                        intent.putExtra("myIPAdd", tempIP);
//                        startActivity(intent);
                        fragmentTransaction.replace(R.id.frameLayout,addressFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_dashboard:
                        fragmentTransaction.replace(R.id.frameLayout,dashboardFragment).commitAllowingStateLoss();
                        break;
                    case R.id.navigation_Phone:
                        fragmentTransaction.replace(R.id.frameLayout,notificationsFragment).commitAllowingStateLoss();


                }
                return false;
            }
        });

//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_Address, R.id.navigation_dashboard, R.id.navigation_Phone)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}