package actual.rediet.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class BodyInfo extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private Integer height;
    private Integer weight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;
}
