
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
    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args) {

        // Tells user about the program and its abilities
        System.out.println("Welcome to the Student File Reader Program");
        System.out.println(
                "This program can take a file (given by the user) and complete several functions including: Return average gpa, return list of students in order by first name, and return list by class as well as return gpa of selected class");
        System.out.println(
                "The format for files being read should be: firstname lastname-class-gpa");
        System.out.println(
                "------------------------------------------------------------------------");

        // ask for user to input file
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the file you wish to use:");
        String fileName = scan.nextLine();
        File f = new File(fileName);

        // main loop for program that asks, checks, and calls methods for the
        // different commands available until exit
        while (true) {

            // asks user for command
            System.out.println("Type one of the following commands");
            System.out.println(
                    "A = average | S = sort names | C = class | X = exit program");
            String input = scan.nextLine();

            // average gpa case
            if (input.equalsIgnoreCase("a")) {
                System.out.println(
                        "Average GPA of all students is:" + getAverage(f));
                System.out.println("");
            }

            // sort by first name case
            else if (input.equalsIgnoreCase("s")) {
                System.out.println("List or students in order by first name:"
                        + getSortFirst(f));
                System.out.println("");
            }

            // by class case
            else if (input.equalsIgnoreCase("c")) {

                // asks user for class they want to use
                System.out.println(
                        "Which class would you like to search by? | Use one of the following commands");
                System.out.println(
                        "F = Freshman | S = Sophomore | J = Junior | R = Senior");

                String inputClass = scan.nextLine();

                // freshman case
                if (inputClass.equalsIgnoreCase("f")) {
                    String classFull = "Freshman";
                    System.out.println("List of Freshman students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }

                // sophomore case
                else if (inputClass.equalsIgnoreCase("s")) {
                    String classFull = "Sophomore";
                    System.out.println("List of Sophomore students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }

                // junior case
                else if (inputClass.equalsIgnoreCase("j")) {
                    String classFull = "Junior";
                    System.out.println("List of Junior students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }

                // senior case
                else if (inputClass.equalsIgnoreCase("r")) {
                    String classFull = "Senior";
                    System.out.println("List of Senior students:"
                            + byClass(f, classFull));
                    System.out.println("");
                }

                // if user input doesn't equal usable commands
                else {
                    System.out.println(
                            "Error:" + inputClass + " is not a valid command");
                    System.out.println("");
                }
            }

            // exit program case
            else if (input.equalsIgnoreCase("x")) {
                System.out.println("Closing program");
                break;
            }

            // if user input doesn't equal usable commands
            else {
                System.out.println("Error:" + input
                        + " is not a valid command. Please type one of the given commands");
            }
        }

    }

    /**
     * Gets average gpa of all students in the file
     * 
     * @param f
     * @return double - average
     */
    public static double getAverage(File f) {

        double total = 0;
        double count = 0;
        try {

            Scanner mScan = new Scanner(f);

            // goes through the entire file, gets the gpa of every student, and
            // adds to total. The counter goes up by one for every student
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

        // returns average (sum of all student gpas divided by number of
        // students)
        return total / count;
    }

    /**
     * Sorts the list of students by first name
     * 
     * @param f
     * @return ArrayList<String> - sorted list of students
     */
    public static ArrayList<String> getSortFirst(File f) {
        ArrayList<String> sorted = new ArrayList<String>();
        try {
            Scanner mScan = new Scanner(f);

            // adds every student to arraylist
            while (mScan.hasNextLine()) {
                String studentData = mScan.nextLine();
                sorted.add(studentData);
            }

            // sorts the arraylist
            Collections.sort(sorted);

        }
        catch (FileNotFoundException e) {
            System.out.println("Error: Cant find File");
            e.printStackTrace();
        }

        // returns sorted arraylist
        return sorted;
    }

    /**
     * Gets list of students by class as well as their average gpa
     * 
     * @param f
     * @param c
     * @return ArrayList<String> - list of students by given class
     */
    public static ArrayList<String> byClass(File f, String c) {

        ArrayList<String> classList = new ArrayList<String>();
        double total = 0;
        double count = 0;

        try {
            Scanner mScan = new Scanner(f);

            // goes through entire file of students and obtains class and gpa
            // values
            while (mScan.hasNextLine()) {
                String studentData = mScan.nextLine();
                String[] splitData = studentData.split("-");
                String classInfo = splitData[1];
                double gpa = Double.parseDouble(splitData[2]);

                // if the class for the student is equal to the class requested
                // by the user (String c), then add student to arraylist, add
                // gpa to total, and increase count by 1
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

        // print out average gpa of the classes student and return the list of
        // students in class
        System.out.println("Average gpa of " + c + "s is " + (total / count));
        return classList;

    }

}