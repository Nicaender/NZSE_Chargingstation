package com.nzse_chargingstation.app.classes;

import java.util.ArrayList;

/**
 * A class that contains charging station(s), which saved by user in a route plan.
 */
public class RoutePlan {

    public RoutePlan(String name) {
        this.name = name;
    }
    private String name;
    private final ArrayList<ChargingStation> chargingStationRoutes = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChargingStation> getChargingStationRoutes() {
        return chargingStationRoutes;
    }
}
