import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String FILENAME = "personen.csv";
        //Zähle zeilen
        int zeilenanzahl = countLinesOfFile(FILENAME)-1;

        //Erstellen des arrays

        Person[] personen = new Person[zeilenanzahl];

        readFile(FILENAME, personen);

        //Ausgabe am bildschirm
        for (int i = 0; i < personen.length; i++) {
            System.out.println(personen[i].getVorname()+ " " + personen[i].getNachname());

        }
    }

    private static void readFile(String filename, Person[] liste) {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            int i = 0;
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] elements = line.split(";");
                String vorname = elements[0];
                String nachname = elements[1];
                Person person = new Person(vorname, nachname);
                liste[i] = person;
                i++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static int countLinesOfFile(String filename){
        int counter = 0;
        try(Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()){
                counter++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
       return counter;
    }

}
