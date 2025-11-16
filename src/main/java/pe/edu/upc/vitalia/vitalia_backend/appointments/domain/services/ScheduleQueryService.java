package pe.edu.upc.vitalia.vitalia_backend.appointments.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.aggregates.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleQueryService {
    List<Schedule> getAll();
    Optional<Schedule> getById(Long id);
}
