package com.project.shoppingcart;

import com.project.shoppingcart.modelmapper.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ShoppingcartApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(ShoppingcartApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ShoppingcartApplication.class);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ConsumerMapper userMapper() {
        return new ConsumerMapper();
    }

    @Bean
    public MerchantMapper merchantMapper() {
        return new MerchantMapper();
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public AddressMapper addressMapper() {
        return new AddressMapper();
    }

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }

}
