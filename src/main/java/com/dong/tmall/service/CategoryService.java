package com.dong.tmall.service;

import com.dong.tmall.pojo.Category;
import com.dong.tmall.util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();
    void add(Category category);
    void delete(int id);
    Category get(int id);
    void update(Category category);

}
