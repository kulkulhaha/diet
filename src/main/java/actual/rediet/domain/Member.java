package actual.rediet.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 16,min = 8)
    private String loginId;

    @NotBlank
    private String password;

    @OneToMany(mappedBy = "member")
    private final List<BodyInfo> bodyInfos = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private  final List<Diet> diets = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private final List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private final List<Likes> likes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Follow follow;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Follow followed;

    @OneToMany(mappedBy = "member")
    private final List<Comment> comments = new ArrayList<>();


    @Builder
    public Member(String username, String loginId, String password) {
        this.username = username;
        this.loginId = loginId;
        this.password = password;
    }
}
