package com.alokcodesback.AirlineManagemtnSystem.controller;

import com.alokcodesback.AirlineManagemtnSystem.entities.Flight;
import com.alokcodesback.AirlineManagemtnSystem.exception.FlightDetailsException;
import com.alokcodesback.AirlineManagemtnSystem.payloads.FlightSearchConditionDto;
import com.alokcodesback.AirlineManagemtnSystem.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightService;

    // add a flight : POST
    @PostMapping("/flight")
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight){
        if(flight.getCompanyDetails() == null) throw new FlightDetailsException("Please provide the company details and registrationId ");
        Flight f = flightService.addFlight(flight);
        return new ResponseEntity<>(f, HttpStatus.CREATED);
    }

    @PostMapping("/flight/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestBody FlightSearchConditionDto flightSearchConditionDto){
        List<Flight> flights = flightService.searchFlightsWithGivenCondition(flightSearchConditionDto);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<Flight> getFlightDetails(@PathVariable int flightId){
        Flight flightByID = flightService.getFlightByID(flightId);
        return new ResponseEntity<>(flightByID, HttpStatus.OK);
    }

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightService.getFlights(), HttpStatus.OK);
    }
}
