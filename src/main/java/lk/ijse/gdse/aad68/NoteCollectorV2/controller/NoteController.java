package lk.ijse.gdse.aad68.NoteCollectorV2.controller;


import lk.ijse.gdse.aad68.NoteCollectorV2.cutomObj.NoteResponse;
import lk.ijse.gdse.aad68.NoteCollectorV2.dto.impl.NoteDTO;
import lk.ijse.gdse.aad68.NoteCollectorV2.exception.DataPersistFailedException;
import lk.ijse.gdse.aad68.NoteCollectorV2.exception.NoteNotFound;
import lk.ijse.gdse.aad68.NoteCollectorV2.service.NoteService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("api/v1/notes")
@RequiredArgsConstructor
public class NoteController {

    @Autowired
    private final NoteService noteService;

    @GetMapping("/health")
    public String healthCheck(){
       return "Note Taker is running";

    }

    //To Do CRUD Operation

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDTO note){

        if (note == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }else {

            try {

                //Todo: Handle with Service

                noteService.saveNote(note);
                return new ResponseEntity<>(HttpStatus.CREATED);

            }catch (DataPersistFailedException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

            }catch (Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @GetMapping(value = "allNotes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDTO> getAllNotes() {

        return noteService.getAllNotes();
    }



    @GetMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteResponse getSelectedNote(@PathVariable ("noteId") String noteId)  {

        return noteService.getSelectedNote(noteId);
    }


//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateNote(@PathVariable("noteId") String noteId , @RequestBody NoteDTO note){



        try {

            if (note == null && noteId == null || noteId.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            noteService.updateNote(noteId, note);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (NoteNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{noteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteNote(@PathVariable ("noteId") String noteId) {

        try {
            noteService.deleteNote(noteId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }catch (NoteNotFound e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}