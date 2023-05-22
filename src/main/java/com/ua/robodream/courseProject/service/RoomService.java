        package com.ua.robodream.courseProject.service;

        import com.ua.robodream.courseProject.model.Room;
        import com.ua.robodream.courseProject.repository.RoomRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import java.util.Optional;
        import java.util.List;

        @Service
        public class RoomService {
            private final RoomRepository roomRepository;

            @Autowired
            public RoomService(RoomRepository roomRepository) {
                this.roomRepository = roomRepository;
            }

            public List<Room> getAllRooms() {
                return roomRepository.findAll();
            }

            public Room getRoomById(Long id) {
                Optional<Room> optionalRoom = roomRepository.findById(id);
                return optionalRoom.orElse(null);
            }

            public Room saveRoom(Room room) {
                return roomRepository.save(room);
            }

            public void deleteRoom(Long id) {
                roomRepository.deleteById(id);
            }

            public Room getRoomByNumber(int number) {
                return roomRepository.findByNumber(number);
            }
        }