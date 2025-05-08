package likelion13th.blog.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdAt;


    public Article(String content, Long id, String title, String author, String password) {
        this.content = content;
        this.id = id;
        this.title = title;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }

    public String getContent() {return content;}

    public LocalDateTime getCreatedAt(){return createdAt;}

    public Long getId(){return id;}

    public String getTitle(){return title;}

    public String getAuthor(){return author;}

    public String getPassword(){return password;}
}