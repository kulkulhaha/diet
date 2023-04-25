package actual.rediet.service;

import actual.rediet.domain.Member;
import actual.rediet.dto.CreateMemberDto;
import actual.rediet.dto.UpdateMemberDto;
import actual.rediet.exception.NoSuchMember;
import actual.rediet.respository.MemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {


    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Test
    @DisplayName("멤버 저장")
    void save() {
        CreateMemberDto memberDto = CreateMemberDto.builder().username("kim").loginId("kim12312").password("2134").build();
        Member member = memberService.save(memberDto);
        assertThat(member.getLoginId()).isEqualTo(memberDto.getLoginId());
    }


    @Test
    @DisplayName("멤버 찾기")
    void findById() {
        CreateMemberDto memberDto = CreateMemberDto.builder().username("kim").loginId("123").password("2134").build();
        Member member = memberService.save(memberDto);
        Member findMember = memberService.findById(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(memberDto.getUsername());
        assertThat(findMember.getLoginId()).isEqualTo(memberDto.getLoginId());
        assertThat(findMember.getPassword()).isEqualTo(memberDto.getPassword());
    }

    @Test
    @DisplayName("없는 회원 찾기")
    void noSuchMember() {
        assertThatThrownBy(()->memberService.findById(1L)).isInstanceOf(NoSuchMember.class);

    }

    @Test
    @DisplayName("전체 회원 조회")
    void findAll() {
        CreateMemberDto memberDto1 = CreateMemberDto.builder().username("kim1").loginId("123112322").password("2134").build();
        Member member1 = memberService.save(memberDto1);
        CreateMemberDto memberDto2 = CreateMemberDto.builder().username("kim2").loginId("1232123123").password("2134").build();
        Member member2 = memberService.save(memberDto2);
        List<Member> members = memberService.findMembers();
        assertThat(members).contains(member1,member2);
    }

    @Test
    @DisplayName("멤버 하나 삭제")
    void deleteOne() {
        CreateMemberDto memberDto1 = CreateMemberDto.builder().username("kim1").loginId("123112322").password("2134").build();
        Member member1 = memberService.save(memberDto1);
        memberService.removeMember(member1.getId());
        assertThatThrownBy(()->memberService.findById(member1.getId())).isInstanceOf(NoSuchMember.class);
    }
    @Test
    @DisplayName("존재하지 않는 멤버 삭제 시 예외")
    void deleteException() {

        assertThatThrownBy(()->memberService.removeMember(1L)).isInstanceOf(NoSuchMember.class);
    }
    @Test
    @DisplayName("멤버 정보 변경")
    void editMember() {
        CreateMemberDto memberDto = CreateMemberDto.builder().username("kim").loginId("123").password("2134").build();
        UpdateMemberDto updateMemberDto = UpdateMemberDto.builder().username("kim1").loginId("231").build();
        Member member = memberService.save(memberDto);
        memberService.editMember(member.getId(),updateMemberDto);
        Member findMember = memberService.findById(member.getId());
        assertThat(findMember.getUsername()).isEqualTo(updateMemberDto.getUsername());
        assertThat(findMember.getLoginId()).isEqualTo(updateMemberDto.getLoginId());
        assertThat(findMember.getPassword()).isEqualTo(memberDto.getPassword());
    }


}