package pe.edu.upc.vitalia.vitalia_backend.messaging.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands.UpdateMessageCommand;

public record UpdateMessageResource(
        String subject,
        String content
) {
    public UpdateMessageCommand toCommand(Long id) {
        return new UpdateMessageCommand(id, subject, content);
    }
}
