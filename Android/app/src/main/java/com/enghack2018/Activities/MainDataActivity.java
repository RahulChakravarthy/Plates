package com.enghack2018.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.enghack2018.Activities.CallBacks.MainDataCallBack;
import com.enghack2018.Controllers.MainDataController;
import com.enghack2018.Controllers.SplashScreenController;
import com.enghack2018.Model.dataobject.PlateDO;
import com.enghack2018.R;
import com.enghack2018.View.MainDataView;

import java.util.List;

import javax.inject.Inject;

public class MainDataActivity extends AppCompatActivity implements MainDataCallBack {

    private MainDataView mainDataView;

    @Inject
    SplashScreenController splashScreenController;

    @Inject
    MainDataController mainDataController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data);
        MainApplication.mainApplicationComponent.inject(this);
        setupView();
        setupController();
    }

    private void setupController() {
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @SuppressWarnings("ALL")
    private void setupView() {
        this.mainDataView = new MainDataView(getApplicationContext(), findViewById(R.id.main_data), getSupportFragmentManager());
        this.mainDataView.setupTabs(splashScreenController.platesLiveData.getValue());
    }

    @Override
    public void onBackPressed(){}

    @Override
    public List<PlateDO> getFavouritePlates() {
        return mainDataController.favouritePlates.getValue();
    }

    @Override
    @SuppressWarnings("ALL")
    public void addOneToFavouritePlate(PlateDO plateDO) {
       mainDataController.favouritePlates.getValue().add(plateDO);
       mainDataController.addFavouritePlate(plateDO);
       splashScreenController.removePlateFromDB(plateDO);
       mainDataView.refreshRecyclerView();
    }

    @Override
    public void rejectPlate(PlateDO plateDO) {
        splashScreenController.removePlateFromDB(plateDO);
    }
}
