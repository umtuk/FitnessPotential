package org.seoultech.fitnesspotential.global.config;

import org.seoultech.fitnesspotential.global.interceptor.BearerAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final BearerAuthInterceptor bearerAuthInterceptor;
    private final RestControllerConfig restControllerConfig;

    @Autowired
    public WebMvcConfig(BearerAuthInterceptor bearerAuthInterceptor,
                        RestControllerConfig restControllerConfig) {
        this.bearerAuthInterceptor = bearerAuthInterceptor;
        this.restControllerConfig = restControllerConfig;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(bearerAuthInterceptor)
                .addPathPatterns(restControllerConfig.getBasePath() + "/**")
        ;
    }
}
