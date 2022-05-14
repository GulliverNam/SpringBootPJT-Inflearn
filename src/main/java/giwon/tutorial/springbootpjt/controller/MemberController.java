package giwon.tutorial.springbootpjt.controller;

import giwon.tutorial.springbootpjt.domain.Member;
import giwon.tutorial.springbootpjt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


/**
 * Spring 이 실행될 때 Component Annotation 이 포함된 Annotation 을 보고 객체를 생성해
 * Spring Container 에 등록해서 관리함 -> Bean이 관리된다고 표현
 */
@Controller
public class MemberController {

    private final MemberService memberService;

    /**
     * Autowired Annotation 은 Spring Container 에 있는 객체를 찾아서 매칭시켜줌
     */
    // DI 방법1 - 생성자주입
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

//    // DI 방법 2 - 필드주입
//    // * Spring 실행 시 한번 주입함 -> 최초 조립 중간에 바꿀수가 없음
//    @Autowired
//    private MemberService memberService;
//
//    // DI 방법 3 - Setter 주입
//    // * memberService 주입 시 public 하게 노출 됨 -> 실행 중간에 의존관계가 잘못될 시 문제가 발생할 수 있음
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }


    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
