package com.example.springframeworkcore.ioc;

import com.example.springframeworkcore.SpringFrameworkCoreApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//xml 파일을 이용한 빈 설정이 아닌 자바 빈을 이용한 빈 설정
@Configuration
@ComponentScan(basePackageClasses = SpringFrameworkCoreApplication.class)
public class ApplicationConfig {

    @Bean
    public BookRepository bookRepository(){
        return new BookRepository();
    }

    @Bean
    public BookService bookService(){
        BookService bookService = new BookService();
        //세터가 있으니, 의존성 주입을 직적 해줄 수 있음
        bookService.setBookRepository(bookRepository());
        return bookService;
    }

}
