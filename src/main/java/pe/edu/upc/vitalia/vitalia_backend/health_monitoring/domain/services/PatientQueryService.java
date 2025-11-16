package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.aggregates.Patient;

import java.util.*;

public interface PatientQueryService {
    List<Patient> getAll();
    Optional<Patient> getById(Long id);
}