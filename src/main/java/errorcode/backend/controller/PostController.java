package errorcode.backend.controller;

import errorcode.backend.apipayload.ApiResponse;
import errorcode.backend.domain.entity.Post;
import errorcode.backend.dto.PostRequestDTO;
import errorcode.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ApiResponse createPost(@RequestBody PostRequestDTO.CreatePostDTO request) {
        return ApiResponse.onSuccess(postService.save(request));
    }

    @GetMapping
    public ApiResponse<Post> getPost(@RequestParam String postId,
                                     @RequestParam String userId){
        return ApiResponse.onSuccess(postService.getPost(postId, userId));
    }


}
