package space.lvyang.graphql.demo.controler;

import org.springframework.stereotype.Controller;
import space.lvyang.graphql.demo.mapper.BookMapper;
import space.lvyang.graphql.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Nxin on 2019/4/1.
 */
@Controller
public class TestController {

    UserMapper userMapper;

    BookMapper bookMapper;

    public String getLlist(){
      return   userMapper.getUser().toString();
    }
   @ResponseBody
   @RequestMapping("1")
    public String getuLlist(){
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put("pagenumber",0);
        map.put("pagesize",1);

        return userMapper.getUserByPage(map).toString();
    }

}
