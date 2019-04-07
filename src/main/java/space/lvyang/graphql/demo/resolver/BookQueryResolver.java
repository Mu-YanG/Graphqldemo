package space.lvyang.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;

import space.lvyang.graphql.demo.mapper.UserMapper;
import space.lvyang.graphql.demo.model.Book;
import space.lvyang.graphql.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

/**
 * Created by Nxin on 2019/4/3.
 */
@Component
public class BookQueryResolver implements GraphQLResolver<Book> {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public String getCreatetime(Book book) {
        return sdf.format(book.getCreatetime());
    }

    @Autowired
    UserMapper userMapper;
    //该方法为scheme.graphqls 中配置好的User方法，设置成功后填充数据
    public User getUser(Book book){
        return userMapper.getUserById(book.getUserid());
    }

}
