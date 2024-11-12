package errorcode.backend.service;

import errorcode.backend.domain.entity.Post;
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

    public Post save(Post post) {
//        if(!userRepository.existsById(post.getUser_id())){
//            return null;
//        }
        return postRepository.save(post);
    }

    public Post findById(String post_id) {
        return postRepository.findById(post_id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다"));
    }
}
