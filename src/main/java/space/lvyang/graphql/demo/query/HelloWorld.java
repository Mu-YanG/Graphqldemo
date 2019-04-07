package space.lvyang.graphql.demo.query;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

public class HelloWorld {

    public static void main(String[] args) {
        //初始化schema 一般为 Query（查询表） { hello（对应字段）：String（对应字段；类型）}
        String schema = "type Query{hello: String}";
        //创建 schema解析器
        SchemaParser schemaParser = new SchemaParser();
        //解析 shcema
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(schema);
       //执行写入运行
        RuntimeWiring runtimeWiring = newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("hello", new StaticDataFetcher("world")))
                .build();
        //创建连接器(这可以从已注册解析器和数据注入的填充进行绑定)
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        //数据绑定(返回可查询内容graphQLSchema)
        GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);

        //查询创建查询内容(
        GraphQL build = GraphQL.newGraphQL(graphQLSchema).build();
        //执行内容查询（此处严格执行大小写）
        ExecutionResult executionResult = build.execute("{hello}");

       // System.out.println(executionResult.getData().toString());
        // Prints: {hello=world}



        //升级版

        ExecutionInput executionInput = ExecutionInput.newExecutionInput().query("{hello}").build();
        ExecutionResult executionResults = build.execute(executionInput);
        System.out.print(executionResults.getData().toString());

    }
}