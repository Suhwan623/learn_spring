package kr.hs.gbsw.tree.article.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kr.hs.gbsw.tree.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private String author;
    @JsonIgnore
    private String password;
    @ManyToOne
    private User user;
    @JsonIgnore
    @OneToMany(mappedBy = "article",cascade = {CascadeType.REMOVE})
    private List<Comment> comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
