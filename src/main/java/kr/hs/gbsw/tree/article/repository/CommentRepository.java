package kr.hs.gbsw.tree.article.repository;

import kr.hs.gbsw.tree.article.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByArticleId(int articleId);
}
