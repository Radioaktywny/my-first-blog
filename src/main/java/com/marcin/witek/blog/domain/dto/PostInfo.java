/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostInfo {

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String text;

}
