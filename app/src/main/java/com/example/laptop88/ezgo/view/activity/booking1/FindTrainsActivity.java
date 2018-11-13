package com.example.laptop88.ezgo.view.activity.booking1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation.FindTrainByStationFragement;

public class FindTrainsActivity extends AppCompatActivity {
    private TabAdapter tabAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FindTrainByStationFragement findTrainByStationFragement;
    private FindTrainByNumber findTrainByNumberFragment;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_train);
        initializeFragments();
        addFragmentsToTabLayout();
        handleTabSwitch();
    }

    private void initializeFragments() {
        this.findTrainByStationFragement = new FindTrainByStationFragement();
        this.findTrainByNumberFragment = new FindTrainByNumber();
    }

    private void addFragmentsToTabLayout() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(this.findTrainByStationFragement, "BY NUMBER");
        tabAdapter.addFragment(this.findTrainByNumberFragment, "BY STATION");
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void handleTabSwitch() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText() == "BY STATION") {
                    setAppBarTitle("Find Train - By Station");
                } else {
                    setAppBarTitle("Find Train - By Number");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    public void setAppBarTitle(String newTitle) {
        Toolbar appToolBar = (Toolbar)this.findViewById(R.id.toolbar);
        appToolBar.setTitle(newTitle);
    }

    public void synchronizeTabData(String synchronizedTicketNumber) {
//        this.getSupportFragmentManager().findFragmentById(R.).setTicketNumber(synchronizedTicketNumber);
        this.findTrainByNumberFragment.setTicketNumber(synchronizedTicketNumber);
    }

}
