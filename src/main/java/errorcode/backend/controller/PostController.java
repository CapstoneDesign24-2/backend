package errorcode.backend.controller;

import errorcode.backend.apipayload.ApiResponse;
import errorcode.backend.domain.entity.Post;
import errorcode.backend.dto.PostRequestDTO;
import errorcode.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/{postId}/{userId}")
    public ApiResponse<Post> getPost(@PathVariable("postId") String postId,
                                     @PathVariable("userId") String userId){
        return ApiResponse.onSuccess(postService.getPost(postId, userId));
    }

    @GetMapping
    public ApiResponse<Page<Post>> getPosts(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size){
        return ApiResponse.onSuccess(postService.getPosts(page, size));
    }

}
