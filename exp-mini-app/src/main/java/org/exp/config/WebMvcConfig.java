package org.exp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: 紫苏
 * @date: 2019/11/9 下午2:00
 * @description:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String path = "file:" + System.getProperty("user.dir") + "/video-dev/resources/";
        registry.addResourceHandler("/**").
                addResourceLocations("classpath:/META-INF/resources/").
                addResourceLocations(path);
    }

//    @Bean
//    public MiniInterceptor miniInterceptor() {
//        return new MiniInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        registry.addInterceptor(miniInterceptor()).addPathPatterns("/user/**")
//                .addPathPatterns("/video/upload", "/video/uploadCover",
//                        "/video/userLike", "/video/userUnLike",
//                        "/video/saveComment")
//                .addPathPatterns("/bgm/**")
//                .excludePathPatterns("/user/queryPublisher");
//    }
}
