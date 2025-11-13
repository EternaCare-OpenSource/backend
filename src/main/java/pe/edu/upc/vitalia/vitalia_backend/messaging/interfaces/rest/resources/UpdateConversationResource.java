package pe.edu.upc.vitalia.vitalia_backend.messaging.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands.UpdateConversationCommand;

public record UpdateConversationResource(
        Long doctorId,
        Long patientId
){
    public UpdateConversationCommand toCommand(Long id) {
        return new UpdateConversationCommand(id, doctorId, patientId);
    }
}