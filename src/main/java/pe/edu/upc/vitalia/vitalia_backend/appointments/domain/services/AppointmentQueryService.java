package pe.edu.upc.vitalia.vitalia_backend.appointments.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.aggregates.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentQueryService {
    List<Appointment> getAll();
    Optional<Appointment> getById(Long id);
}