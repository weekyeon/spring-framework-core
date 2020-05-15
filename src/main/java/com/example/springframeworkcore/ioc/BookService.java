package com.example.springframeworkcore.ioc;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    //이 클래스는 스프링 IoC의 빈이 맞다.
    //왜 빈인가? 왜 IoC 컨테이너가 관리하게 했는가?
    // 1. 의존성 주입을 받기 위해서
    // 2. 빈의 scope 때문에
    // BookService는 하나만 사용해도 됨(싱글톤 관리)

    //@Autowired 이용해서 DI 사용
    //하나의 객체를 사용하기 때문에 런타임 시 성능 측정에서 유리함
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

}
