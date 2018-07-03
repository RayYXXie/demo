package com.ray.flight;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.ray.flight.service.RouteService;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class FlightDBApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Resource(name="routeFileServiceImpl")
	private RouteService routeService;

	@Test
	public void ping() throws Exception {
		final ResponseEntity<String> responseEntity = restTemplate.getForEntity("/ping", String.class);
		assertEquals("Pong", responseEntity.getBody());
	}
	
	@Test
	public void findCountSrcToDest() throws Exception{
		final ResponseEntity<String> responseEntity = restTemplate.getForEntity("/airlines/from/ATL/to/ORD", String.class);
		assertEquals("19", responseEntity.getBody());
		
	}
	
	@Test
	public void averageRouteStops() throws Exception{
		final ResponseEntity<String> responseEntity = restTemplate.getForEntity("/averageRouteStops/from/BOS/to/MCO", String.class);
		assertEquals("0.25", responseEntity.getBody());
		
	}
	
	@Test
	public void findCountDepartFromSrc() throws Exception{
		final ResponseEntity<String> responseEntity = restTemplate.getForEntity("/airlines/from/ATL", String.class);
		assertEquals("915", responseEntity.getBody());
		
	}
	
	@Test
	public void findRoutesFromSrcToDest() throws Exception{
		final ResponseEntity<String> responseEntity = restTemplate.getForEntity("/routes/from/SIN/to/CDG", String.class);
		assertEquals(" airline: AF, stops: 0, equipment: 77W airline: SQ, stops: 0, equipment: 388", responseEntity.getBody());
		
	}

}
