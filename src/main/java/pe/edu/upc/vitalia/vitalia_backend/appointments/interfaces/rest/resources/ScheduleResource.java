package pe.edu.upc.vitalia.vitalia_backend.appointments.interfaces.rest.resources;

import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.aggregates.Schedule;

import java.time.LocalTime;

public record ScheduleResource(
        Long id,
        Long doctorId,
        String dayOfWeek,
        LocalTime startTime,
        LocalTime endTime,
        Boolean isAvailable,
        java.util.Date createdAt,
        java.util.Date updatedAt
) {
    public static ScheduleResource fromEntity(Schedule s) {
        return new ScheduleResource(
                s.getId(), s.getDoctorId(), s.getDayOfWeek(),
                s.getStartTime(), s.getEndTime(), s.getIsAvailable(),
                s.getCreatedAt(), s.getUpdatedAt()
        );
    }
}
