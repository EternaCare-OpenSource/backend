package pe.edu.upc.vitalia.vitalia_backend.appointments.domain.services;

import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.aggregates.Schedule;
import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.commands.CreateScheduleCommand;
import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.commands.UpdateScheduleCommand;
import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.commands.DeleteScheduleCommand;

public interface ScheduleCommandService {
    Schedule create(CreateScheduleCommand command);
    Schedule update(UpdateScheduleCommand command);
    void delete(DeleteScheduleCommand command);
}
