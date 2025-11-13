package pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands;

public record CreateMessageCommand(
        Long conversationId,
        Long senderId,
        String senderName,
        Long receiverId,
        String receiverName,
        String subject,
        String content
) {}
