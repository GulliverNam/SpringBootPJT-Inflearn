package giwon.tutorial.springbootpjt.repository;

import giwon.tutorial.springbootpjt.domain.Member;

import java.util.List;
import java.util.Optional;


// Method 네이밍이 개발스럽게 감
public interface MemberRepository {
    Member save(Member member);
    // Optional: Null 처리 시 Wrapping하는 객체 (java8기능)
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAall();
}
