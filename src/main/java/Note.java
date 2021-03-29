import java.util.ArrayList;
import java.util.UUID;

public class Note {

    public UUID id;
    public String name;
    public String surname;
    public String age;
    public String phoneNumber;

    public Note(UUID id, String name, String surname, String age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
}


