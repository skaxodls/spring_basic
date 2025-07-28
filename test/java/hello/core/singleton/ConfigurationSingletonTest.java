//package hello.core.singleton;
//
//import hello.core.AppConfig;
//import hello.core.member.Member;
//import hello.core.member.MemberRepository;
//import hello.core.member.MemberService;
//import hello.core.member.MemberServiceImpl;
//import hello.core.order.OrderService;
//import hello.core.order.OrderServiceImpl;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class ConfigurationSingletonTest {
//
//    @Test
//    void configurationTest(){
//        ApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
//        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
//        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
//
//        MemberRepository memberRepository1=memberService.getMemberRepository();
//        MemberRepository memberRepository2=orderService.getMemberRepository();
//
//        System.out.println("memberRepository1 = " + memberRepository1);
//        System.out.println("memberRepository2 = " + memberRepository2);
//
//        //Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
//
//
//    }
//}
//
package hello.core.singleton;
import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;
public class ConfigurationSingletonTest {
    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        //모두 같은 인스턴스를 참고하고 있다.
        System.out.println("memberService -> memberRepository = " +
                memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository  = " +
                orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);
        //모두 같은 인스턴스를 참고하고 있다.
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
        /*
        *  예상과는 다르게 클래스 명에 xxxCGLIB가 붙으면서 상당히 복잡해진 것을 볼 수 있다. 이것은 내가 만든 클래
            스가 아니라 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다
            른 클래스를 만들고, 그 다른 클래스를 스프링 빈으로 등록한 것이다!
* */
    }
}