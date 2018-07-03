package com.ray.flight.entity;

public class Route {
	private String Id;
	private String airline;
	private String airlineId;
	private String sourceAirport;
	private String sourceAirportId;
	private String destinationAirport;
	private String destinationAirportId;
	private String codeShare;
	private Integer stops;
	private String equipments;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getSourceAirportId() {
		return sourceAirportId;
	}

	public void setSourceAirportId(String sourceAirportId) {
		this.sourceAirportId = sourceAirportId;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String getDestinationAirportId() {
		return destinationAirportId;
	}

	public void setDestinationAirportId(String destinationAirportId) {
		this.destinationAirportId = destinationAirportId;
	}

	public String getCodeShare() {
		return codeShare;
	}

	public void setCodeShare(String codeShare) {
		this.codeShare = codeShare;
	}

	public Integer getStops() {
		return stops;
	}

	public void setStops(Integer stops) {
		this.stops = stops;
	}

	public String getEquipments() {
		return equipments;
	}

	public void setEquipments(String equipments) {
		this.equipments = equipments;
	}

	@Override
	public String toString() {
		return "Route [airline=" + airline + ", stops=" + stops + ", equipments=" + equipments + "]";
	}

}
