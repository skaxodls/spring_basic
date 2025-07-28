package hello.core.singleton;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        statefulService2.order("userB", 20000);
        //ThreadA: 사용자A 주문 금액 조회
        int price = statefulService1.getPrice();
        //ThreadA: 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
        System.out.println("price = " + price);
        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}

//때문에 이러한 문제를 해결하기 위해서는 stateless 상태가 되도록 개발을 진행해야 한다
/*
StatefulService처럼 멤버 변수(price)에 값을 저장하면, 여러 스레드가 동시에 접근할 때 서로의 데이터에 영향을 줄 수 있습니다.
이를 방지하려면 멤버 변수에 상태를 저장하지 말고, order() 메서드에서 로컬 변수로 처리해야 합니다.
즉, 상태를 공유하지 않도록 설계해 Stateless하게 만들어야 합니다.
*/