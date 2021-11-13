package com.board.portfolio.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"email", "nickname"}
                )
        }
)
@Getter @Setter
public class Member {
    public Member() {

    }

    public Member(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String nickname;


}
