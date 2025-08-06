package com.alokcodesback.AirlineManagemtnSystem.controller;

import com.alokcodesback.AirlineManagemtnSystem.entities.Booking;
import com.alokcodesback.AirlineManagemtnSystem.payloads.ApiResponse;
import com.alokcodesback.AirlineManagemtnSystem.payloads.BookingCreationDTO;
import com.alokcodesback.AirlineManagemtnSystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookingController {


    @Autowired
    private BookingService bookingService;

    @PostMapping("/booking")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingCreationDTO bookingCreationDTO){
        Booking booking = bookingService.createBooking(bookingCreationDTO);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @GetMapping("/bookings/{userId}")
    public ResponseEntity<List<Booking>> getAllBookingsFromUser(@PathVariable int userId){
        return null;
    }
}
