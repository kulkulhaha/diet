package actual.rediet.service;

import actual.rediet.domain.Member;
import actual.rediet.dto.*;
import actual.rediet.exception.NoSuchMember;
import actual.rediet.respository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member save(CreateMemberDto createMemberDto){
        return memberRepository.save(createMemberDto.toEntity());
    }

    public ResponseMember findById(Long id){
        return new ResponseMember(memberRepository.findById(id)
                .orElseThrow(NoSuchMember::new));



        //TODO: Querydsl 로 변환?,  EntityGraph 을 사용하려고 하니 Validation 에 걸린다. Result 로 감싸기
    }

    public List<ResponseMember> findMembers(){
        return memberRepository.findAll()
                .stream().map(ResponseMember::new)
                .collect(Collectors.toList());
    }

    public void removeMember(Long id){
        Member member = memberRepository.findById(id).orElseThrow(NoSuchMember::new);
        memberRepository.delete(member);
    }


    public void editMember(Long memberId, UpdateMemberDto updateMemberDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(NoSuchMember::new);
        MemberEditor.MemberEditorBuilder editorBuilder = member.toEditor();

        MemberEditor editor = editorBuilder.username(updateMemberDto.getUsername() != null ? updateMemberDto.getUsername() : member.getUsername())
                .loginId(updateMemberDto.getLoginId() != null ? updateMemberDto.getLoginId() : member.getLoginId())
                .password(updateMemberDto.getPassword() != null ? updateMemberDto.getPassword() : member.getPassword())
                .build();


        member.edit(editor);

    }

}
