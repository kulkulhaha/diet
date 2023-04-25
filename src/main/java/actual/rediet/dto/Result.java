package actual.rediet.dto;

import lombok.*;

@AllArgsConstructor
@Data
public class Result <T>{

    private T body;
}
