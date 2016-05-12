package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;

/**
 * Represents a leg that has an arbitrary number of points and a distance.  Part of a route.
 */
public class Leg {

    private java.util.List<LatLng> points;
    private int distance;



    // Constructor initializes Leg with empty list of points and zero distance.
    public Leg() {
        points = new ArrayList<LatLng>();
        distance = 0;

    }

    // Add a point to the leg
    public void addPoint(LatLng pt) {
        points.add(pt);

    }

    // Add a list of points to the leg
    public void addAllPoints(java.util.List<LatLng> pts) {
        points.addAll(pts);
    }

    // Gets all points on this leg
    // Returns: list of points on this leg
    public java.util.List<LatLng>  getPoints() {
        return points;
    }

    // Set the distance for this leg
    public void setDistance(int distance) {
        this.distance = distance;

    }

    // Get leg distance
    // Returns:  the leg distance in metres
    public int getDistance() {
        return distance;
    }





}
