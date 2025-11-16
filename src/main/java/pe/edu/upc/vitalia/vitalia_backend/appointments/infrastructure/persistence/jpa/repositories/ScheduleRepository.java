package pe.edu.upc.vitalia.vitalia_backend.appointments.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.aggregates.Schedule;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findByDoctorId(Long doctorId);
    List<Schedule> findByDoctorIdAndDayOfWeek(Long doctorId, String dayOfWeek);
}
