package giwon.tutorial.springbootpjt.repository;

import giwon.tutorial.springbootpjt.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberReopositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    
    // 테스트 순서에 의존관계를 만들면 안됨
    // -> 각 테스트가 끝난 후에 공유되는 자원을 지워줘야함
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        repository.save(member);

        //then
        Member result = repository.findById(member.getId()).get();
        // 실무에서는 Build Tool과 연동해 Test가 통과하지 않으면 Build를 막아버림
//        Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAall();
        assertThat(result.size()).isEqualTo(2);
    }
}
