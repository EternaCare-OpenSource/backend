package pe.edu.upc.vitalia.vitalia_backend.appointments.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.commands.DeleteAppointmentCommand;

public record DeleteAppointmentResource(Long id) {
    public DeleteAppointmentCommand toCommand() {
        return new DeleteAppointmentCommand(id);
    }
}