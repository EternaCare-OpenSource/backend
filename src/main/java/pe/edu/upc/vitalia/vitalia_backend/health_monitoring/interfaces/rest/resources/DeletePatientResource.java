package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.commands.DeletePatientCommand;

public record DeletePatientResource(Long id) {

    public DeletePatientCommand toCommand() {
        return new DeletePatientCommand(id);
    }
}