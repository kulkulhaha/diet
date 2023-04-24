package actual.rediet.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Diet extends BaseEntity{
    @Id @GeneratedValue
    private Long id;

    private String name;

    private boolean open = false;

    @OneToMany(mappedBy = "diet")
    private List<FoodDiet> foodDiets = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    private Integer kcal;
    private Integer carbohydrate;
    private Integer protein;
    private Integer fat;
    private Integer sugar;
    private Integer sodium;
    private Integer cholesterol;
    private Integer saturatedFattyAcid;
    private Integer transFat;



}
