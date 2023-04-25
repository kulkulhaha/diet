package actual.rediet.controller;

import actual.rediet.domain.Member;
import actual.rediet.dto.UpdateMemberDto;
import actual.rediet.respository.MemberRepository;
import actual.rediet.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class MemberControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void save() throws Exception {
        Member member = Member.builder().loginId("kim").password("2134").build();
        String s = objectMapper.writeValueAsString(member);
        mockMvc.perform(post("http://localhost:8080/member/new")
                .contentType(APPLICATION_JSON)
                .content(s))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }

    @Test
    void findOne() throws Exception {
        Member member = Member.builder().username("kim").loginId("kim123413").password("2134").build();
        memberRepository.save(member);
        mockMvc.perform(get("http://localhost:8080/member/{memberId}",member.getId()))
                .andExpect(jsonPath("$.body.username").value("kim"))
                .andExpect(jsonPath("$.body.loginId").value("kim123413"))
                .andDo(print());
    }

    @Test
    void findAll() throws Exception {
        Member member1 = Member.builder().username("kim").loginId("kim123413").password("2134").build();
        memberRepository.save(member1);
        Member member2 = Member.builder().username("kim2").loginId("kim123333").password("1234").build();
        memberRepository.save(member2);

        mockMvc.perform(get("http://localhost:8080/members"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.body[0].loginId").value("kim123413"))
                .andExpect(jsonPath("$.body[1].loginId").value("kim123333"))
                .andDo(print());


    }

    @Test
    void delete() throws Exception {
        Member member1 = Member.builder().username("kim").loginId("kim123413").password("2134").build();
        Member saved = memberRepository.save(member1);

        mockMvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/member/{memberId}",saved.getId()))
                .andExpect(status().isOk())
                .andDo(print());

        assertThat(memberRepository.findAll().size()).isEqualTo(0);

    }

    @Test
    void edit() throws Exception {
        Member member1 = Member.builder().username("kim").loginId("kim123413").password("2134").build();
        Member saved = memberRepository.save(member1);

        UpdateMemberDto updateMemberDto = UpdateMemberDto.builder()
                .username("park")
                .loginId("park1234")
                .build();

        mockMvc.perform(patch("http://localhost:8080/member/{memberId}",saved.getId())
                .content(objectMapper.writeValueAsString(updateMemberDto))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        assertThat(memberRepository.findById(saved.getId()).get().getUsername()).isEqualTo("park");

    }

    @Test
    void wrongMemberEdit() throws Exception{
        Member member1 = Member.builder().username("kim").loginId("kim123413").password("2134").build();
        Member saved = memberRepository.save(member1);

        UpdateMemberDto updateMemberDto = UpdateMemberDto.builder()
                .username("park")
                .loginId("park1234")
                .build();

        mockMvc.perform(patch("http://localhost:8080/member/{memberId}",2L)
                        .content(objectMapper.writeValueAsString(updateMemberDto))
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andDo(print());
    }



}