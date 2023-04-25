package actual.rediet.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberEditor {
    private String username;
    private String loginId;
    private String password;

    @Builder
    public MemberEditor(String username, String loginId, String password) {
        this.username = username;
        this.loginId = loginId;
        this.password = password;
    }
}
