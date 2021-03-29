import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    Activity activity = new Activity();

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    void showMenu() {
        System.out.println("Hello");
        boolean running = true;
        while (running) {
            System.out.println("Possible command:\n1.Create\n2.Delete\n3.List\n4.Find Note\n5.Exit");
            String cmd = Input.askString("Enter command: \n");
            switch (cmd) {
                case "1":
                    addNote();
                    break;
                case "2":
                    deleteNote();
                    break;
                case "3":
                    allNotes();
                    break;
                case "4":
                    findNote();
                    break;
                case "5":
                    running = false;
                    break;

                default:
                    System.out.println("Uknown command");
            }
        }
        System.out.println("Bye");
    }

    private void findNote() {
        String noteInfo = Input.askString("Enter what are You looking for:");

        for (Note note : activity.notes) {
            if (note.name.contains(noteInfo)) {
                System.out.println(note);
            }
        }


        ArrayList<Note> allNotesAvailable = activity.getAllNotes();


        if (allNotesAvailable.contains(noteInfo)) {

            System.out.println("Found this:  " + allNotesAvailable);

        } else {
            System.out.println(noteInfo + "  not found");

        }
    }

    private void addNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Adding a Note");
        Note note = new Note(
                UUID.randomUUID(),
                Input.askString("Your name:"),
                Input.askString("Your surname:"),
                Input.askString("Your age:"),
                Input.askString("Your phone number:")
        );

        String message = activity.addNote(note);
        System.out.println(message);


    }

    private void allNotes() {
        ArrayList<Note> allNotes = activity.getAllNotes();
        System.out.println("\n All Notes :\n");
        System.out.println("ID\t    Name\t  Phone Number\t ");

        int counter = 1;


        for (Note note : allNotes) {
            System.out.println(counter + ".\t" + note.name + "\t\t" + note.phoneNumber);
            counter++;
        }

    }

    private void deleteNote() {
        System.out.println("Delete Note\n");
        int noteId = Integer.parseInt(Input.askString("enter ID"));
        String message = activity.removeNote(noteId);
        System.out.println(message);
    }


}


