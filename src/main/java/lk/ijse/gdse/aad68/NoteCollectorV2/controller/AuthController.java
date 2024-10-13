package lk.ijse.gdse.aad68.NoteCollectorV2.controller;

import lk.ijse.gdse.aad68.NoteCollectorV2.dto.impl.UserDTO;
import lk.ijse.gdse.aad68.NoteCollectorV2.exception.DataPersistFailedException;
import lk.ijse.gdse.aad68.NoteCollectorV2.jwtModels.JWTResponse;
import lk.ijse.gdse.aad68.NoteCollectorV2.jwtModels.SignIn;
import lk.ijse.gdse.aad68.NoteCollectorV2.util.AppUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @PostMapping(value = "sigIn")
    public ResponseEntity<JWTResponse> sigIn(
            @RequestPart("firstName") String firstName,
            @RequestPart("lastName") String lastName,
            @RequestPart("email") String email,
            @RequestPart("password") String password,
            @RequestPart("profilePicture") MultipartFile profilePicture)

    {
        // Handle profile pic
        try {
            byte[] imageByteCollection = profilePicture.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(imageByteCollection);
            // build the user object
            UserDTO buildUserDTO = new UserDTO();
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            buildUserDTO.setProfilePicture(base64ProfilePic);

            //send to the service layer
            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("sigUp")
    public ResponseEntity<JWTResponse> sigUp(@RequestBody SignIn signIn){
        return null;
    }
}
