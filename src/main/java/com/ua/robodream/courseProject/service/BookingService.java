package com.ua.robodream.courseProject.service;

import com.ua.robodream.courseProject.model.Booking;
import com.ua.robodream.courseProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@ComponentScan
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking bookRoom(Booking booking) {
        if (booking.getRoom().isAvailable()) {
            LocalDateTime endTime = LocalDateTime.now().plusMinutes(booking.getDurationMinutes());
            booking.setEndTime(endTime);
            booking.getRoom().setAvailable(false);
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Кімната вже заброньована.");
        }
    }

    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) {
            booking.getRoom().setAvailable(true);
            bookingRepository.deleteById(bookingId);
        } else {
            throw new RuntimeException("Бронювання не знайдено.");
        }
    }
}