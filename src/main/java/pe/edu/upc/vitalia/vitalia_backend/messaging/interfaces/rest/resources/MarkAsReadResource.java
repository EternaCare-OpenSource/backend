package pe.edu.upc.vitalia.vitalia_backend.messaging.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands.MarkMessageAsReadCommand;

public record MarkAsReadResource(Long id) {
    public MarkMessageAsReadCommand toCommand() {
        return new MarkMessageAsReadCommand(id);
    }
}
