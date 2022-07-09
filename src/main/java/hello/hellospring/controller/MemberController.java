package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//스프링 컨테이너가 MemberController의 객체를 만들어서 관리해준다. (=빈에 등록된다.)
@Controller //@Component 포함
public class MemberController {

    private  final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
/**
 * controller   -> Service  -> Repository 의 연관관게
 *
 *
 */