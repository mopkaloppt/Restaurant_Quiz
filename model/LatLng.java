package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Stand-in for com.google.android.gms.maps.model.LatLng
 * Represents a position specified with latitude/longitude coords
 */
public class LatLng {

    protected double lat;
    protected double lng;

    // Constructor initializes LatLng with given latitude and longitude
    public LatLng(double lat, double lng) {

        this.lat = lat;
        this.lng = lng;
    }


    public double getLat() {

        return lat;
    }

    public double getLng() {

        return lng;
    }
}
