package errorcode.backend.service;

import errorcode.backend.domain.entity.User;
import errorcode.backend.dto.UserLogin;
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
    public User login(UserLogin userLogin) {return userRepository.findByLoginIdAndPassword(userLogin.getLoginId(), userLogin.getPassword());}

    public Boolean duplicateId(String userId){
        if(userRepository.findById(userId).isPresent()){
            return true;
        }
        return false;
    }

    public Boolean duplicateNickname(String nickname){
        if(userRepository.findByNickname(nickname).isPresent()){
            return true;
        }
        return false;
    }
}
