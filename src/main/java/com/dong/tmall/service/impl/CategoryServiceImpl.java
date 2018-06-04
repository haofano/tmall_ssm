package com.dong.tmall.service.impl;

import com.dong.tmall.mapper.CategoryMapper;
import com.dong.tmall.pojo.Category;
import com.dong.tmall.service.CategoryService;
import com.dong.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list(Page page){
        return categoryMapper.list(page);
    }

    @Override
    public int total(){
        return categoryMapper.total();
    }
    @Override
    public void add(Category category){
        categoryMapper.add(category);
    }
}
