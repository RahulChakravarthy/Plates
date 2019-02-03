package com.enghack2018.Activities.CallBacks;


import com.enghack2018.Model.dataobject.PlateDO;

import java.util.List;

public interface MainDataCallBack {

    List<PlateDO> getFavouritePlates();
    void addOneToFavouritePlate(PlateDO plateDO);
    void rejectPlate(PlateDO plateDO);

}
