package com.example.appmusic.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.appmusic.R;
import com.example.appmusic.adapter.MainViewPagerAdapter;
import com.example.appmusic.fragment.FragmentMain;
import com.example.appmusic.fragment.FragmentSearch;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectView();
        initData();
    }

    private void initData() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new FragmentMain(), getString(R.string.homePage));
        mainViewPagerAdapter.addFragment(new FragmentSearch(), getString(R.string.titleSearch));
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.iconsearch);
    }

    private void connectView(){
        tabLayout = findViewById(R.id.my_tab_layout);
        viewPager = findViewById(R.id.my_view_pager);
    }

}
