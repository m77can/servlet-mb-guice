package com.m77can.mapper;

import com.m77can.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") String id);

    int insert(User user);

    User findByEmail(@Param("email") String email);
}
