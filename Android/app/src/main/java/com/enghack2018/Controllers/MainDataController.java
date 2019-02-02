package com.enghack2018.Controllers;


import android.arch.lifecycle.MutableLiveData;

import com.enghack2018.Model.PlateDO;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Main Data Controller
 */
@Singleton
public class MainDataController {

    public MutableLiveData<List<PlateDO>> favouritePlates = new MutableLiveData<>();

    @Inject
    public MainDataController() {
        favouritePlates.setValue(new ArrayList<>());
    }

}
