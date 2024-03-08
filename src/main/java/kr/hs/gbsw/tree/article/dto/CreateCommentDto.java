package kr.hs.gbsw.tree.article.dto;

import lombok.Getter;

@Getter
public class CreateCommentDto {
    private String content;
    private String author;
    private String password;
}
