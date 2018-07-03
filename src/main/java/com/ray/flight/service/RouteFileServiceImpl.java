package com.ray.flight.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ray.flight.entity.Route;
import com.ray.flight.utils.Tool;

@Service
public class RouteFileServiceImpl implements RouteService {

	@Override
	public void save(Route route) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveByBatch(List<Route> routeList) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long findCountSrcToDest(String src, String dest) {
		List<Route> routeSrcToDestList = new ArrayList<Route>();
		List<Route> routeList = Tool.readFileAndConvert();
		for(Route route : routeList) {
			if(route.getSourceAirport().equals(src) && route.getDestinationAirport().equals(dest)) {
				routeSrcToDestList.add(route);
			}
		}
		return Long.parseLong(Integer.toString(routeSrcToDestList.size()));
	}

	@Override
	public Double averageRouteStops(String src, String dest) {
		Long totalStops = 0l;
		List<Route> routeSrcToDestList = new ArrayList<Route>();
		List<Route> routeList = Tool.readFileAndConvert();
		for(Route route : routeList) {
			if(route.getSourceAirport().equals(src) && route.getDestinationAirport().equals(dest)) {
				routeSrcToDestList.add(route);
			}
		}
		for(Route route : routeSrcToDestList) {
			totalStops = totalStops + route.getStops();
		}
		return (1.0 * totalStops)/routeSrcToDestList.size();
	}

	@Override
	public Long findCountDepartFromSrc(String src) {
		List<Route> routeDepartFromSrcList = new ArrayList<Route>();
		List<Route> routeList = Tool.readFileAndConvert();
		for(Route route : routeList) {
			if(route.getSourceAirport().equals(src)) {
				routeDepartFromSrcList.add(route);
			}
		}
		return Long.parseLong(Integer.toString(routeDepartFromSrcList.size()));
	}

	@Override
	public List<Route> findRoutesFromSrcToDest(String src, String dest) {
		List<Route> routeSrcToDestList = new ArrayList<Route>();
		List<Route> routeList = Tool.readFileAndConvert();
		for(Route route : routeList) {
			if(route.getSourceAirport().equals(src) && route.getDestinationAirport().equals(dest)) {
				routeSrcToDestList.add(route);
			}
		}
		return routeSrcToDestList;
	}

	@Override
	public List<Route> findRoute(Route route) {
		// TODO Auto-generated method stub
		return null;
	}

}
