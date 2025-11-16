package pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.vitalia.vitalia_backend.appointments.domain.model.commands.DeleteScheduleCommand;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.model.commands.*;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.domain.services.*;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.resources.*;
import pe.edu.upc.vitalia.vitalia_backend.health_monitoring.interfaces.rest.transform.DoctorResourceAssembler;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/doctors")
@RequiredArgsConstructor
public class DoctorsController {

    private final DoctorCommandService commandService;
    private final DoctorQueryService queryService;

    // loadDoctors
    @GetMapping
    public ResponseEntity<?> getAll(){
        var list = DoctorResourceAssembler.toResourceList(queryService.getAll());
        return ResponseEntity.ok(list);
    }

    // getDoctorById
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return queryService.getById(id).map(DoctorResource::from)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // addDoctor
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateDoctorResource body){
        var created = commandService.create(body.toCommand());
        return ResponseEntity.status(HttpStatus.CREATED).body(DoctorResource.from(created));
    }

    // updateDoctor
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody UpdateDoctorResource body){
        var updated = commandService.update(body.toCommand(id));
        return ResponseEntity.ok(DoctorResource.from(updated));
    }

    // deleteDoctorById
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        commandService.delete(new DeleteDoctorCommand(id));
        return ResponseEntity.noContent().build();
    }

}
