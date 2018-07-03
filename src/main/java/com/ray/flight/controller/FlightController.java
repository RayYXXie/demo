package com.ray.flight.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ray.flight.entity.Route;
import com.ray.flight.service.RouteService;
import com.ray.flight.utils.Tool;

@CrossOrigin(origins="*")
@RestController
public class FlightController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="routeDBServiceImpl")
	private RouteService routeService;
	
	@RequestMapping(value="/ping",method={RequestMethod.GET})
	public ResponseEntity<String> ping() {
		return new ResponseEntity<>("Pong", HttpStatus.OK);
	}
	
	@RequestMapping(value ="/saveRoute", method={RequestMethod.GET}) 
	public ResponseEntity<String> saveRoute(){
		List<Route> routeList = Tool.readFileAndConvert();
		for(Route route:routeList ) {
			routeService.save(route);
		}
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
	
	@RequestMapping(value="/airlines/from/{src}/to/{dest}", method ={RequestMethod.GET})
	public Long findCountSrcToDest(@PathVariable String src, @PathVariable String dest){
		try {
			Long airlines=routeService.findCountSrcToDest(src, dest);
			return airlines;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	@RequestMapping(value = "/averageRouteStops/from/{src}/to/{dest}", method = {RequestMethod.GET}) 
	public ResponseEntity<String> averageRouteStops(@PathVariable String src,@PathVariable String dest){
		try {
			Double avgStops = routeService.averageRouteStops(src, dest);
			return new ResponseEntity<String>(avgStops.toString(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(value = "/airlines/from/{src}", method = {RequestMethod.GET}) 
	public ResponseEntity<String> findCountDepartFromSrc(@PathVariable String src){
		try {
			Long airlines = routeService.findCountDepartFromSrc(src);
			return new ResponseEntity<String>(airlines.toString(), HttpStatus.OK);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<String>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/routes/from/{src}/to/{dest}", method = {RequestMethod.GET}) 
	public ResponseEntity<String> findRoutesFromSrcToDest(@PathVariable String src, @PathVariable String dest){
		try {
			List<Route> routeList = routeService.findRoutesFromSrcToDest(src, dest);
			StringBuffer sb = new StringBuffer("");
			for(Route route : routeList) {
				sb.append(" airline: ").append(route.getAirline()).append(", stops: ").append(route.getStops()).append(", equipment: ").append(route.getEquipments());
			}
			return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<String>("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/findRoute" , method = {RequestMethod.GET})
	public List<Route> findRoute(Route route) {
		List<Route> routeList=routeService.findRoute(route);
		return routeList;		
	}

}
