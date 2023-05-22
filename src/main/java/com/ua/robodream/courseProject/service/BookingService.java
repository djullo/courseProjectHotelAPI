package com.ua.robodream.courseProject.service;

import com.ua.robodream.courseProject.model.Booking;
import com.ua.robodream.courseProject.repository.BookingRepository;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@ComponentScan
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(EntityManagerFactory entityManagerFactory, BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking bookRoom(Booking booking) { // Перевірка доступності кімнати для бронювання
        if (booking.getRoom().isAvailable()) { // Логіка для бронювання номера
            booking.getRoom().setAvailable(false); // Позначаємо кімнату як недоступну
            return bookingRepository.save(booking);
        } else {
            throw new RuntimeException("Кімната вже заброньована.");
        }
    }

    public void cancelBooking(Long bookingId) { // Перевірка наявності бронювання
        Booking booking = (Booking) bookingRepository.findById(bookingId).orElse(null);
        if (booking != null) { // Логіка для скасування бронювання
            booking.getRoom().setAvailable(true); // Позначаємо кімнату як доступну
            bookingRepository.deleteById(bookingId);
        } else {
            throw new RuntimeException("Бронювання не знайдено.");
        }
    }
}