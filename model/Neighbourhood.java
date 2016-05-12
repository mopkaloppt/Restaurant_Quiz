package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a neighbourhood having a name in a city
 */
public class Neighbourhood implements GeoArea {
    private java.lang.String neighbourhoodName;
    private City city;

    // Constructor initializes Neighbourhood with given neighbourhood name and city
    public Neighbourhood(java.lang.String neighbourhoodName, City city) {
        this.neighbourhoodName = neighbourhoodName;
        this.city = city;

    }

    public City getCity() {
        return city;

    }

    // Gets the city string for this neighbourhood's city
    public java.lang.String getCityString() {
        return city.getCityString();

    }

    /* Returns list of strings that can be used to describe the neighbourhood,
     starting with just the first word in neighbourhoodName, then first plus second
    E.g. if Neighborhood name is 'Fancy Slopes Drive', this method will produce:
    first -> Fancy, City, Prov, Country Code
    second -> Fancy Slopes, City, Prov, Country Code
    third -> Fancy Slopes Drive, City, Prov Country Code*/
    public java.util.List<java.lang.String> getAllGeoStrings() {

        List<String> geoString = Arrays.asList(neighbourhoodName.split(" "));
        String s = new String();
        List<String> geoReturn = new ArrayList<String>();


        for (int i=0; i< geoString.size(); i++){

            String s1 = geoString.subList(i, i+1).toString();
            s1 = s1.replace(",", " ").substring(1, s1.length() - 1);
            String s2 = new String();

            if (i == 0) {s = s.concat(s1);}
            else s=s.concat(" " + s1);

            s2 = s.concat(", ".concat(this.city.getCityString()));
            geoReturn.add(s2);
        }
        return geoReturn;
    }


       /* List<String> geoString = new LinkedList<String>();
        String str = getCityString();
        String[] arrString = str.split(" ");
        String acc = new String();
        for (String s : arrString)
        {
            acc = acc + s;
            geoString.add(acc + city.getCityString());
        }
        return geoString;*/



    /**
     * Two neighbourhoods are equal if they have the same city and same name
     * When o is a City, this neighbourhood is equal to it, if it has the same city.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        // will have to revisit this if we add subtypes of GeoArea other than City and Neighborhood
        if (o == null || !(o instanceof GeoArea)) return false;

        // when o is a City, this Neighborhood is equal to o if the cities are equal
        if (o instanceof City)
            return city.equals(o);

        // must be a Neighborhood
        Neighbourhood other = (Neighbourhood) o;

        return (city.equals(other.city));
    }

    @Override
    public int hashCode() {
        return city != null ? city.hashCode() : 0;
    }
}
