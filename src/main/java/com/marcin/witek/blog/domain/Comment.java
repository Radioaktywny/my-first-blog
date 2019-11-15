/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User author;

    @NotNull
    private String nickName;

    @NotNull
    private String content;

    @NotNull
    @ManyToOne
    private Post post;

    @NotNull
    private Date date;

}
