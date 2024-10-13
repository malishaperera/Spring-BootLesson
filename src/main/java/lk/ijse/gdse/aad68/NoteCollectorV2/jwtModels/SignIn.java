package lk.ijse.gdse.aad68.NoteCollectorV2.jwtModels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignIn {
    private String email;
    private String password;
}
