package star.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users_projects")
public class UsersProject extends EntityWithRelation {
    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private Long userId;
}
