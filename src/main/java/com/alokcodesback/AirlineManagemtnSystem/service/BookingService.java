package com.alokcodesback.AirlineManagemtnSystem.service;

import com.alokcodesback.AirlineManagemtnSystem.entities.Booking;
import com.alokcodesback.AirlineManagemtnSystem.entities.Flight;
import com.alokcodesback.AirlineManagemtnSystem.entities.Seat;
import com.alokcodesback.AirlineManagemtnSystem.entities.User;
import com.alokcodesback.AirlineManagemtnSystem.entities.enums.BookingStatus;
import com.alokcodesback.AirlineManagemtnSystem.entities.enums.SeatStatus;
import com.alokcodesback.AirlineManagemtnSystem.exception.FlightDetailsException;
import com.alokcodesback.AirlineManagemtnSystem.payloads.BookingCreationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {


    @Autowired
    private  FlightServiceImpl flightService;
    private List<Booking> bookings =new ArrayList<>();

    private  static int bookingId = 0;


    public Booking createBooking(BookingCreationDTO bookingCreationDTO) {
        /*  actual code like this should be used while doing the booking with the pessimistic
        locking || can also use optimistic locking for doing this


        // lock seats
        List<Seat> seats = seatRepo.findAllByIdWithLock(seatIds);

        // validate availability
        if (seats.stream().anyMatch(s -> !s.isAvailable())) {
            throw new SeatAlreadyBookedException();
        }

        // mark seats unavailable
        seats.forEach(s -> s.setAvailable(false));


        // calculate fare and save booking
        BigDecimal fare = calculateFare(seats);
        Booking booking = new Booking(...);
        return bookingRepo.save(booking);


         */
        // for the in memory solution lets say I will use streams and accordingly make this operation happen

        User user = findAndValidateUser(bookingCreationDTO.getUserId());

        Flight flight = findFlightById(bookingCreationDTO.getFlightId());
        if(flight == null) throw new FlightDetailsException("Flight not found with id : " +bookingCreationDTO.getFlightId());

        List<Seat> seatsToBook = new ArrayList<>();

        for(String seatNumber  : bookingCreationDTO.getSeatId()){
            Seat seat = findSeat(flight, seatNumber);
            if(seat == null || seat.getSeatStatus().equals(SeatStatus.BOOKED)){
                throw new RuntimeException("Seat " + seatNumber + " is NA");
            }
            seatsToBook.add(seat);
        }

        //mark the seats as booked now
        seatsToBook.forEach(e -> e.setSeatStatus(SeatStatus.BOOKED));

//        create a new booking
        Booking booking = new Booking();
        bookingId += 1;
        booking.setId(bookingId);
        booking.setFlight(flight);
        booking.setBookingPerson(user);
        booking.setSeatList(seatsToBook);
        booking.setFinalAmount(4234.56);
        booking.setCreatedTime(LocalDateTime.now());
        booking.setBookingStatus(BookingStatus.CONFIRMED);

        bookings.add(booking);

        return booking;

    }

    private User findAndValidateUser(int userId) {

        //logic for getting the user from the list will be put here , but for the time being eveytime a new user is returned
        return new User(userId, "gimickEmail@bluff.com", "Alok verma", "3244234242");
    }

    private Flight findFlightById(int flightId) {
        return flightService.getFlights().stream()
                .filter(f -> f.getId() == flightId)
                .findFirst().orElse(null);
    }

    private Seat findSeat(Flight flight, String seatumber){
        return flight.getSeatList().stream()
                .filter(s -> s.getSeatNumber().equals(seatumber))
                .findFirst()
                .orElse(null);
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
