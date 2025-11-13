package pe.edu.upc.vitalia.vitalia_backend.iam.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.*;
import pe.edu.upc.vitalia.vitalia_backend.iam.domain.model.entities.RoleName;

@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName name;

    public Role(RoleName name) { this.name = name; }
}
