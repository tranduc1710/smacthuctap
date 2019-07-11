package com.tranduc.smacthuctap.view.tabLayoutViewPager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tranduc.smacthuctap.R;
import com.tranduc.smacthuctap.view.tabLayoutViewPager.Fragment.Tab1;
import com.tranduc.smacthuctap.view.tabLayoutViewPager.Fragment.Tab2;

public class DayFour extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_four);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    public void setUpViewPager(){
        DayFourAdapter dayFourAdapter = new DayFourAdapter(getSupportFragmentManager());
        dayFourAdapter.addFragment(new Tab1(), "Tab 1");
        dayFourAdapter.addFragment(new Tab2(), "Tab 2");
        viewPager.setAdapter(dayFourAdapter);
    }
}
