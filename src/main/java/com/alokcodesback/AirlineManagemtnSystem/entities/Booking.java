package com.alokcodesback.AirlineManagemtnSystem.entities;

import com.alokcodesback.AirlineManagemtnSystem.entities.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {

    private int id;

//    @OneToOne
    private Flight flight;

//    @OneToone
    private User bookingPerson;
//  @onetomany
    private List<Passenger> passengers;

    private BookingStatus bookingStatus;

//    @Onetomany
    private List<Seat> seatList;


    private double finalAmount;

    private String transactionId;

    private LocalDateTime createdTime;

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getBookingPerson() {
        return bookingPerson;
    }

    public void setBookingPerson(User bookingPerson) {
        this.bookingPerson = bookingPerson;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
