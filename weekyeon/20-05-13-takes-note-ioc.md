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









































