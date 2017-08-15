package com.example.karimovsardor.myapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener
{
    private ViewPager pager = null;
        private Adapter adapter = null;
            private TabLayout tab_layout = null;
                    private ArrayList<Fragment> fragmentArrayList = null;
                        private ArrayList<String> stringArrayList = null;

    //// INITIALIZING MY ONE TIME OBJECTS THAT NEED TO BE SET UP ONCE AT THE BEGINNING OF THE
    // APPLICATION Fuckanashit
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {         super.onCreate(savedInstanceState);

             setContentView(R.layout.activity_main);

        ////FILLING UP THE ARRAYLIST WITH FRAGMENTS Fuckanashit
        this.fragmentArrayList = new ArrayList<>();
            this.fragmentArrayList.add(new BlankFragment2());
                this.fragmentArrayList.add(new BlankFragment());
                    this.fragmentArrayList.add(new BlankFragment());
                        this.fragmentArrayList.add(new BlankFragment());
                        this.fragmentArrayList.add(new BlankFragment());
                    this.fragmentArrayList.add(new BlankFragment());
                this.fragmentArrayList.add(new BlankFragment());
            this.fragmentArrayList.add(new BlankFragment2());
        this.fragmentArrayList.add(new BlankFragment());

        ////FILLING UP THE ARRAYLIST WITH TAB TITLES Fuckanashit
        this.stringArrayList = new ArrayList<>();
            this.stringArrayList.add("");
                this.stringArrayList.add("MON");
                    this.stringArrayList.add("TUE");
                        this.stringArrayList.add("WED");
                        this.stringArrayList.add("THUR");
                    this.stringArrayList.add("FRI");
                this.stringArrayList.add("SAT");
            this.stringArrayList.add("SUN");
        this.stringArrayList.add("");


        this.pager = (ViewPager)findViewById(R.id.pager);
            this.adapter = new Adapter(getSupportFragmentManager());
                this.pager.setAdapter(this.adapter);
                    this.tab_layout = (TabLayout)findViewById(R.id.tab);
                        this.tab_layout.setupWithViewPager(this.pager);

        /////DISABLING THE FAKE TABS AND SETTING THEM TO GONE Fuckanashit
        LinearLayout tabs = (LinearLayout)this.tab_layout.getChildAt(0);
      tabs.getChildAt(0).setEnabled(false);
     tabs.getChildAt(0).setVisibility(View.GONE);
    tabs.getChildAt(8).setEnabled(false);
  tabs.getChildAt(8).setVisibility(View.GONE);

        //// SETTTING THE PAGER'S FIRST PAGE
        this.pager.setCurrentItem(1);
        this.tab_layout.setOnTabSelectedListener(this);
    }

    //// TABLAYOUT'S METHOD STARTS HERE! Fuckanashit
    @Override
    public void onTabSelected(TabLayout.Tab tab)
    {
        if(tab.getPosition() == 0)
        {
            pager.setCurrentItem(7,false);
        }
        else if(tab.getPosition() == 8)
        {
            pager.setCurrentItem(1,false);
        }
        else
        {
            pager.setCurrentItem(tab.getPosition(),true);
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab)
    {}

    @Override
    public void onTabReselected(TabLayout.Tab tab)
    {}
    ///TABLAYOUT'S METHOD END HERE! Fuckanashit


    //// JUST A SIMPLE FRAGMENT ADAPTER Fuckanashit
    private class Adapter extends FragmentPagerAdapter
    {
        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {

            return fragmentArrayList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
             super.getPageTitle(position);

             return stringArrayList.get(position);
        }
    }
}