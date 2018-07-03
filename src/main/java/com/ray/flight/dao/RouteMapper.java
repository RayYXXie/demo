package com.ray.flight.dao;

import java.util.List;

import com.ray.flight.entity.Route;

public interface RouteMapper {

	public void save(Route route);

	public void save(List<Route> routeList);
	
	public List<Route> findRoute(Route route);

	public Long findRouteSrcToDest(Route route);

	public List<Route> findCodeShareRouteListSrcToDest(Route route);

	public Double averageRouteStops(Route route);

	public Long findCountDepartFromSrc(Route route);

	public List<Route> findRoutesFromSrcToDest(Route route);
}
