package pe.edu.upc.vitalia.vitalia_backend.messaging.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.aggregates.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {}