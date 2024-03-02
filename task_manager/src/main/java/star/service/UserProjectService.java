package star.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import star.repositories.ProjectRepository;
import star.repositories.UserRepository;
import star.repositories.UsersProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersProjectRepository usersProjectRepository;

    public List getUsersByProjectId(Long projectId) {
        return usersProjectRepository.getUsersByProjectId(projectId);
    }

    public List getProjectsByUserId(Long userId) {
        return usersProjectRepository.getProjectsByUserId(userId);
    }

    public void addUserToProject(Long userId, Long projectId) {
        usersProjectRepository.addUserToProject(userId, projectId);
    }

    public void removeUserFromProject(Long userId, Long projectId) {
        usersProjectRepository.removeUserFromProject(userId, projectId);
    }
}
