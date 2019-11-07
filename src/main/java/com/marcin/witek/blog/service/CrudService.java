/*
 * Copyright (c) 2019
 * Marcin Witek
 */

package com.marcin.witek.blog.service;

import java.util.List;

public interface CrudService<T> {
    T oddOrUpdate(T post);

    void delete(Long id);

    T getOne(Long id);

    List<T> getAll();
}
