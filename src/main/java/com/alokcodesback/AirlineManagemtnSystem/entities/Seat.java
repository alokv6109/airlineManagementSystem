package com.alokcodesback.AirlineManagemtnSystem.entities;

import com.alokcodesback.AirlineManagemtnSystem.entities.enums.SeatClass;
import com.alokcodesback.AirlineManagemtnSystem.entities.enums.SeatStatus;

public class Seat {

    private int id;

    private String seatNumber;

    private SeatStatus seatStatus;

    private SeatClass seatClass;

//    @ManyToOne
    private Flight flight; // int flightId;

    public Seat(int id, String seatNumber, SeatStatus seatStatus, SeatClass seatClass) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
        this.seatClass = seatClass;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}
