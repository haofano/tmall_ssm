package com.dong.tmall.mapper;

import com.dong.tmall.pojo.Category;
import com.dong.tmall.util.Page;

import java.util.List;

public interface CategoryMapper {
    public List<Category> list(Page page);

    public int total();

    void add(Category category);
}
