package space.lvyang.graphql.demo.query;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

//@Component
public class UserGraphQLProvider {


   // @Autowired
    UserGraphQLDataFetchers userGraphQLDataFetchers;

    private GraphQL graphQL;

    //@PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("graphql/scheme.graphqls1");

        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("Query").dataFetcher("userbyid",userGraphQLDataFetchers.getUserByIdDataFetcher()))
                .type(newTypeWiring("Query").dataFetcher("user",userGraphQLDataFetchers.getUserDataFetcher()))
                .build();
       /* return RuntimeWiring.newRuntimeWiring().type("hello")*/
    }

    //@Bean
    public GraphQL graphQL() {
        return graphQL;
    }

}
