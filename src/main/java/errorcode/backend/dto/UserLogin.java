package errorcode.backend.dto;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
public class UserLogin {
    private String loginId;
    private String password;
}
