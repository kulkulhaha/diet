package actual.rediet.service;

import actual.rediet.domain.Member;
import actual.rediet.respository.MemberRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Test
    void save() {
        Member member = Member.builder().username("kim").loginId("kim").password("2134").build();
        memberService.save(member);
        Member saved = memberRepository.findMemberById(member.getId());
        Assertions.assertThat(saved.getLoginId()).isEqualTo(member.getLoginId());

    }
}