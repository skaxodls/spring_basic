package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다.")
    void vip_o(){
        Member member=new Member(1L, "memberA", Grade.VIP);
        int discountPrice=discountPolicy.discount(member,10000);
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야한다.")
    void vip_x(){
        Member member=new Member(2L, "memberB", Grade.BASIC);
        int discountPrice=discountPolicy.discount(member,10000);
        assertThat(discountPrice).isEqualTo(0);
    }


}