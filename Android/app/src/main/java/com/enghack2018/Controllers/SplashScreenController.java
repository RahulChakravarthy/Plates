package com.enghack2018.Controllers;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.enghack2018.Model.PlateDO;
import com.enghack2018.Model.ResponseModelDO;
import com.enghack2018.R;
import com.enghack2018.REST.Request.Plate.PlatesRequestAsync;
import com.enghack2018.REST.Response.AsyncCallBackResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Splash Screen Controller
 */
@Singleton
public class SplashScreenController extends ViewModel {

    private PlatesRequestAsync platesRequestAsync;
    private Context context;

    public MutableLiveData<List<PlateDO>> platesLiveData = new MutableLiveData<>();

    @Inject
    public SplashScreenController(Context context, PlatesRequestAsync platesRequestAsync){
        this.context = context;
        this.platesRequestAsync = platesRequestAsync;
    }

    public void fetchData(int amount){
        platesRequestAsync.getPlates(amount, "40.749319", "-73.986089",  new AsyncCallBackResponse() {
            @Override
            public void onSuccess(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                ResponseModelDO responseModelDO = new ResponseModelDO(response);

                //Populate list with response, start activity with passed in data through intent
                List<PlateDO> plateDOS = new ArrayList<>();
                for (JsonElement element : responseModelDO.getResult()){
                    JsonObject jsonObject = element.getAsJsonObject();
                    plateDOS.add(new PlateDO(
                            jsonObject.get("food_img").getAsString(),
                            jsonObject.get("type").getAsString(),
                            jsonObject.get("price").getAsString(),
                            jsonObject.get("name").getAsString(),
                            jsonObject.get("rating").getAsString()));
                }

                platesLiveData.setValue(plateDOS);
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Toast.makeText(context, R.string.cannot_conect_to_servers, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
