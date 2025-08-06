package com.alokcodesback.AirlineManagemtnSystem.payloads;

import lombok.Data;

import java.util.List;


public class BookingCreationDTO {
    private int userId;
    private int flightId;
    List<String> seatId;
    List<Integer> passengerId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public List<String> getSeatId() {
        return seatId;
    }

    public void setSeatId(List<String> seatId) {
        this.seatId = seatId;
    }

    public List<Integer> getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(List<Integer> passengerId) {
        this.passengerId = passengerId;
    }
}
