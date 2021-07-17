import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    private static File noteFile = new File("PhoneBok.txt");

    Activity activity = new Activity();

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }

    void showMenu() {
        loadNotes();
        System.out.println("Hello");
        boolean running = true;
        while (running) {
            System.out.println("Possible command:\n1.Create\n2.Delete\n3.List\n4.Find Note\n5.Exit");
            String cmd = Input.askString("Enter command: \n");
            switch (cmd) {
                case "1":
                    addNote();
                    saveNote();
                    //printNotes();
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
                    System.out.println("Unknown command");
            }
        }
        System.out.println("Bye");
    }
   /* private void printNotes() {
        System.out.println("\n-------ALL PHOHENUMBERS---------\n");
        System.out.printf("ID  \t    NAME  \t  PHONE NUMBER \n  ");

        for (Note note : activity.notes) {
            System.out.printf("%s   -   %s   -  %s \n\n",note.getId(),note.getName(),note.getPhoneNumber() );
        }

    }*/

    private void saveNote() {
        try (PrintWriter out = new PrintWriter(noteFile)) {
            for (Note note : activity.getAllNotes()) {
                out.printf("%s %s  %s  %s  %s\n", note.getId(), note.getName(), note.getSurname(), note.getAge(),note.getPhoneNumber());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot save note");
        }
    }

    private void loadNotes() {
        try (Scanner in = new Scanner(noteFile)) {
            while ((in.hasNext())) {
                Note note = new Note();
                note.setId(in.next());
                note.setName(in.next());
                note.setSurname(in.next());
                note.setAge(in.next());
                note.setPhoneNumber(in.next());
                activity.addNote(note);
            }
        } catch (FileNotFoundException e) {
            System.out.println("cannot read leaderboard");
        }
    }

    private void findNote() {
        String noteInfo = Input.askString("Enter what are You looking for:");

        for (Note note : activity.notes) {
            if (note.phoneNumber.contains(noteInfo) ||note.name.contains(noteInfo)) {
                System.out.println(note.name+"  "+ note.phoneNumber);
            }
        }

    }

    private void addNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Adding a Note");
        String id =  UUID.randomUUID().toString();
        Note note = new Note(id,
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


