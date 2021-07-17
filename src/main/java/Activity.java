import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Activity {
    public ArrayList<Note> notes = new ArrayList<>();
    public String addNote(Note note){

        this.notes.add(note);
        return note.name +"  "+note.phoneNumber +" added successfully";
    }

    public  ArrayList<Note> getAllNotes() {
return notes;

    }

    public  String removeNote(int noteId) {
        try {
            notes.remove(noteId);
        } catch (Exception ex) {
            return "Unable to remove specified note";

        }
        return "Your note removed successfully";


    }

}
