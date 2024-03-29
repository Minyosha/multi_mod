package star.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import star.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
