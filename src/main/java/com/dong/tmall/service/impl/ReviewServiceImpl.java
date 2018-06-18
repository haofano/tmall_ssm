package com.dong.tmall.service.impl;

import com.dong.tmall.mapper.ReviewMapper;
import com.dong.tmall.pojo.Review;
import com.dong.tmall.pojo.ReviewExample;
import com.dong.tmall.pojo.User;
import com.dong.tmall.service.ReviewService;
import com.dong.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    UserService userService;

    @Override
    public void add(Review c) {
        reviewMapper.insert(c);
    }

    @Override
    public void delete(int id) {
        reviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Review c) {
        reviewMapper.updateByPrimaryKeySelective(c);
    }

    @Override
    public Review get(int id) {
        return reviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public List list(int pid) {
        ReviewExample example = new ReviewExample();
        example.createCriteria().andPidEqualTo(pid);
        example.setOrderByClause("id desc");

        List<Review> result = reviewMapper.selectByExample(example);
        setUser(result);
        return result;
    }

    public void setUser(List<Review> reviews){
        for(Review review : reviews)
            setUser(review);
    }

    private void setUser(Review review){
        int uid = review.getUid();
        User user = userService.get(uid);
        review.setUser(user);
    }

    @Override
    public int getCount(int pid) {
        return list(pid).size();
    }
}
