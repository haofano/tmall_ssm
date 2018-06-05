package com.dong.tmall.service.impl;

import com.dong.tmall.mapper.CategoryMapper;
import com.dong.tmall.pojo.Category;
import com.dong.tmall.pojo.CategoryExample;
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
    public List<Category> list(){
        //传递一个example对象，这个对象指定按照id倒排序来查询
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }
    @Override
    public void add(Category category){
        categoryMapper.insert(category);
    }
    @Override
    public void delete(int id){
        categoryMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
    @Override
    public void update(Category category){
        categoryMapper.updateByPrimaryKeySelective(category);
    }
}
