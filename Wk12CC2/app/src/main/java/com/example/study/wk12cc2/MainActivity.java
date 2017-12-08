package com.example.study.wk12cc2;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO 3.1 get a reference to the toolbar and inflate it using setSupportActionBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar); need to delete since andoid already have it(in higher version)
        //TODO 3.2 [go to res/values] put your tab names in the string resource
        //TODO 3.3 get a reference to the tab_layout widget
        //TODO 3.4 call the addTab method to add a tab
        //TODO 3.5 fill the space using setTabGravity method
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //TODO 3.6 get a reference to the viewPager widget
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        //TODO 3.7 create an instance of the PagerAdapter class
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        //TODO 3.8 assign the adapter to the viewPager using setAdapter
        viewPager.setAdapter(adapter);
        //TODO 3.9 synchronise the tabs to the swipes by calling the viewPager.addOnPageChangeListener
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //TODO 3.10 respond to clicks on the tabs by calling tabLayout.addOnPageChangeListener

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}
