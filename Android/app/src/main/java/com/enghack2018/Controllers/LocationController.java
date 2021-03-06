package com.enghack2018.Controllers;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import com.enghack2018.Service.LocationService;

/**
 *  Location Controller
 */
public class LocationController {

    private LocationService locationService;

    public LocationController(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        LocationService locationListener = new LocationService(locationManager, context);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Toast.makeText(context, "Location permission required", Toast.LENGTH_SHORT).show();
        } else if (locationManager != null) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);
        }

    }

    public Location getCurrentLocation(){
        return locationService.getLastBestLocation();
    }
}
