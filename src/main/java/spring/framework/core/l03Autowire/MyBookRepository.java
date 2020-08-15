package spring.framework.core.l03Autowire;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class MyBookRepository implements InterfaceBookRepository{
}
