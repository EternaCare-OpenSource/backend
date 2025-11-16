package pe.edu.upc.vitalia.vitalia_backend.appointments.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.commands.DeleteScheduleCommand;

public record DeleteScheduleResource(Long id) {
    public DeleteScheduleCommand toCommand() { return new DeleteScheduleCommand(id); }
}
