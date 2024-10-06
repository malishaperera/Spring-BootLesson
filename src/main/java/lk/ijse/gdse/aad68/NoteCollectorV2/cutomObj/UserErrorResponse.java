package lk.ijse.gdse.aad68.NoteCollectorV2.cutomObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserErrorResponse implements Serializable,UserResponse {
    private int errorCode;
    public String errorMessage;
}
