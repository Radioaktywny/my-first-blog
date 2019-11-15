/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String name;

    @NotNull
    private String password;

    @Enumerated
    @NotNull
    private Role role;

}
