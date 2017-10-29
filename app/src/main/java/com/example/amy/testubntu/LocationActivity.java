package com.example.amy.testubntu;

import android.app.ProgressDialog;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LocationActivity extends AppCompatActivity {

    LocationManager locationManager;
    FetchLocation location;
    TextView textView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        init();
    }
    public void init()
    {
        progressDialog=new ProgressDialog(this);
        textView=(TextView)findViewById(R.id.textView_location) ;
        location=new FetchLocation();
        locationManager=(LocationManager)getSystemService(LOCATION_SERVICE);
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER))
        {
            progressDialog.setTitle("GPRS....");
            progressDialog.setMessage(" Fetching Location Please Wait");
            progressDialog.show();
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,location);

        }
    }


    class FetchLocation implements LocationListener
    {

        @Override
        public void onLocationChanged(Location location) {
            if(location!=null) {
                progressDialog.dismiss();
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                textView.setText("Cureent Location=" + latitude + "," + longitude);
            }
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    }
}
