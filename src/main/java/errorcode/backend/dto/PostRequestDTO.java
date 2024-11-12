package errorcode.backend.dto;

import lombok.Getter;

@Getter
public class PostRequestDTO {
    @Getter
    public static class CreatePostDTO{
        private String userId;
        private String title;
        private String content;
        private String status;
    }
}
