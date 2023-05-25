    package com.ua.robodream.courseProject.repository;

    import com.ua.robodream.courseProject.model.Booking;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Component;
    import org.springframework.stereotype.Repository;

    import java.time.LocalDateTime;
    import java.util.List;

    @Component
    @Repository
    public interface BookingRepository extends JpaRepository<Booking, Long> {

        List<Booking> findByEndTimeBeforeAndRoomAvailableFalse(LocalDateTime currentDateTime);
    }