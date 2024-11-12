package errorcode.backend.repository;

import errorcode.backend.domain.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByLoginIdAndPassword(String login_id, String password);
    Optional<User> findByNickname(String nickname);
}