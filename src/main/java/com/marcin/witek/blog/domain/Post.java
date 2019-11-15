/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    @ManyToOne
    private Category category;

    @NotNull
    @ManyToOne
    private User author;

    @NotNull
    private Date date;

}
