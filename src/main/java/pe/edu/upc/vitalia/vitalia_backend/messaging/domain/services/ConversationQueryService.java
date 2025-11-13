package pe.edu.upc.vitalia.vitalia_backend.messaging.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.aggregates.Conversation;

import java.util.List;
import java.util.Optional;

public interface ConversationQueryService {
    List<Conversation> getAll();
    Optional<Conversation> getById(Long id);
}