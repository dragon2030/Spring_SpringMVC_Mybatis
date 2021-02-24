package com.bigDragon.dao;

import com.bigDragon.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author bigDragon
 * @create 2021-02-06 11:07
 */
public interface userDao {

    public User findById(@Param("userId")int userId);
}
