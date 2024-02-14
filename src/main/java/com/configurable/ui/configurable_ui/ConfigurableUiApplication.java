package com.configurable.ui.configurable_ui;

import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableSwagger2
public class ConfigurableUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurableUiApplication.class, args);
    }
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }

  // http://localhost:8080/swagger-ui/index.html
}
