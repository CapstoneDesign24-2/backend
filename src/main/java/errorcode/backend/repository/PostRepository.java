package errorcode.backend.repository;

import errorcode.backend.domain.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    Post findByIdAndUserId(String postId, String userId);
}
