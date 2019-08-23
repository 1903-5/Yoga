package com.qf.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：BinSun
 * @date : 2019/8/13 16:27
 * @description :
 * @modified By ：
 * @version:
 */
@Component
@Primary
public class DocumentationConfig  implements SwaggerResourcesProvider {
    @Override
    public List<SwaggerResource> get() {
        List resources = new ArrayList<>();
        resources.add(swaggerResource("student接口", "/yoga/student/v2/api-docs", "1.0"));
//        resources.add(swaggerResource("shop接口", "/agriculture/shop/v2/api-docs", "1.0"));
//        resources.add(swaggerResource("agricultureProduct接口", "/agriculture/agricultureProduct/v2/api-docs", "1.0"));
//        resources.add(swaggerResource("order接口", "/agriculture/order/v2/api-docs", "1.0"));
//        resources.add(swaggerResource("es接口", "/agriculture/es/v2/api-docs", "1.0"));
        return resources;
    }

    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}
