package com.ray.flight.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ray.flight.entity.Route;



public class Tool {
	
	public static List<Route> readFileAndConvert() {    
		List<Route> routeList = new ArrayList<Route>();
		
        try {   
        	ClassLoader cl = Tool.class.getClassLoader();
        	File file = new File(cl.getResource("routes.dat").getFile());  
            BufferedReader reader = new BufferedReader(new FileReader(file)); 
            reader.readLine();
            String line = null;  
            while((line=reader.readLine())!=null){  
            	String[] items = line.split(",");
            	Route route = new Route();
            	route.setAirline(items[0]);

            	route.setAirlineId(items[1]);

            	route.setSourceAirport(items[2]);

            	route.setSourceAirportId(items[3]);

            	route.setDestinationAirport(items[4]);

            	route.setDestinationAirportId(items[5]);

            	route.setCodeShare(items[6]);
            	
            	route.setStops(Integer.valueOf(items[7]));
                
                route.setEquipments(items[items.length - 1]);
                
                routeList.add(route);
            }    
        } catch (Exception e) {    
            e.printStackTrace();    
        } 
        return routeList;
    }  
	
	public static void removeElementFromList(List<Route> routeList, Route target) {
		Iterator<Route> iter = routeList.iterator();
		while(iter.hasNext()) {
			iter.remove();
		}	
	}
	
	public static List<Route> readFileAndConvertByStream() {  
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("aa");
	}
}
