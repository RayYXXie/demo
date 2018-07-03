package com.ray.flight;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.ray.flight.entity.Route;
import com.ray.flight.service.RouteService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FlightFileApplicationTests {
	
	@Resource(name="routeFileServiceImpl")
	private RouteService routeService;

	@Test
	public void findCountSrcToDest() throws Exception{
		Long count = routeService.findCountSrcToDest("ATL", "ORD");
		assertEquals(19, count.longValue());
	}
	
	@Test
	public void averageRouteStops() throws Exception{
		Double avgStops = routeService.averageRouteStops("BOS", "MCO");
		assertEquals("0.25", avgStops.toString());
	}
	
	@Test
	public void findCountDepartFromSrc() throws Exception{
		Long count = routeService.findCountDepartFromSrc("ATL");
		assertEquals(915, count.longValue());
	}
	
	@Test
	public void findRoutesFromSrcToDest() throws Exception{
		List<Route> routeList = routeService.findRoutesFromSrcToDest("SIN", "CDG");
		StringBuffer sb = new StringBuffer("");
		for(Route route : routeList) {
			sb.append(" airline: ").append(route.getAirline()).append(", stops: ").append(route.getStops()).append(", equipment: ").append(route.getEquipments());
		}
		assertEquals(" airline: AF, stops: 0, equipment: 77W airline: SQ, stops: 0, equipment: 388", sb.toString());
	}

}
