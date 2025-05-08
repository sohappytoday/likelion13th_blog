package likelion13th.blog.controller;

import likelion13th.blog.domain.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final List<Article> articleDB = new ArrayList<>();
    private Long nextId = 1L;

    @PostMapping()
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        Article newArticle = new Article(
                article.getContent(),
                nextId++,
                article.getTitle(),
                article.getAuthor(),
                article.getPassword()
        );
        articleDB.add(newArticle);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newArticle);
    }
    @GetMapping
    public ResponseEntity<List<Article>> getArticle(){
        return ResponseEntity.status(HttpStatus.OK).body(articleDB);
    }
}
