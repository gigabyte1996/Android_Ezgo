package com.example.laptop88.ezgo.view.activity.booking1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.laptop88.ezgo.R;
import com.example.laptop88.ezgo.response.Station;
import com.example.laptop88.ezgo.view.fragment.Train.findTrainByStation.FindTrainByStationFragement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FindTrainsActivity extends AppCompatActivity {
    private TabAdapter tabAdapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FindTrainByStationFragement findTrainByStationFragement;
    private FindTrainByNumber findTrainByNumberFragment;
    private List<Station> stations;
    private ViewPagerAdapter adapter;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_train);
//        initializeFragments();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        addFragmentsToTabLayout();
        Intent intent = getIntent();
        stations = new ArrayList<>();
        stations = (List<Station>) intent.getSerializableExtra("station");
        Log.d("success", stations.get(1).getStationName());
//        transferDataToTab(stations);
        Bundle bundle = new Bundle();
        bundle.putSerializable("station" ,(Serializable) stations);
        FindTrainByStationFragement frg = new FindTrainByStationFragement();
        FindTrainByNumber  frg1 = new FindTrainByNumber();

        frg.setArguments(bundle);
        frg1.setArguments(bundle);
        adapter.addFrag(frg,"BY STATION");
        adapter.addFrag(frg1,"BY NUMBER");
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        handleTabSwitch();

    }

//    private void initializeFragments() {
//        this.findTrainByStationFragement = new FindTrainByStationFragement();
//        this.findTrainByNumberFragment = new FindTrainByNumber();
//    }

    private void addFragmentsToTabLayout() {
//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
//        tabAdapter = new TabAdapter(getSupportFragmentManager());
//        tabAdapter.addFragment(this.findTrainByStationFragement, "BY NUMBER");
//        tabAdapter.addFragment(this.findTrainByNumberFragment, "BY STATION");
//        viewPager.setAdapter(tabAdapter);
//        tabLayout.setupWithViewPager(viewPager);

    }

    private void handleTabSwitch() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getText() == "BY STATION") {
                    setAppBarTitle("Find Train - By StationResponse");
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
    public void transferDataToTab(List<Station> stationList){
        this.findTrainByStationFragement.setPopUpAdapter(stationList);

    }

}
