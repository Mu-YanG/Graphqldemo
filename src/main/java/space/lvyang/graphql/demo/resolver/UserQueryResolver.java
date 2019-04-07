package space.lvyang.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import space.lvyang.graphql.demo.mapper.BookMapper;
import space.lvyang.graphql.demo.model.Book;
import space.lvyang.graphql.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Nxin on 2019/4/3.
 */
@Component
public class UserQueryResolver implements GraphQLResolver<User> {
    @Autowired
    private BookMapper bookMapper;

    public  List<Book> getBooks(User user){

         return bookMapper.getBookByMap(user.getId());
    }

}
