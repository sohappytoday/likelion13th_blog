package  likelion13th.blog.service;
import jakarta.persistence.EntityNotFoundException;
import likelion13th.blog.domain.Article;
import likelion13th.blog.dto.AddArticleRequest;
import likelion13th.blog.dto.ArticleResponse;
import likelion13th.blog.dto.SimpleArticleResponse;
import likelion13th.blog.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleResponse addArticle(AddArticleRequest request){
        //request 객체의 .toEntity()를 통해 Article 객체 생성
        Article article=request.toEntity();

        //Article객체를 JPA의 save() 를 사용하여 DB에 저장
        articleRepository.save(article);

        // article 객체를 response DTO 생성하여 반환
        //  response 클래스의 정작 팩토리 메서드 of() 통해 API 응답객체 생성
        return ArticleResponse.of(article);
    }
    public List<SimpleArticleResponse> getAllArticles(){
        List<Article> articleList = articleRepository.findAll();

        List<SimpleArticleResponse> articleResponseList = articleList.stream()
                .map(article -> SimpleArticleResponse.of(article))
                .toList();

        return articleResponseList;
    }
    public ArticleResponse getArticle(Long id){
        Article article = articleRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("해당 ID의 게시글을 찾을 수 없습니다. ID: "+id));

        return ArticleResponse.of(article);
    }
}
