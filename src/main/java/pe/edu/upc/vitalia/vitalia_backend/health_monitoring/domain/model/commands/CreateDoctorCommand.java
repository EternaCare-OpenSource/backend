package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.commands;

public record CreateDoctorCommand(String firstName, String lastName, String email,
                                  String specialization, String cmpCode,
                                  String studyCentre, String phoneNumber) {}