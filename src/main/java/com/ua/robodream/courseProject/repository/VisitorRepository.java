        package com.ua.robodream.courseProject.repository;


        import com.ua.robodream.courseProject.model.Visitor;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Component;
        import org.springframework.stereotype.Repository;

        import java.util.List;

        @Component
        @Repository
        public interface VisitorRepository extends JpaRepository<Visitor, Long> {
            List<Visitor> findByLastName(String lastName);

            Visitor findByPassportNumber(String passportNumber);

        }