package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.transform;

import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.aggregates.Doctor;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.resources.DoctorResource;

import java.util.List;

public class DoctorResourceAssembler {
    public static DoctorResource toResource(Doctor doctor) {
        return DoctorResource.from(doctor);
    }

    public static List<DoctorResource> toResourceList(List<Doctor> doctors) {
        return doctors.stream().map(DoctorResource::from).toList();
    }
}