package space.lvyang.graphql.demo.query;

import com.google.common.io.Resources;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

import java.net.URL;

/**
 * Created by Nxin on 2019/4/1.
 */
public class HelloWord2 {
    public static void main(String[] args) {
        //获取数据源
        URL url = Resources.getResource("graphql/scheme.graphqls");
        //解析 shcema
        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(url.toString());
        //处理解析器
        
    }





}
