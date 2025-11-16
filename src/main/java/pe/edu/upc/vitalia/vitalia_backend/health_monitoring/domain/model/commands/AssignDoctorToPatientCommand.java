package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.commands;

public record AssignDoctorToPatientCommand(Long patientId, Long doctorId) {}
