package barber.project.barber.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import barber.project.barber.model.Barber;

public interface BarberRepository extends JpaRepository<Barber, Long> {
    
}
