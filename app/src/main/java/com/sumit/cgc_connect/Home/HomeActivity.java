package com.sumit.cgc_connect.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.sumit.cgc_connect.AddPost.AddFragment;
import com.sumit.cgc_connect.Notification.NotificationFragment;
import com.sumit.cgc_connect.R;
import com.sumit.cgc_connect.Search.SearchFragment;
import com.sumit.cgc_connect.UserProfile.UserProfileFragment;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG,"onCreate: Starting.");


        bottomNavigationView = findViewById(R.id.bottomNavigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.rel_layout2,new HomeFragment()).commit();
        bottomNavigationView.setSelectedItemId(R.id.ic_house);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch(item.getItemId()){
                    case R.id.ic_house:
                        fragment = new HomeFragment();
                        break;

                    case R.id.ic_search:
                        fragment = new SearchFragment();
                        break;

                    case R.id.ic_circle:
                        fragment = new AddFragment();
                        break;

                    case R.id.ic_alert:
                        fragment = new NotificationFragment();
                        break;

                    case R.id.ic_android:
                        fragment = new UserProfileFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.rel_layout2,fragment).commit();

                return true;
            }
        });
        setupViewPager();
    }

    private void setupViewPager(){
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessageFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.connect);
        tabLayout.getTabAt(2).setIcon(R.drawable.message);
    }


}