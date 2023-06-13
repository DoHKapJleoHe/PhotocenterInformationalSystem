package ru.nsu.ccfit.g20202.vartazaryan.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/frontend/build/static/");

        registry.addResourceHandler("/*.js")
                .addResourceLocations("/frontend/src/")
                .addResourceLocations("/frontend/src/pages");

        registry.addResourceHandler("/*.json")
                .addResourceLocations("/frontend/src/");

        registry.addResourceHandler("/index.html")
                .addResourceLocations("/frontend/public");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
    }
}
