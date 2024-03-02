package star.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import star.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
