package space.lvyang.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import space.lvyang.graphql.demo.mapper.BookMapper;
import space.lvyang.graphql.demo.mapper.UserMapper;
import space.lvyang.graphql.demo.model.Book;
import space.lvyang.graphql.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Nxin on 2019/4/3.
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    UserMapper userMapper;
    @Autowired
    BookMapper bookMapper;
    public Boolean insertUser(User user){
        return  userMapper.insertUser(user)>0?true:false;
    }
    public Boolean insertBookByUser(User user,Book book){
        try{
           final int i = userMapper.insertUser(user);
           final int j = bookMapper.insertbook(book);
            return i>0&&j>0?true:false;
        }catch (Exception e){
            return  false;
        }

    }


}
