package actual.rediet.service;

import actual.rediet.domain.Member;
import actual.rediet.respository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    public Member findById(Long id){
        return memberRepository.findMemberById(id);
        //.orElseThrow(()->new IllegalArgumentException("존재하지 않는 회원입니다"));
    }


}
