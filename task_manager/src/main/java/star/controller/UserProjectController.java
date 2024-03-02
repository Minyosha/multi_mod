package star.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import star.repositories.ProjectRepository;
import star.repositories.UserRepository;
import star.repositories.UsersProjectRepository;

import java.util.List;

@Controller
public class UserProjectController {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final UsersProjectRepository usersProjectRepository;

    @Autowired
    public UserProjectController(ProjectRepository projectRepository, UserRepository userRepository,
                                 UsersProjectRepository usersProjectRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.usersProjectRepository = usersProjectRepository;
    }


    public ResponseEntity<List> getUsersByProjectId (Long projectId) {
        return ResponseEntity.ok(usersProjectRepository.getUsersByProjectId(projectId));
    }

    public ResponseEntity<List> getProjectsByUserId (Long userId) {
        return ResponseEntity.ok(usersProjectRepository.getProjectsByUserId(userId));
    }

    public ResponseEntity addUserToProject(Long userId, Long projectId) {
        usersProjectRepository.addUserToProject(userId, projectId);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity removeUserFromProject(Long userId, Long projectId) {
        usersProjectRepository.removeUserFromProject(userId, projectId);
        return ResponseEntity.ok().build();
    }


}
