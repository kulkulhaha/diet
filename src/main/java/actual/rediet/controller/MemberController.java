package actual.rediet.controller;

import actual.rediet.domain.Member;
import actual.rediet.dto.CreateMemberDto;
import actual.rediet.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/new")
    public void register(@RequestBody @Valid CreateMemberDto createMemberDto){
        memberService.save(createMemberDto);
    }

    @GetMapping("/member/{memberId}")
    public Member getM(@PathVariable Long memberId){
        return memberService.findById(memberId);
    }

    @GetMapping("/members")
    public List<Member> findMembers(){
        return memberService.findMembers();
    }

    @DeleteMapping("/member/{memberId}")
    public Member delete(@PathVariable Long memberId){
        return memberService.findById(memberId);
    }

}
