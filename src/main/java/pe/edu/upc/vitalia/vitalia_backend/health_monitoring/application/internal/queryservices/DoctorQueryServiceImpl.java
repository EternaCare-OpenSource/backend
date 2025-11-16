package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.application.internal.queryservices;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.aggregates.Doctor;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.services.DoctorQueryService;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.infrastructure.persistence.jpa.repositories.DoctorRepository;

import java.util.*;

@Service @Transactional(readOnly = true) @RequiredArgsConstructor
public class DoctorQueryServiceImpl implements DoctorQueryService {
    private final DoctorRepository repo;
    @Override public List<Doctor> getAll(){ return repo.findAll(); }
    @Override public Optional<Doctor> getById(Long id){ return repo.findById(id); }
}
