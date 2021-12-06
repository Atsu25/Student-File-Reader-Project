
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
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
                "This program can take a file (given by the user) and complete several functions including: Return average gpa, return list of students in order by first name, and return array of students by class");
        System.out.println(
                "The format for files being read should be: firstname lastname-class-gpa");
        System.out.println(
                "------------------------------------------------------------------------");
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the name of the file you wish to use:");
        String fileName = scan.nextLine();
        // System.out.println(fileName);
        File f = new File(fileName);
        // Scanner fScan = new Scanner(f);

        while (true) {
            System.out.println("Type one of the following commands");
            System.out.println(
                    "A = average | S = sort names | C = class | X = exit program");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("a")) {
                System.out.println(
                        "Average GPA of all students is:" + getAverage(f));
                System.out.println("");
            }
            else if (input.equalsIgnoreCase("s")) {
                System.out.println("List or students in order by first name:"
                        + getSortFirst(f));
                System.out.println("");
            }
            else if (input.equalsIgnoreCase("c")) {
                System.out.println(
                        "Which class would you like to search by? | Use one of the following commands");
                System.out.println(
                        "F = Freshman | S = Sophomore | J = Junior | R = Senior");
                String inputClass = scan.nextLine();
                if (inputClass.equalsIgnoreCase("f")) {
                    String classFull = "Freshman";
                    System.out.println("List of Freshman students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }
                else if (inputClass.equalsIgnoreCase("s")) {
                    String classFull = "Sophomore";
                    System.out.println("List of Sophomore students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }
                else if (inputClass.equalsIgnoreCase("j")) {
                    String classFull = "Junior";
                    System.out.println("List of Junior students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }
                else if (inputClass.equalsIgnoreCase("r")) {
                    String classFull = "Senior";
                    System.out.println("List of Senior students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }
                else {
                    System.out.println(
                            "Error:" + inputClass + " is not a valid command");
                    System.out.println("");
                }
            }
            else if (input.equalsIgnoreCase("x")) {
                System.out.println("Closing program");
                break;
            }
            else {
                System.out.println("Error:" + input
                        + " is not a valid command. Please type one of the given commands");
            }
        }

        // catch (FileNotFoundException e) {
        // System.out.println("Error: Cant find File");
        // e.printStackTrace();
        // return;
        // }
    }

    public static double getAverage(File f) {

        double total = 0;
        double count = 0;
        try {

            Scanner mScan = new Scanner(f);

            while (mScan.hasNextLine()) {
                String studentData = mScan.nextLine();
                String[] splitData = studentData.split("-");
                double gpaVal = Double.parseDouble(splitData[2]);
                count++;
                total = total + gpaVal;
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Cant find File");
            e.printStackTrace();
        }
        return total / count;
    }

    public static ArrayList<String> getSortFirst(File f) {
        ArrayList<String> sorted = new ArrayList<String>();
        try {
            Scanner mScan = new Scanner(f);

            while (mScan.hasNextLine()) {
                String studentData = mScan.nextLine();
                sorted.add(studentData);
            }
            Collections.sort(sorted);

        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Cant find File");
            e.printStackTrace();
        }
        return sorted;
    }

    public static ArrayList<String> byClass(File f, String c) {

        ArrayList<String> classList = new ArrayList<String>();
        double total = 0;
        double count = 0;

        try {
            Scanner mScan = new Scanner(f);

            while (mScan.hasNextLine()) {
                String studentData = mScan.nextLine();
                String[] splitData = studentData.split("-");
                String classInfo = splitData[1];
                double gpa = Double.parseDouble(splitData[2]);

                if (classInfo.equalsIgnoreCase(c)) {
                    classList.add(studentData);
                    total += gpa;
                    count++;
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Cant find File");
            e.printStackTrace();
        }
        System.out.println("Average gpa of " + c + "s is " + (total / count));
        return classList;

    }

}