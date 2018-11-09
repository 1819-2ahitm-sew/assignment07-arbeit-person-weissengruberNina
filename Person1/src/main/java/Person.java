import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Person {
    public static void main(String[] args) {
        String nachname;
        String vorname;

        String person = readFile("personen.csv");



    }

    public static String readFile(String personen){
        StringBuilder sb = new StringBuilder();

        try (Scanner scanner = new Scanner(new FileReader(personen))){
            while(scanner.hasNextLine()){
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }


        return sb.toString();
    }






}

