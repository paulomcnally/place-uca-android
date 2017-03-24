package uca.places.app.ui.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uca.places.app.R;
import uca.places.app.api.Api;
import uca.places.app.models.LocationModel;
import uca.places.app.models.PlaceModel;

public class PlaceAddActivity extends AppCompatActivity {

    private EditText name;
    private Button save;

    private Double latitude;
    private Double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            latitude = extras.getDouble("latitude");
            longitude = extras.getDouble("longitude");
            // and get whatever type user account id is
        }




        initViews();
    }


    private void initViews() {
        name = (EditText) findViewById(R.id.name);
        save = (Button) findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveAction();
            }
        });
    }


    private void saveAction() {
        if(name.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Chele pone el texto", Toast.LENGTH_LONG).show();
        } else {
            PlaceModel placeModel = new PlaceModel();
            placeModel.setName(name.getText().toString());

            LocationModel locationModel = new LocationModel();
            locationModel.setLat(latitude);
            locationModel.setLng(longitude);

            placeModel.setLocationModel(locationModel);


            Call<PlaceModel> call = Api.instance().placeAdd(placeModel);
            call.enqueue(new Callback<PlaceModel>() {
                @Override
                public void onResponse(Call<PlaceModel> call, Response<PlaceModel> response) {
                    if(response != null && response.body() != null) {
                        finish();
                    } else {
                        Log.i("PlaceAddActivity", "Negres, no funko");
                    }
                }

                @Override
                public void onFailure(Call<PlaceModel> call, Throwable throwable) {
                    Log.i("PlaceAddActivity", throwable.getMessage());
                }
            });
        }
    }
}



















