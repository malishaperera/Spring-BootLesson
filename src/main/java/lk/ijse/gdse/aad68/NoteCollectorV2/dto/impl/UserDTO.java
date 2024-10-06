package lk.ijse.gdse.aad68.NoteCollectorV2.dto.impl;

import lk.ijse.gdse.aad68.NoteCollectorV2.cutomObj.UserResponse;
import lk.ijse.gdse.aad68.NoteCollectorV2.dto.SuperDTO;
import lk.ijse.gdse.aad68.NoteCollectorV2.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements SuperDTO, UserResponse {

    private String userId;
    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private String profilePicture;
    private List<NoteEntity> notes;
}
