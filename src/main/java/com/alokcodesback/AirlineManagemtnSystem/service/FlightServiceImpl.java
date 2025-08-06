package com.alokcodesback.AirlineManagemtnSystem.service;

import com.alokcodesback.AirlineManagemtnSystem.entities.Flight;
import com.alokcodesback.AirlineManagemtnSystem.exception.FlightDetailsException;
import com.alokcodesback.AirlineManagemtnSystem.payloads.FlightSearchConditionDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl {

    private Set<String> locationsServed = Set.of("DEL", "BOM", "BLR", "CDG", "HYD");

    private List<Flight> flights=new ArrayList<>();

    public Flight addFlight(Flight flight){
        //validaion logic :
        if(!locationsServed.contains(flight.getStartingPoint()) ||
            !locationsServed.contains(flight.getDestinationPoint()) ||
                !LocalDateTime.now().isBefore(flight.getStartTime()) ||
                !(flight.getFare() > 100.0)
        ){
            throw new FlightDetailsException("The input params are not correct in your request, Please verify again!!");
        }

        flights.add(flight);

        return flight;

    }

    public List<Flight> searchFlightsWithGivenCondition(FlightSearchConditionDto flightFilter) {
        if((flightFilter.getStartPoint()!= null && !locationsServed.contains(flightFilter.getStartPoint()))||
                (flightFilter.getStartPoint()!= null &&  !locationsServed.contains(flightFilter.getEndPoint()))){
            throw  new FlightDetailsException("The input params of starting and ending points needs to be checked, we currently don't serve there");
        }

        // using stream in java8 to basically filter on the condtions one by one, even if they are provided or
        return flights.stream()
                .filter(flight ->
                        (flightFilter.getStartPoint() == null || flightFilter.getStartPoint().equalsIgnoreCase(flight.getStartingPoint())) &&
                        (flightFilter.getEndPoint() == null || flightFilter.getEndPoint().equalsIgnoreCase(flight.getDestinationPoint())) &&
                        (flightFilter.getTravellingDate() == null || flight.getStartTime().toLocalDate().isEqual(flightFilter.getTravellingDate())) &&
                        (flightFilter.getCompanyName() == null || flightFilter.getCompanyName().equalsIgnoreCase(flight.getCompanyDetails().getCompanyName()))
                )
                .collect(Collectors.toList());
    }


    public Set<String> getLocationsServed() {
        return locationsServed;
    }

    public void setLocationsServed(Set<String> locationsServed) {
        this.locationsServed = locationsServed;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Flight getFlightByID(int flightId) {
        return flights.stream()
                .filter(f -> f.getId() == flightId)
                .findFirst().orElse(null);
    }
}
