package ca.ubc.cs.cpsc210.quiz.model;

/**
 * Represents a restaurant having a street address, geographical area, postal code, name, id categories
 * and list of reviews.
 */
public class Restaurant {
    private java.lang.String name;
    private java.util.List<Category> categories;
    private java.lang.String id;
    private java.lang.String address;
    private java.lang.String postalCode;
    private GeoArea geographicalArea;



    // Constructor initializes Restaurant with given name,
    // list of categories, id, address, postal code and geographical area.
    public Restaurant(java.lang.String name,
                      java.util.List<Category> categories,
                      java.lang.String id,
                      java.lang.String address,
                      java.lang.String postalCode,
                      GeoArea geographicalArea) {

        this.name = name;
        this.categories = categories;
        this.id = id;
        this.address = address;
        this.postalCode = postalCode;
        this.geographicalArea = geographicalArea;

    }

    public java.lang.String getAddress() {
        return address;

    }

    public java.lang.String getName() {
        return name;

    }

    public java.util.List<Category> getCategories() {
        return categories;

    }

    public java.lang.String getId() {
        return id;

    }

    public java.lang.String getPostalCode() {
        return postalCode;

    }

    public GeoArea getGeographicalArea() {
        return geographicalArea;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        if (geographicalArea != null ? !geographicalArea.equals(that.geographicalArea) : that.geographicalArea != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (postalCode != null ? !postalCode.equals(that.postalCode) : that.postalCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (geographicalArea != null ? geographicalArea.hashCode() : 0);
        return result;
    }

    // Produces string representation of restaurant of form:
    // name + first string in geographical areas geostrings + postal code
    // (e.g., "Heirloom Vegetarian, Fairview, Vancouver, BC, V6J 2E1") Postal code omitted if it is null
    public java.lang.String toString() {
        if (postalCode != null) {
            return name + ", " + geographicalArea.getAllGeoStrings().get(0) + ", " + postalCode;
        }
        else
            return name + ", " + geographicalArea.getAllGeoStrings().get(0);

    }


}