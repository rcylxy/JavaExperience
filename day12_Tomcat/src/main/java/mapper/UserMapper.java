package mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

/**
 * @Classname UserMapper
 * @Date 2022/7/10 10:41
 * @Created by 李晓阳
 */
public interface UserMapper {
    @Select("select * from db1.tb_user where username=#{username} and password=#{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from db1.tb_user where username=#{username}")
    User selectByUsername(@Param("username") String username);

    @Insert("insert into db1.tb_user values (null,#{username},#{password})")
    void add(User user);

}
