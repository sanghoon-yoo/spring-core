package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean(name="memberService")
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean(name="memberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean(name="orderService")
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean(name="discountPolicy")
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
