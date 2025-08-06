package com.alokcodesback.AirlineManagemtnSystem.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Flight {

    private int id;

    private String startingPoint; //location object can be user further

    private String destinationPoint; //location object can be user further

    private double fare;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startTime;

    private CompanyDetails companyDetails; //int companyDetailsId


//    onr to many
    private List<Seat> seatList;

    public Flight(int id, String start, String end, int f, CompanyDetails indigo, List<Seat> es, LocalDateTime startTime) {
        this.id = id;
        this.startingPoint = start;
        this.destinationPoint = end;
        this.fare = f;
        this.companyDetails = indigo;
        this.seatList = es;
        this.startTime = startTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getDestinationPoint() {
        return destinationPoint;
    }

    public void setDestinationPoint(String destinationPoint) {
        this.destinationPoint = destinationPoint;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public CompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
