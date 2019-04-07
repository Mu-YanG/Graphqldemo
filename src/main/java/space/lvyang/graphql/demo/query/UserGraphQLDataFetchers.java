package space.lvyang.graphql.demo.query;

import space.lvyang.graphql.demo.mapper.UserMapper;
import space.lvyang.graphql.demo.model.User;
import graphql.schema.DataFetcher;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static graphql.schema.GraphQLFieldDefinition.newFieldDefinition;
import static graphql.schema.GraphQLObjectType.newObject;

//@Component
public class UserGraphQLDataFetchers {

    //@Autowired
    UserMapper userMapper;
  /*  public  static GraphQLObjectType userType = newObject().name("User")
            .field(newFieldDefinition().name("id").type(GraphQLInt))
            .field(newFieldDefinition().name("name").type(GraphQLString))
            .field(newFieldDefinition().name("age").type(GraphQLInt))
            .field(newFieldDefinition().name("balance").type(GraphQLInt))
            .build();*/

    public DataFetcher getUserDataFetcher(){
        List<User> users = userMapper.getUser();

        return dataFetchingEnvironment -> {
            return users.stream().collect(Collectors.toMap(User::getId, Function.identity()));
        };
    }
    public DataFetcher getUserByIdDataFetcher(){
        return dataFetchingEnvironment -> {
            Integer  id =Integer.parseInt(dataFetchingEnvironment.getArgument("id"));
            User user = userMapper.getUserById(id);
            return user;
        };
    }
}
