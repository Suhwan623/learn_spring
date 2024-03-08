package kr.hs.gbsw.tree.article.dto;

import lombok.Getter;


@Getter
public class UpdateCommentDto {
    private String content;
    private String author;
    private String password;
}
