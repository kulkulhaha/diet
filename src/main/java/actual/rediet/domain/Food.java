package actual.rediet.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Food extends BaseEntity{

    @Id @GeneratedValue
    private Long id;
    private String name;

    private String makerName;
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
