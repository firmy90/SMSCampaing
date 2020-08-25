package com.marketing.smscampaing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@Configuration
//@EnableWebMvc
public class AppConfiguration  implements WebMvcConfigurer {
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver =
//                new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
//        stringHttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
//                new MediaType("text","plain", StandardCharsets.UTF_8),
//                new MediaType("text","html", StandardCharsets.UTF_8),
//                new MediaType("application","json", StandardCharsets.UTF_8),
//                new MediaType("text","javascript", StandardCharsets.UTF_8),
//                new MediaType("text","css", StandardCharsets.UTF_8)
//        ));
//        converters.add(stringHttpMessageConverter);
//    }


}
