package space.lvyang.graphql.demo.mapper;

import space.lvyang.graphql.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper{ /**
     * Check the user
     */
        List<User> getUser();
        User getUserById(@Param("id")Integer id);
        Long countUser();
        Integer  updateUser(User User);;
        int  insertUser(User user);
        List<User> getUserByPage(@Param("params")Map map);
}
