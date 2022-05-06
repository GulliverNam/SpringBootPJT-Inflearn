package giwon.tutorial.springbootpjt.service;

import giwon.tutorial.springbootpjt.domain.Member;
import giwon.tutorial.springbootpjt.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;


// Service는 method 네이밍이 비즈니스 용어 가까움
// join, findMembers 등등
public class MemberService {

    private final MemoryMemberRepository memberRepository;

    public MemberService(MemoryMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public long join(Member member){
        //같은 이름이 있는 중복회원x
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAall();
    }


    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
