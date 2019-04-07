package space.lvyang.graphql.demo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import space.lvyang.graphql.demo.mapper.BookMapper;
import space.lvyang.graphql.demo.mapper.UserMapper;
import space.lvyang.graphql.demo.model.Book;
import space.lvyang.graphql.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Nxin on 2019/4/3.
 *
 * aboout
 * 1. method <name>(*args)

   2.method is<Name>(*args) 仅支持 return boolean

   3.method get<Name>(*args)

   4.method getField<Name>(*args)
 *
 */
@Component
public class Query  implements GraphQLQueryResolver {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> findAllBook(){
        return  bookMapper.getBook();
    }
    public Book  findBookByID(Integer id){

        return  bookMapper.getBookrById(id);
    }

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllusers(){
        return userMapper.getUser();
    }

    public Long countuser(){
        return userMapper.countUser();
    }

    public User findById(Integer id2){
        return userMapper.getUserById(id2);
    }
    public List<User> getUserByPage(Integer pagenumber,Integer pagesize1){
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("pagenumber",pagenumber);
        map.put("pagesize",pagesize1);
       return userMapper.getUserByPage(map);

    }


}
