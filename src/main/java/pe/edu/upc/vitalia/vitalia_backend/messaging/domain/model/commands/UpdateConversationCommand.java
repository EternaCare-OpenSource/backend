package pe.edu.upc.vitalia.vitalia_backend.messaging.domain.model.commands;

public record UpdateConversationCommand(Long id, Long doctorId, Long patientId) {}
