package errorcode.backend.controller;

import errorcode.backend.domain.entity.User;
import errorcode.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody User user){
        return userService.signUp(user);
    }
}
