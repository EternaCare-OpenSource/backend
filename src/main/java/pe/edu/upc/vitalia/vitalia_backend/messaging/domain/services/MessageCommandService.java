package pe.edu.upc.vitalia.vitalia_backend.messaging.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.aggregates.Message;
import pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands.*;

public interface MessageCommandService {
    Message create(CreateMessageCommand command);
    Message update(UpdateMessageCommand command);
    void delete(DeleteMessageCommand command);
    Message markAsRead(MarkMessageAsReadCommand command);
}
