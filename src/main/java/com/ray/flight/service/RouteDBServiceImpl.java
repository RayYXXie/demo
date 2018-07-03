package com.ray.flight.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ray.flight.dao.RouteMapper;
import com.ray.flight.entity.Route;

@Service
public class RouteDBServiceImpl implements RouteService {

	@Resource
	private RouteMapper routeMapper;
	
	@Override
	public void save(Route route) {
		routeMapper.save(route);
	}

	@Override
	public void saveByBatch(List<Route> routeList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long findCountSrcToDest(String src, String dest) {
		Route route = new Route();
		route.setSourceAirport(src);
		route.setDestinationAirport(dest);
		Long count = routeMapper.findRouteSrcToDest(route);
		return count;
	}

	@Override
	public Double averageRouteStops(String src, String dest) {
		Route route = new Route();
		route.setSourceAirport(src);
		route.setDestinationAirport(dest);
		Double avgStops = routeMapper.averageRouteStops(route);
		return avgStops;
	}

	@Override
	public Long findCountDepartFromSrc(String src) {
		Route route = new Route();
		route.setSourceAirport(src);
		Long count = routeMapper.findCountDepartFromSrc(route);
		return count;
	}

	@Override
	public List<Route> findRoutesFromSrcToDest(String src, String dest) {
		Route route = new Route();
		route.setSourceAirport(src);
		route.setDestinationAirport(dest);
		List<Route> routeList = new ArrayList<Route>();
		routeList = routeMapper.findRoutesFromSrcToDest(route);
		return routeList;
	}

	@Override
	public List<Route> findRoute(Route route) {
		List<Route> routeList= routeMapper.findRoute(route);
		return routeList;
	}

}
