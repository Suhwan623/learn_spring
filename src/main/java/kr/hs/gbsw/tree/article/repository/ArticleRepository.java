package kr.hs.gbsw.tree.article.repository;

import kr.hs.gbsw.tree.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ArticleRepository extends JpaRepository<Article, Integer>{
}
