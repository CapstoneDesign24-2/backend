package errorcode.backend.controller;

import errorcode.backend.apipayload.ApiResponse;
import errorcode.backend.apipayload.code.status.ErrorStatus;
import errorcode.backend.apipayload.code.status.SuccessStatus;
import errorcode.backend.domain.entity.User;
import errorcode.backend.dto.UserLogin;
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

    @PostMapping("/login")
    public User login(@RequestBody UserLogin userLogin){return userService.login(userLogin);}

    @GetMapping("/duplicate/id")
    public ApiResponse duplicateId(@RequestParam("userId") String userId){
        if(userService.duplicateId(userId)){
            return ApiResponse.onFailure(ErrorStatus.USER_ID_DUPLICATE_ERROR.getCode(), ErrorStatus.USER_ID_DUPLICATE_ERROR.getMessage(), "fail");
        }
        return ApiResponse.onSuccess(SuccessStatus._OK) ;
    }

    @GetMapping("/duplicate/nickname")
    public ApiResponse duplicateNickname(@RequestParam("nickname") String nickname){
        if(userService.duplicateNickname(nickname)){
            return ApiResponse.onFailure(ErrorStatus.USER_NICKNAME_DUPLICATE_ERROR.getCode(), ErrorStatus.USER_NICKNAME_DUPLICATE_ERROR.getMessage(), "fail");
        }
        return ApiResponse.onSuccess(SuccessStatus._OK) ;
    }
}
