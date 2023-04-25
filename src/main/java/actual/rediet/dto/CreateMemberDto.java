package actual.rediet.dto;

import actual.rediet.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateMemberDto {

    @NotBlank
    private String username;
    @NotBlank
    @Size(max = 16,min = 8)

    private String loginId;
    @NotBlank
    private String password;

    @Builder
    public CreateMemberDto(String username, String loginId, String password) {
        this.username = username;
        this.loginId = loginId;
        this.password = password;
    }

    public Member toEntity(){
        return Member.builder()
                .username(username)
                .password(password)
                .loginId(loginId)
                .build();
    }
}
