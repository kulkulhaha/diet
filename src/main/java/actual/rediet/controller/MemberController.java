package actual.rediet.controller;

import actual.rediet.domain.Member;
import actual.rediet.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/new")
    public void create(@RequestBody Member member){
        memberService.save(member);
    }

    @GetMapping("/member/{memberId}")
    public Member getMember(@PathVariable Long memberId){
        return memberService.findById(memberId);
    }

}
