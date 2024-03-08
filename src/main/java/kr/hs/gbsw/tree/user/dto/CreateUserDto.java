package kr.hs.gbsw.tree.user.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CreateUserDto {
    private String id;
    private String password;
    private String name;
    private String email;
}
