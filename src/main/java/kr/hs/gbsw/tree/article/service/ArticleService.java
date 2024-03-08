package kr.hs.gbsw.tree.article.service;

import kr.hs.gbsw.tree.article.repository.ArticleRepository;
import kr.hs.gbsw.tree.article.dto.CreateArticleDto;
import kr.hs.gbsw.tree.article.dto.DeleteArticleDto;
import kr.hs.gbsw.tree.article.dto.UpdateArticleDto;
import kr.hs.gbsw.tree.article.model.Article;
import kr.hs.gbsw.tree.user.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository  articleRepository){
        this.articleRepository = articleRepository;
    }

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    public Article getArticle(int id){
        if(articleRepository.existsById(id)){
            return articleRepository.findById(id).orElse(null);
        }
        throw new IllegalArgumentException("게시물이 없습니다.");
    }

    public Article createAricle(User user,CreateArticleDto dto){
        LocalDateTime now = LocalDateTime.now();


        Article article = new Article(
                0,
                dto.getTitle(),
                dto.getContent(),
                dto.getAuthor(),
                dto.getPassword(),
                user,
                new ArrayList<>(),
                now,
                now
        );

        return articleRepository.save(article);
    }

    public Article modifyArticle(int id, User user,UpdateArticleDto dto){
       Article article = getArticle(id);

       if(article.getUser() != null){
           if(user == null){
               throw new IllegalArgumentException("로그인이 필요합니다.");
           }

           if(article.getUser().getId().equals(user.getId())){
               throw new IllegalArgumentException("내 글만 수정 가능합니다.");
           }
        }else{
           if(!article.getPassword().equals(dto.getPassword())){
               throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
           }
       }

       article.setTitle(dto.getTitle());
       article.setContent(dto.getContent());
       article.setAuthor(dto.getAuthor());
       article.setPassword(dto.getPassword());
       article.setUpdatedAt(LocalDateTime.now());

       return articleRepository.save(article);
    }

    public void deleteAricle(int id, User user,DeleteArticleDto dto){
        Article article = getArticle(id);

        if(article.getUser() != null){
            if(user == null){
                throw new IllegalArgumentException("로그인이 필요합니다.");
            }

            if(article.getUser().getId().equals(user.getId())){
                throw new IllegalArgumentException("내 글만 삭제 가능합니다.");
            }
        }else{
            if(!article.getPassword().equals(dto.getPassword())){
                throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
            }
        }

        articleRepository.deleteById(id);
    }

}
