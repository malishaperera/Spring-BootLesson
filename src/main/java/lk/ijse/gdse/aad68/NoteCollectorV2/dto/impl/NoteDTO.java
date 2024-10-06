package lk.ijse.gdse.aad68.NoteCollectorV2.dto.impl;

import lk.ijse.gdse.aad68.NoteCollectorV2.cutomObj.NoteResponse;
import lk.ijse.gdse.aad68.NoteCollectorV2.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO implements SuperDTO, NoteResponse {
    private String  noteId;
    private String  noteTitle;
    private String  noteDesc;
    private String  priorityLevel;
    private String createDate;
    private String userId;
}