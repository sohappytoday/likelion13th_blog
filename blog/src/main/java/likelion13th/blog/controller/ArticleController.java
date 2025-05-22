package likelion13th.blog.controller;

import likelion13th.blog.dto.AddArticleRequest;
import likelion13th.blog.dto.ApiResponse;
import likelion13th.blog.dto.ArticleResponse;
import likelion13th.blog.dto.SimpleArticleResponse;
import likelion13th.blog.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/articles")
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping
    public ResponseEntity<ApiResponse> createArticle(@RequestBody AddArticleRequest request){
        ArticleResponse response=articleService.addArticle(request);
        return ResponseEntity.ok(new ApiResponse(true,201,"게시글 등록 성공",response));

    }

    @GetMapping
    public ResponseEntity<ApiResponse> ReadAllArticles(){

        List<SimpleArticleResponse> articles=articleService.getAllArticles();
        return ResponseEntity.ok(new ApiResponse(true, 200, "게시글 조회 성공", articles));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> ReadArticle(@PathVariable long id){
        ArticleResponse response=articleService.getArticle(id);
        return ResponseEntity.ok(new ApiResponse(true,200,"게시글 조회 성공", response));

    }


}