package errorcode.backend.converter;

import errorcode.backend.domain.entity.Post;
import errorcode.backend.dto.PostRequestDTO;

public class PostConverter {
    public static Post toPost(PostRequestDTO.CreatePostDTO createPostDTO) {
        return Post.builder()
                .userId(createPostDTO.getUserId())
                .title(createPostDTO.getTitle())
                .content(createPostDTO.getContent())
                .status(createPostDTO.getStatus())
                .build();
    }
}
