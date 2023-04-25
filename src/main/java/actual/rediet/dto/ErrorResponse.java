package actual.rediet.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse {

    String message;
    String code;

    @Builder
    public ErrorResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }
}
