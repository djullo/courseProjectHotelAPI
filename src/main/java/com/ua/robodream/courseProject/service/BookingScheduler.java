package com.ua.robodream.courseProject.service;

import com.ua.robodream.courseProject.model.Booking;
import com.ua.robodream.courseProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BookingScheduler {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingScheduler(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Scheduled(fixedRate = 60000) // Перевіряти кожну хвилину
    public void checkExpiredBookings() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        List<Booking> expiredBookings = bookingRepository.findByEndTimeBeforeAndRoomAvailableFalse(currentDateTime);
        for (Booking booking : expiredBookings) {
            booking.getRoom().setAvailable(true);
            bookingRepository.deleteById(booking.getId());
        }
    }
}