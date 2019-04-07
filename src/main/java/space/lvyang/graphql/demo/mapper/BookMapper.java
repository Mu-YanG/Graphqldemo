package space.lvyang.graphql.demo.mapper;



import space.lvyang.graphql.demo.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookMapper { /**
     * Check the user
     */
        List<Book> getBook();
        Book getBookrById(@Param("id") Integer id);
        List<Book> getBookByMap(@Param("id") Integer id);
        Long countBook();
        Integer  updateBook(Book book);
        int  insertbook(Book book);
}
