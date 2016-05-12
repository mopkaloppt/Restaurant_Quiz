package ca.ubc.cs.cpsc210.quiz.model;

import java.util.ArrayList;

/**
 * Represents a route having a list of legs and a distance.
 */
public class Route {

    private java.util.List<Leg> legs;
    private int distance;


    // Constructor initializes Route with empty list of points and zero distance
    public Route() {
        legs = new ArrayList<Leg>();
        distance = 0;


    }

    // Add a leg to this route
    public void addLeg(Leg leg) {
        legs.add(leg);


    }


    // Get total distance for this route (the sum of the distances for the legs)
    // Return: total distance
    public int getDistance() {

        for(int i = 0; i<legs.size(); i++)
        distance = distance + legs.get(i).getDistance();
        return distance;
    }

    // Get points on this route
    // Returns:  list of points on this route
    public java.util.List<Leg> getLegs() {
        return legs;
    }


}
