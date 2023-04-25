package actual.rediet.service;

import actual.rediet.domain.Member;
import actual.rediet.dto.CreateMemberDto;
import actual.rediet.exception.NoSuchMember;
import actual.rediet.respository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(CreateMemberDto createMemberDto){
        return memberRepository.save(createMemberDto.toEntity());
    }

    public Member findById(Long id){
        return memberRepository.findById(id)
                .orElseThrow(NoSuchMember::new);
        //TODO: Querydsl 로 변환?,  EntityGraph 을 사용하려고 하니 Validation 에 걸린다.
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public void removeMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(NoSuchMember::new);
        memberRepository.delete(member);
    }


}
