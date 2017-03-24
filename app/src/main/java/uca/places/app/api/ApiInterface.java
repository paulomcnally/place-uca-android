package uca.places.app.api;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import uca.places.app.models.LocationModel;
import uca.places.app.models.PlaceModel;

public interface ApiInterface {

    @POST("Places")
    Call<PlaceModel> placeAdd(@Body PlaceModel placeModel);

    @POST("Places/explore")
    Call<List<PlaceModel>> placeExplore(@Body LocationModel locationModel);

}
