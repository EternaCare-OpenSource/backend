package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.aggregates.Doctor;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findByEmail(String email);
    Optional<Doctor> findByCmpCode(String cmpCode);
}