package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Classname UserMapper
 * @Date 2022/7/4 17:52
 * @Created by 李晓阳
 */
public interface UserMapper {
    List<User> selectAll();

    User select(String username, String password);

    User select(Collection collection);

    @Select("select * from tb_user where id = #{id}")
    User selectById(int id);
}
