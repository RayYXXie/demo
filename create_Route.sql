-- DROP TABLE `route`


CREATE TABLE `route` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Airline` varchar(3) DEFAULT NULL,
  `AirlineId` varchar(5) DEFAULT NULL,
  `SourceAirport` varchar(4) DEFAULT NULL,
  `SourceAirportId` varchar(5) DEFAULT NULL,
  `DestinationAirport` varchar(4) DEFAULT NULL,
  `DestinationAirportId` varchar(5) DEFAULT NULL,
  `Codeshare` varchar(5) DEFAULT NULL,
  `Stops` int(11) DEFAULT NULL,
  `Equipment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
