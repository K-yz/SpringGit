package khly.codelean.project2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private boolean success;
    private int statusCode;
    private String message;
    private Object data;
}
