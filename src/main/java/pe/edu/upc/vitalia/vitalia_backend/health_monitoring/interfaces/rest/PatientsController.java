// PatientsController.java
package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.commands.DeleteScheduleCommand;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.commands.*;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.services.*;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.resources.*;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.transform.PatientResourceAssembler;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientsController {

    private final PatientCommandService commandService;
    private final PatientQueryService queryService;

    // loadPatients
    @GetMapping
    public ResponseEntity<?> getAll(){
        var list = PatientResourceAssembler.toResourceList(queryService.getAll());
        return ResponseEntity.ok(list);
    }

    // getPatientById
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return queryService.getById(id).map(PatientResource::from)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // addPatient
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreatePatientResource body){
        var created = commandService.create(body.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(PatientResource.from(created));
    }

    // updatePatient
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdatePatientResource body){
        var updated = commandService.update(body.toCommand(id));
        return ResponseEntity.ok(PatientResource.from(updated));
    }

    // deletePatientById
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commandService.delete(new DeletePatientCommand(id));
        return ResponseEntity.noContent().build();
    }


    // assignDoctorToPatient
    @PostMapping("/{patientId}/assign-doctor/{doctorId}")
    public ResponseEntity<?> assignDoctor(@PathVariable Long patientId, @PathVariable Long doctorId){
        var updated = commandService.assignDoctor(new AssignDoctorToPatientCommand(patientId, doctorId));
        return ResponseEntity.ok(PatientResource.from(updated));
    }

    // assignDoctorsToPatients (bulk)
    @PostMapping("/assignments")
    public ResponseEntity<?> assignDoctorsBulk(@RequestBody AssignDoctorsToPatientsResource body){
        var results = body.assignments().stream()
                .map(it -> commandService.assignDoctor(new AssignDoctorToPatientCommand(it.patientId(), it.doctorId())))
                .map(PatientResource::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
}
