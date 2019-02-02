package com.enghack2018.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.enghack2018.Controllers.SplashScreenController;
import com.enghack2018.R;
import com.enghack2018.View.SplashScreenView;

import javax.inject.Inject;

public class SplashScreenActivity extends AppCompatActivity {

    @Inject
    SplashScreenController splashScreenController;

    private SplashScreenView splashScreenView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainApplication.mainApplicationComponent.inject(this);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        setUpController();
        setUpView();
    }

    private void setUpController() {
        this.splashScreenController.platesLiveData.observe(this, plateDOS -> {
            startActivity(new Intent(this, MainDataActivity.class));
        });
        this.splashScreenController.fetchData(50);
    }

    private void setUpView() {
        this.splashScreenView = new SplashScreenView();
    }


}
