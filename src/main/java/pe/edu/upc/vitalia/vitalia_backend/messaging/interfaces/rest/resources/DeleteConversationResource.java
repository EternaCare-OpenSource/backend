package pe.edu.upc.vitalia.vitalia_backend.messaging.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands.DeleteConversationCommand;

public record DeleteConversationResource(Long id) {
    public DeleteConversationCommand toCommand(){ return new DeleteConversationCommand(id); }
}