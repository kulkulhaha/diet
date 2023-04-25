package actual.rediet.controller;

import actual.rediet.domain.Member;
import actual.rediet.dto.*;
import actual.rediet.service.MemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/new")
    public void register(@RequestBody @Valid CreateMemberDto createMemberDto){
        memberService.save(createMemberDto);
    }

    @GetMapping("/member/{memberId}")
    public Result<ResponseMember> getOne(@PathVariable Long memberId){
        return new Result<>(memberService.findById(memberId));

    }

    @GetMapping("/members")
    public ResultList<ResponseMember> findMembers(){
        return new ResultList<>(memberService.findMembers());
    }

    @DeleteMapping("/member/{memberId}")
    public void delete(@PathVariable Long memberId){
        memberService.removeMember(memberId);
    }

    @PatchMapping("/member/{memberId}")
    public void update(@PathVariable Long memberId, @RequestBody UpdateMemberDto updateMemberDto){
         memberService.editMember(memberId,updateMemberDto);
    }

}
