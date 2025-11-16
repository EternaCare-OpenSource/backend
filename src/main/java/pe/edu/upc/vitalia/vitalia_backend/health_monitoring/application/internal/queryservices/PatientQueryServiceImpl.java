package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.application.internal.queryservices;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.aggregates.Patient;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.services.PatientQueryService;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.infrastructure.persistence.jpa.repositories.PatientRepository;

import java.util.*;

@Service @Transactional(readOnly = true) @RequiredArgsConstructor
public class PatientQueryServiceImpl implements PatientQueryService {
    private final PatientRepository repo;
    @Override public List<Patient> getAll(){ return repo.findAll(); }
    @Override public Optional<Patient> getById(Long id){ return repo.findById(id); }
}
