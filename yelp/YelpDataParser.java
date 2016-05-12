package ca.ubc.cs.cpsc210.quiz.yelp;

import ca.ubc.cs.cpsc210.quiz.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.stream.Location;
import java.util.ArrayList;
import java.util.List;

/**
 * Parser for JSON data returned by Yelp.
 */
public class YelpDataParser {


    public YelpDataParser() {

    }

    // Parses a JSONObject received in response to a Yelp search for restaurants,
    // filtered by city name and produces corresponding list of restaurants that are not closed.
    // If the yelpCityFilter is null, "Vancouver" is used as the city filter.
    // Return a list of restaurants parsed from Yelp response that are not closed and whose city matches yelpCityFilter
    public static java.util.List<Restaurant> parseRestaurantData(java.lang.String response,
                                                                 java.lang.String yelpCityFilter)
            throws org.json.JSONException {
        JSONObject restaurantsYelp = new JSONObject(response);
        List<Restaurant> restaurantsReturn = new ArrayList<Restaurant>();


        JSONArray businesses = restaurantsYelp.getJSONArray("businesses");
        for (int a = 0; a < businesses.length(); a++) {
            JSONObject business = businesses.getJSONObject(a);

            // name, id
            String name = business.getString("name");
            String id = business.getString("id");

            // categories
            List<Category> categoriesList = new ArrayList<Category>();

            JSONArray categories = business.getJSONArray("categories");
            for (int i = 0; i < categories.length(); i++) {
                JSONArray category = categories.getJSONArray(i);

                Category categ = new Category(category.getString(0), category.getString(1));
                categoriesList.add(categ);
            }

            // location object
            JSONObject location = business.getJSONObject("location");


            // postal code
            //Boolean postalCode = location.has("postal_code");


                // City: city, state code, country code
                String cityName = location.getString("city");
                String stateCode = location.getString("state_code");
                String countryCode = location.getString("country_code");

                City city = new City(cityName, stateCode, countryCode);

                // address
                JSONArray addresses = location.getJSONArray("address");
                // for (int c = 0; c < addresses.length(); c++) {
                String address = addresses.getString(0);


                // Check if restaurant is open(.equals(false)) false = open
                Boolean isClosed = business.getBoolean("is_closed");
                if (isClosed.equals(false) && cityName.equals(yelpCityFilter)) {
                    if (location.has("postal_code")) {

                    // Check if restaurant has neighborhoods
                   // Neighbourhood neighborhood;

                        if (location.has("neighborhoods")) {
                        JSONArray neighborhoods = location.getJSONArray("neighborhoods");
                        String NeighborhoodName = neighborhoods.getString(0);
                        Neighbourhood neighborhood = new Neighbourhood(NeighborhoodName, city);
                        restaurantsReturn.add(new Restaurant(name, categoriesList, id, address, location.getString("postal_code"), neighborhood));
                    }
                        else restaurantsReturn.add(new Restaurant(name, categoriesList, id, address, location.getString("postal_code"), city));
                }
                    else if (location.has("neighborhoods")) {
                        JSONArray neighborhoods = location.getJSONArray("neighborhoods");
                        String NeighborhoodName = neighborhoods.getString(0);
                        Neighbourhood neighborhood = new Neighbourhood(NeighborhoodName, city);

                        restaurantsReturn.add(new Restaurant(name, categoriesList, id, address, null, neighborhood));
                    }
                    else restaurantsReturn.add(new Restaurant(name, categoriesList, id, address, null, city));
                }

                }
        return restaurantsReturn;
        }

    }















// isClosed

//if (isClosed.equals(false) && cityName.equals(yelpCityFilter) && location.has("neighborhoods")) {
// restaurantsReturn.add(new Restaurant(name, categoriesList, id, address, postalCode, neighborhood));
// }
// if (isClosed.equals(false) && cityName.equals(yelpCityFilter) && !location.has("neighborhoods")) {
//restaurantsReturn.
//  }