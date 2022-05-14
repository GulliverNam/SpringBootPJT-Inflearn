package giwon.tutorial.springbootpjt;

import giwon.tutorial.springbootpjt.repository.MemoryMemberRepository;
import giwon.tutorial.springbootpjt.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Controller 는 Component scan 으로 사용하는게 일반적
 */
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
