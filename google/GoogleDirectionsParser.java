package ca.ubc.cs.cpsc210.quiz.google;

import ca.ubc.cs.cpsc210.quiz.model.LatLng;
import ca.ubc.cs.cpsc210.quiz.model.Leg;
import ca.ubc.cs.cpsc210.quiz.model.Route;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * Parser for response from Google Directions API.
 */
public class GoogleDirectionsParser {


    public GoogleDirectionsParser() {
    }


    // Parse route from Google Directions API response
    // Return route object corresponding to response provided by Google Directions API
    /*To complete this task you must implement the parseRoute method specified in the GoogleDirectionsParser class.
     This method must produce a Route object that contains a Leg object for each leg found in the JSON response.
     Each Leg object must contain a LatLng point for each point in each step of the leg.
      */
    public static Route parseRoute(java.lang.String response)
            throws org.json.JSONException {
        JSONObject route = new JSONObject(response);
        Route routeReturn = new Route();

        JSONArray legs = route.getJSONArray("routes").getJSONObject(0).getJSONArray("legs");
        for (int j = 0; j < legs.length(); j++) {
            JSONObject leg = legs.getJSONObject(j);
            Leg leg1 = new Leg();

            int distance = leg.getJSONObject("distance").getInt("value");
            leg1.setDistance(distance);
            routeReturn.addLeg(leg1);

            JSONArray steps = route.getJSONArray("routes").getJSONObject(0).getJSONArray("legs").getJSONObject(j).getJSONArray("steps");
            for (int k = 0; k < steps.length(); k++) {
                JSONObject step = steps.getJSONObject(k);
                String polyline = step.getJSONObject("polyline").getString("points");

                List<LatLng> latLngs = PolylineDecoder.decodePoly(polyline);

                leg1.addAllPoints(latLngs);
            }


        }
        return routeReturn;
    }
}



