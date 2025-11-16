package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.aggregates.Patient;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
    Optional<Patient> findByPatientId(String patientId);
}