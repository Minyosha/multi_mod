package star.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "entity_with_relation")
public abstract class EntityWithRelation {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long relatedEntityId;

}
