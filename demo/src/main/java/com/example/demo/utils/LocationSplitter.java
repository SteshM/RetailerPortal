package com.example.demo.utils;


import com.example.demo.Exception.LocationNull;
import com.example.demo.model.Location;

public class LocationSplitter {
    public static Location getLocation(String locationLatLong) throws LocationNull{
        String both[] = locationLatLong.split(",");
        if(both.length<2){
            throw new LocationNull("The location could not be split");
        }
        Location location = new Location();
        try{
            location.setLat(Float.valueOf(both[0]));
            location.setLongitude(Float.valueOf(both[1]));
            return location;
        }catch(Exception exception){
            throw new LocationNull("The location is not in right format");
        }

    }

    public static String joinLocation(Location location){
        return ""+location.getLat()+", "+location.getLongitude();
    }
}


