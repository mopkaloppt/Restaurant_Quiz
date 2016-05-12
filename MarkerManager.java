package ca.ubc.cs.cpsc210.quiz.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import ca.ubc.cs.cpsc210.quiz.model.Restaurant;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcarter on 14-11-06.
 *
 * Manager for markers plotted on map
 */
public class MarkerManager {
    private GoogleMap map;

    private List<Marker> markers;


    /**
     * Constructor initializes manager with map for which markers are to be managed.
     * @param map  the map for which markers are to be managed
     */
    public MarkerManager(GoogleMap map) {
        this.map = map;

        this.markers = new ArrayList<Marker>();



    }

    /**
     * Get last marker added to map
     * @return  last marker added
     */
    public Marker getLastMarker() {

        return markers.get(markers.size() - 1);
    }

    /**
     * Add green marker to show position of restaurant
     * @param point   the point at which to add the marker
     * @param title   the marker's title
     */
    public void addRestaurantMarker(LatLng point, String title) {


        BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN);

        Marker mark = map.addMarker(new MarkerOptions().position(point).icon(bitmapDescriptor));
        mark.setTitle(title);



    }



    /**
     * Add a marker to mark latest guess from user.  Only the most recent two positions selected
     * by the user are marked.  The distance from the restaurant is used to create the marker's title
     * of the form "xxxx m away" where xxxx is the distance from the restaurant in metres (truncated to
     * an integer).
     *
     * The colour of the marker is based on the distance from the restaurant:
     * - red, if the distance is 3km or more
     * - somewhere between red (at 3km) and green (at 0m) (on a linear scale) for other distances
     *
     * @param latLng
     * @param distance
     */

    public void addMarker(final LatLng latLng, double distance) {



        if (markers.size() < 2) {
            Marker mark = map.addMarker(new MarkerOptions().position(latLng));
            mark.setTitle(((int) distance) + "m away");
            mark.setIcon(BitmapDescriptorFactory.defaultMarker(getColour(distance)));
            markers.add(mark);

        }

        else {
            Marker mark = map.addMarker(new MarkerOptions().position(latLng));
            mark.setTitle(((int) distance) + "m away");
            mark.setIcon(BitmapDescriptorFactory.defaultMarker(getColour(distance)));
            markers.add(mark);

            for (int i = 0; i < markers.size() - 2; i++) {
                Marker m = markers.get(i);
                m.setVisible(false);
            }
        }


    }

    /**
     * Remove markers that mark user guesses from the map
     */
    public void removeMarkers() {

        for (Marker m: markers){
            m.remove();
        }
    }

    /**
     * Produce a colour on a linear scale between red and green based on distance:
     *
     * - red, if distance is 3km or more
     * - somewhere between red (at 3km) and green (at 0m) (on a linear scale) for other distances
     * @param distance  distance from restaurant
     * @return  colour of marker
     */
    private float getColour(double distance) {

        if (distance > 3000)
            return 0.0f;
        else if (distance > 2500)
            return 10.0f;
        else if (distance > 2250)
            return 20.0f;
        else if (distance > 2000)
            return 30.0f;
        else if (distance > 1750)
            return 40.0f;
        else if (distance > 1500)
            return 50.0f;
        else if (distance > 1250)
            return 60.0f;
        else if (distance > 1000)
            return 70.0f;
        else if (distance > 750)
            return 75.0f;
        else if (distance > 500)
            return 80.0f;
        else if (distance > 250)
            return 90.0f;
        else
            return 95.0f;


    }


}
