## 스프링 Inversion of Control (IoC)

* 의존 관계 주입
* 어떤 객체가 사용하는 의존 객체를 직접 만들어 사용하는 게 아니라 **주입 받아 사용하는 방법**

---

## 스프링 IoC 컨테이너

* [BeanFactory](https://docs.spring.io/spring-framework/docs/5.0.8.RELEASE/javadoc-api/org/springframework/beans/factory/BeanFactory.html)
  * 스프링 IoC 컨테이너의 가장 최상위에 있는 인터페이스
  * 해당 인터페이스가 스프링 IoC 컨테이너의 핵심
* 애플리케이션 컴포넌트의 중앙 저장소
* 빈 설정 소스로부터 빈 정의를 읽고, 빈을 구성하고 제공함
  * 빈 설정 파일 필요

---

## Bean

* 스프링 IoC 컨테이너가 관리하는 객체
  
  * 즉, 컨테이너 안에 있는 객체들을 Bean이라고 함
  
* Bean을 **왜** 사용하는가? (빈의 장점)

  * 의존성 주입을 받기 위함

  * 스코프 때문에!

    * 싱글톤
      * 객체를 하나만 만들어서 사용하는 것
      * 런타임 시 성능 측면에서 효율적

    > cf) 프로토타입 스코프
    >
    > * 매번 다른 객체를 만들어서 사용하는 것

  * 라이프사이클 인터페이스

    * 스프링 IoC 컨테이너에 등록된 빈에만 국한됨
    * 빈이 만들어졌을 때, 뭔가 추가 작업이 하고 싶다!

---

## ApplicationContext

* 빈 설정
  * 빈 명세서
  * 빈에 대한 정의 有
    * name, class, scope, constructor, setter ...

* ApplicationContext

  * ClassPathXmlApplicationContext (XML)

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns:context="http://www.springframework.org/schema/context"
         xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">
  
      <!--
      //고전적인 xml 빈 설정 파일
      <bean id="bookService"
            class="com.example.springframeworkcore.BookService">
          <property name="bookRepository" ref="bookRepeository" />
      </bean>
  
      //이렇게만 등록하면, 북서비스가 북리파지토리를 주입받지 못함
      //주입을 해주어야 함. 이 코드는 그냥 북서비스 만들고 끝.
      //주입을 하려면 북서비스 프로퍼티에 리파지토리를 주입을 해주면 됨
      //ref : 빈의 id가 와야함
      <bean id="bookRepository"
            class="com.example.springframeworkcore.BookRepository" />
      -->
  
      <!--위의 방법을 사용하면 굉장히 번거롭다. 그래서 등장한 게 아래의 방법-->
      <!--해당 패키지부터 빈을 스캔해서 등록하겠다!-->
      <!--
          빈 스캔 시 사용하는 어노테이션
          @Component
              컴포넌트 어노테이션을 확장한 몇 가지 어노테이션
              @Service / @Repository
      -->
      <context:component-scan base-package="com.example.springframeworkcore" />
  
  
  </beans>
  ```

  * AnnotationConfigApplicationContext (Java)
    * xml로 설정하는 것과 비교했을 때, 굉장히 유연성이 있음

  ```java
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
  ```

* 스프링 부트의 `@SpringBootApplication` 어노테이션 자체가 빈 설정 파일









































