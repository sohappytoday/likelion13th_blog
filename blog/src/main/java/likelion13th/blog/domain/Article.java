package likelion13th.blog.domain;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id // id 필드를 기본키(Primary Key)로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(updatable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int commentCount;

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void increaseCommentCount() {
        commentCount++;
    }
    public void decreaseCommentCount() {
        if(commentCount>0) commentCount--;
    }
}
