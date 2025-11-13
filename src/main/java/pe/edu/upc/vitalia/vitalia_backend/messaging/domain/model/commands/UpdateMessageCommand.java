package pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands;

public record UpdateMessageCommand(
        Long id,
        String subject,
        String content
) {}
