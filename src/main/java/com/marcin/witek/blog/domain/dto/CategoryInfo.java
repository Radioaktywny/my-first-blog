/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.domain.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryInfo {

    private Long id;

    @NotNull
    private String name;

}
