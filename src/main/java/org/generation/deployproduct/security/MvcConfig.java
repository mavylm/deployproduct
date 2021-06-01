package org.generation.deployproduct.security;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.nio.file.*;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/products").setViewName("products");
        registry.addViewController("/productform").setViewName("productform");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/logout").setViewName("index");

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images")
                .addResourceLocations("classpath:/static/","classpath:/images/")
                .setCachePeriod(0);

        exposeDirectory("productImages/images", registry);
    }

    private void exposeDirectory(String dirName, ResourceHandlerRegistry register) {
        Path uploadDir = Paths.get(dirName);
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        System.out.println(uploadPath);

        System.out.println("/" + dirName + "/**");
        register.addResourceHandler("/" + dirName + "/**")
                .addResourceLocations("file:" + uploadPath + "/")
                .setCachePeriod(0)
                .resourceChain(true)
                .addResolver(new PathResourceResolver());
    }

}
