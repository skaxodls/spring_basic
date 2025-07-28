package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",//특정 패키지의 컴포넌트만 등록하고 싶을 때 사용
        excludeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
    //기존에 AppConfig와의 충돌을 막기위한 설정
)

public class AutoAppConfig {
/*
    수동빈과 자동빈의 이름이 같은 경우
    수동빈이 자동빈을 오버라이딩하여 에러가 나지 않음
    하지만 스프링 부트에서 이러한 경우 동작하지 않도록 설정을 하면서 스프링 부트로는 실행 불가(설정값 바꾸면 가능)
    아래 @Bean 코드가 수동 등록을 진행한 것임.
    @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
    }
*/
}
