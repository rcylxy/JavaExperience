package json;

import com.alibaba.fastjson.JSON;

/**
 * @Classname FastJsonDemo
 * @Date 2022/7/12 18:49
 * @Created by 李晓阳
 */
public class FastJsonDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");
        user.setId(1);
        String s = JSON.toJSONString(user);
        System.out.println(s);

        User user1 = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(user1);
    }
}