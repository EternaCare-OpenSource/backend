package pe.edu.upc.vitalia.vitalia_backend.iam.infrastructure.bootstrap;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pe.edu.upc.vitalia.vitalia_backend.iam.domain.model.aggregates.Role;
import pe.edu.upc.vitalia.vitalia_backend.iam.domain.model.aggregates.User;
import pe.edu.upc.vitalia.vitalia_backend.iam.domain.model.entities.RoleName;
import pe.edu.upc.vitalia.vitalia_backend.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import pe.edu.upc.vitalia.vitalia_backend.iam.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final RoleRepository roleRepo;
    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        var adminRole = roleRepo.findByName(RoleName.ADMIN).orElseGet(() -> roleRepo.save(new Role(RoleName.ADMIN)));
        var doctorRole = roleRepo.findByName(RoleName.DOCTOR).orElseGet(() -> roleRepo.save(new Role(RoleName.DOCTOR)));
        var patientRole = roleRepo.findByName(RoleName.PATIENT).orElseGet(() -> roleRepo.save(new Role(RoleName.PATIENT)));

        if (userRepo.findByEmail("admin@vitalia.com").isEmpty()) {
            var u = new User("Admin", "Root", "admin@vitalia.com", encoder.encode("admin123"));
            u.setRoles(Set.of(adminRole));
            userRepo.save(u);
        }
        if (userRepo.findByEmail("doctor@vitalia.com").isEmpty()) {
            var u = new User("Ana", "Soto", "doctor@vitalia.com", encoder.encode("doctor123"));
            u.setRoles(Set.of(doctorRole));
            userRepo.save(u);
        }
        if (userRepo.findByEmail("patient@vitalia.com").isEmpty()) {
            var u = new User("Juan", "Gonzales", "patient@vitalia.com", encoder.encode("patient123"));
            u.setRoles(Set.of(patientRole));
            userRepo.save(u);
        }
    }
}
