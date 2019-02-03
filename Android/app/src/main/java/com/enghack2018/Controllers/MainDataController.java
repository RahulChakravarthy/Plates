package com.enghack2018.Controllers;


import android.arch.lifecycle.MutableLiveData;

import com.enghack2018.Model.dataaccessobject.DatabaseOperationInterface;
import com.enghack2018.Model.dataaccessobject.favouriteplates.FavouritePlatesTable;
import com.enghack2018.Model.dataobject.PlateDO;

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

    private FavouritePlatesTable favouritePlatesTable;

    @Inject
    public MainDataController(FavouritePlatesTable favouritePlatesTable) {
        this.favouritePlatesTable = favouritePlatesTable;
        favouritePlates.setValue(new ArrayList<>());
        fetchFavouritePlatesFromDB();
    }

    private void fetchFavouritePlatesFromDB() {
        this.favouritePlatesTable.fetchAllFavouritePlates(new DatabaseOperationInterface<List<PlateDO>>() {
            @Override
            public void beforeOperation() {
                //Do nothing
            }

            @Override
            @SuppressWarnings("ALL")
            public void afterOperation(List<PlateDO> result) {
                favouritePlates.getValue().addAll(result);
                favouritePlates.postValue(favouritePlates.getValue());
            }
        });
    }

    public void addFavouritePlate(PlateDO plateDO) {
        this.favouritePlatesTable.insertFavouritePlate(plateDO, new DatabaseOperationInterface<Object>() {
            @Override
            public void beforeOperation() {

            }

            @Override
            public void afterOperation(Object result) {

            }
        });
    }

}
