package spring.framework.core.l03Autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    //Autowire 사용 위치
//    BookRepository bookRepository;
//
//    //1. 생성자
//    @Autowired
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    //2. Setter
//    @Autowired
//    public void setBookRepository(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    //3. 필드
////    @Autowired
////    BookRepository bookRepository;

    //해당 타입의 빈이 여러 개인 경우
//    @Autowired @Qualifier("myBookRepository")
    @Autowired
    BookRepository bookRepository;

    //모든 빈 주입 받기
//    @Autowired
//    List<BookRepository> bookRepositories;
//
//    public void printBookRepository(){
//        this.bookRepositories.forEach(System.out::println);
//    }
}
