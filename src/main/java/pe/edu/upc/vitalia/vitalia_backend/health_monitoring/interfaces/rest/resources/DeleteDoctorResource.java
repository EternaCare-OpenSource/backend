package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.commands.DeleteDoctorCommand;

public record DeleteDoctorResource(Long id) {

    public DeleteDoctorCommand toCommand() {
        return new DeleteDoctorCommand(id);
    }
}