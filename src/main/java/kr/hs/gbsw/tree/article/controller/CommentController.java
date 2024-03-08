package kr.hs.gbsw.tree.article.controller;

import kr.hs.gbsw.tree.article.dto.CreateCommentDto;
import kr.hs.gbsw.tree.article.dto.DeleteCommentDto;
import kr.hs.gbsw.tree.article.dto.UpdateCommentDto;
import kr.hs.gbsw.tree.article.model.Comment;
import kr.hs.gbsw.tree.article.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/articles")
@AllArgsConstructor
public class CommentController {
    private CommentService commentService;

    @GetMapping("/{articleId}/comments")
    public Comment getComments(
            @PathVariable int articleId,
            @RequestBody CreateCommentDto dto
    ){
        return commentService.createComment(articleId,dto);
    }
    @PostMapping("/{articleId}/comments")
    public Comment createComments(
            @PathVariable int articleId,
            @RequestBody CreateCommentDto dto
    ){
        return commentService.createComment(articleId,dto);
    }

    @PutMapping("/coments/{id}")
    public Comment updateComment(
            @PathVariable int id,
            @RequestBody UpdateCommentDto dto
    ){
        Comment comment = commentService.updateComment(id,dto);
        return comment;
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(
            @PathVariable int id,
            @RequestBody DeleteCommentDto dto
    ){
        commentService.deleteComment(id,dto.getPassword());
    }

}
