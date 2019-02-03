package com.enghack2018.View.Fragments.CallBack;


import com.enghack2018.Model.dataobject.PlateDO;

public interface SwipeCallBack {

    void onSwipeIn(PlateDO plateDO);
    void onSwipeOut(PlateDO plateDO);
}
