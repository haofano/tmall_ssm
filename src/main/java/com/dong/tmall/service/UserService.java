package com.dong.tmall.service;

import com.dong.tmall.pojo.User;

import java.util.List;

public interface UserService {
    void add(User c);
    void delete(int id);
    void update(User c);
    User get(int id);
    List list();
    boolean isExist(String name);
    User get(String name, String password);
}
