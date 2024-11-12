package errorcode.backend.controller;

import errorcode.backend.apipayload.ApiResponse;
import errorcode.backend.domain.entity.Post;
import errorcode.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ApiResponse createPost(@RequestBody Post post) {
        return ApiResponse.onSuccess(postService.save(post));
    }

    @GetMapping("/{post_id}")
    public ApiResponse<Post> getPost(@RequestParam String post_id){
        return ApiResponse.onSuccess(postService.findById(post_id));
    }


}
