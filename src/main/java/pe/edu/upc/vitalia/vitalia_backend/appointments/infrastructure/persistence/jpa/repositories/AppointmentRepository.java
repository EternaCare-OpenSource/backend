package pe.edu.upc.vitalia.vitalia_backend.appointments.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.aggregates.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {}