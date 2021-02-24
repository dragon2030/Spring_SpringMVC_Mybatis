package com.bigDragon.service;

import com.bigDragon.model.User;

/**
 * @author bigDragon
 * @create 2021-02-06 11:01
 */
public interface UserService {
    public User findById(int userId);
}
