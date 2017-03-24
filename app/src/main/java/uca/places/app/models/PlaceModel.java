package uca.places.app.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by polin on 03-23-17.
 */

public class PlaceModel {
    private String name;
    @SerializedName("location")
    private LocationModel locationModel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationModel getLocationModel() {
        return locationModel;
    }

    public void setLocationModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }
}
