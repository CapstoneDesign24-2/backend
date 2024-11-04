package errorcode.backend.service;

import errorcode.backend.entity.User;
import errorcode.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public User signUp(User user) {
        return userRepository.save(user);
    }
}
