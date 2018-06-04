package com.dong.tmall.service.impl;

import com.dong.tmall.mapper.CategoryMapper;
import com.dong.tmall.pojo.Category;
import com.dong.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> list(){
        return categoryMapper.list();
    };
}
