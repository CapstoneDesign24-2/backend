package errorcode.backend.service;

import errorcode.backend.converter.PostConverter;
import errorcode.backend.domain.entity.Post;
import errorcode.backend.dto.PostRequestDTO;
import errorcode.backend.repository.PostRepository;
import errorcode.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public Post save(PostRequestDTO.CreatePostDTO request) {
//        if(!userRepository.existsById(post.getUser_id())){
//            return null;
//        }

        return postRepository.save(PostConverter.toPost(request));
    }

    public Post getPost(String postId, String userId) {
        return postRepository.findByIdAndUserId(postId, userId);
    }
}
