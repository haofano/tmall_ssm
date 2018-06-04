package com.dong.tmall.service;

import com.dong.tmall.pojo.Category;
import com.dong.tmall.util.Page;

import java.util.List;

public interface CategoryService {
    int total();
    List<Category> list(Page page);
    void add(Category category);
}
