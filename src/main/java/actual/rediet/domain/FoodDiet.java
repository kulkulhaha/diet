package actual.rediet.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class FoodDiet extends BaseEntity{

    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Diet diet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Food food;

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
