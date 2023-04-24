package actual.rediet.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Post  extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
}
