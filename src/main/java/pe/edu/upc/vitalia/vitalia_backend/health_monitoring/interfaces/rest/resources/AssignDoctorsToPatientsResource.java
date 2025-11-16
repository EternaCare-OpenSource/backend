package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.resources;

import java.util.List;
public record AssignDoctorsToPatientsResource(List<Item> assignments) {
    public record Item(Long patientId, Long doctorId) {}
}