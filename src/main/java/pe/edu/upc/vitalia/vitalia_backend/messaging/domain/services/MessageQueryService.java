package pe.edu.upc.vitalia.vitalia_backend.messaging.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.aggregates.Message;

import java.util.List;
import java.util.Optional;

public interface MessageQueryService {
    List<Message> getAll();
    Optional<Message> getById(Long id);
    List<Message> getByConversation(Long conversationId);
}
