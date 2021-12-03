import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Student File Reader Program: Takes file given by user and user can ask for
 * several functions including: calculate average gpa, sort by first name, and
 * sort by class
 * 
 * @author noah leach, andrew summersgill
 */
public class StudentFileReader {

    public static void main(String[] args) {
        System.out.println("Welcome to the Student File Reader Program");
        System.out.println(
                "This program can take a file (given by the user) and complete several functions including: Return average gpa, return array of students in order by first name, and return array of students by class");
        System.out.println(
                "The format for files being read should be: firstname lastname|class|gpa");
        System.out.println(
                "------------------------------------------------------------------------");
        Scanner scan = new Scanner(System.in);

        try {
            System.out.println("Enter the name of the file you wish to use:");
            String fileName = scan.nextLine();
            System.out.println(fileName);
            File f = new File(fileName);
            Scanner s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Cant find File");
            e.printStackTrace();
            return;
        }

        while (true) {
            System.out.println("Type one of the following commands");
            System.out.println(
                    "A = average | S = sort names | C = class | X = exit program");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("a")) {

            }
            else if (input.equalsIgnoreCase("s")) {

            }
            else if (input.equalsIgnoreCase("c")) {

            }
            else if (input.equalsIgnoreCase("x")) {
                System.out.println("Goodbye");
                break;
            }
            else {
                System.out.println("Error:" + input
                        + " is not a valid command. Please type one of the given commands");
            }
        }
    }

    public double getAverage() {
        return 0.0;
    }

    public String[] sort() {
        String[] m = new String[0];
        return m;
    }

    public String[] sortClass() {
        String[] a = new String[0];
        return a;
    }

}
