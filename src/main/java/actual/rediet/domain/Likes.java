package actual.rediet.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Likes extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;
}
