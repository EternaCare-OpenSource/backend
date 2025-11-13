package pe.edu.upc.vitalia.vitalia_backend.messaging.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands.DeleteMessageCommand;

public record DeleteMessageResource(Long id) {
    public DeleteMessageCommand toCommand() {
        return new DeleteMessageCommand(id);
    }
}
