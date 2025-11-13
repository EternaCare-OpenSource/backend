package pe.edu.upc.vitalia.vitalia_backend.messaging.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.aggregates.Conversation;
import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands.*;

public interface ConversationCommandService {
    Conversation create(CreateConversationCommand c);
    Conversation update(UpdateConversationCommand c);
    void delete(DeleteConversationCommand c);
}
