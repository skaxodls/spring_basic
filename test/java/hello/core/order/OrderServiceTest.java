package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    AppConfig appConfig = new AppConfig();
    MemberService memberService=appConfig.memberService();
    OrderService orderService=appConfig.orderService();



    @Test
    public void orderServiceTest() {
        Long memberId=1L;
        Member member=new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId, "itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
