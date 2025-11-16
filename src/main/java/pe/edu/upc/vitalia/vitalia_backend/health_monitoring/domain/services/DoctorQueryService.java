package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.aggregates.Doctor;

import java.util.*;

public interface DoctorQueryService {
    List<Doctor> getAll();
    Optional<Doctor> getById(Long id);
}
