package errorcode.backend.service;

import errorcode.backend.domain.entity.Post;
import errorcode.backend.repository.PostRepository;
import errorcode.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    public Post save(Post post) {
        if(userRepository.existsById(post.getUser_id())){
            return postRepository.save(post);
        }
        return null;
    }
}
