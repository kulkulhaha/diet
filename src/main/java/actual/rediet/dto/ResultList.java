package actual.rediet.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ResultList <T>{

    List<T> body;

    @Builder
    public ResultList(List<T> body) {
        this.body = body;
    }
}
