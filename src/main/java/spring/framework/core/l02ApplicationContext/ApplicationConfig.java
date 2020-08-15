package spring.framework.core.l02ApplicationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    //빈 설정
    //Bean id = bookRepository() 메소드
    //Bean type = BookRepository 객체
    //실제 객체 = new BookRepository();
    @Bean
    public BookRepository bookRepository(){
        return new BookRepository();
    }

    //주입 방법 1. 의존성 주입에 필요한 메소드 직접 호출
    @Bean
    public BookService bookService(){
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository());
        return bookService;
    }

    //주입 방법 2. 메소드 파라미터로 의존성 주입 받기
    @Bean
    public BookService bookService(BookRepository bookRepository){
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository);
        return bookService;
    }

}
