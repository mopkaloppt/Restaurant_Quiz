package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;

/**
 * Represents a name having a name, province/state code and country code
 */
public class City implements GeoArea {
    private java.lang.String cityName;
    private java.lang.String province;
    private java.lang.String countryCode;


    // Constructor initializes City with given name, province and country code
    // throws java.lang.IllegalArgumentException if length of province or length of country code is not exactly 2
    public City(java.lang.String cityName,
                java.lang.String province,
                java.lang.String countryCode) throws java.lang.IllegalArgumentException {

        this.cityName = cityName;
        if (province.length() != 2 || countryCode.length() != 2) {
            throw new IllegalArgumentException();
        } else {
            this.province = province;
            this.countryCode = countryCode;
        }
    }



    // Returns a string consisting of the form "city, province, country" (e.g. "Vancouver, BC, CA")
    public java.lang.String getCityString() {

        return cityName + ", " + province + ", " + countryCode;

    }

    // Produces an array of strings that contains only the string produced by getCityString
    public java.util.List<java.lang.String> getAllGeoStrings() {
        ArrayList<String> arrGeoString = new ArrayList<String>();
        String str = getCityString();
        arrGeoString.add(str);


        return arrGeoString;

    }

    /* In addition, note that a City is considered equal to a Neighbourhood if the Neighbourhood's city is equal to that City.
    This bit is tricky.  Note that Neighbourhood.equals has been provided for you - you may want to consult it for some hints on how to implement City.equals*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Neighbourhood) {
            Neighbourhood nbh = (Neighbourhood) o;
            return nbh.getCity().getCityString().equals(this.getCityString());

        }
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        if (cityName != null ? !cityName.equals(city.cityName) : city.cityName != null) return false;
        if (countryCode != null ? !countryCode.equals(city.countryCode) : city.countryCode != null) return false;
        if (province != null ? !province.equals(city.province) : city.province != null) return false;

        return true;
    }

   @Override
    public int hashCode() {
        int result = cityName != null ? cityName.hashCode() : 0;
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        return result;
    }



}
