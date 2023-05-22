        package com.ua.robodream.courseProject.repository;

        import com.ua.robodream.courseProject.model.Room;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Repository;

        @Component
        @Repository
        public interface RoomRepository extends JpaRepository<Room, Long> {
            Room findByNumber(int number);
        }