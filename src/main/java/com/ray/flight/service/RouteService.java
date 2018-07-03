package com.ray.flight.service;

import java.util.List;

import com.ray.flight.entity.Route;


public interface RouteService {

	public void save(Route route);

	public void saveByBatch(List<Route> routeList);
	
	public List<Route> findRoute(Route route);

	public Long findCountSrcToDest(String src, String dest);

	public Double averageRouteStops(String src, String dest);

	public Long findCountDepartFromSrc(String src);

	public List<Route> findRoutesFromSrcToDest(String src, String dest);
}
