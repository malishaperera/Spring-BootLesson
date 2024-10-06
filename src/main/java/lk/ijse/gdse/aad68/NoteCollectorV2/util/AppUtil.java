package lk.ijse.gdse.aad68.NoteCollectorV2.util;

import java.util.Base64;
import java.util.UUID;



public class AppUtil {

    public static String createNoteID(){
        return "NOTE-"+ UUID.randomUUID();
    }

    public static String createUserId(){
        return "USER-"+UUID.randomUUID();
    }

    public static String toBase64ProfilePic(byte[] profilePic){
        return Base64.getEncoder().encodeToString(profilePic); //used to java Base64 class, and profilePic convert Base64 encode


    }

    //mapping
}
