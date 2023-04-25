package actual.rediet.dto;

import actual.rediet.domain.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ResponseMember {

    private Long id;

    private String username;

    private String loginId;

    @Builder
    public ResponseMember(Long id, String username, String loginId) {
        this.id = id;
        this.username = username;
        this.loginId = loginId;
    }
    public ResponseMember(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
        this.loginId = member.getLoginId();
    }
}
