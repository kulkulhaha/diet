package actual.rediet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Follow extends BaseEntity{
    @Id @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "followed")
    private List<Member> followers;

    @OneToMany(mappedBy = "follow")
    private List<Member> followings;
}
