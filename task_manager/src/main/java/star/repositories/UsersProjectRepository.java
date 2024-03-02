package star.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import star.model.UsersProject;

import java.util.List;

@Repository
public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
    List getUsersByProjectId(Long projectId);

    List getProjectsByUserId(Long userId);

    void addUserToProject(Long userId, Long projectId);

    void removeUserFromProject(Long userId, Long projectId);

    UsersProject findByUserIdAndProjectId(Long userId, Long projectId);
}
