package javaapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.me.mylib.Student;

/**
 *
 * @author kkraynak
 *
 * This program takes a list of student applicants to a program via a text file
 * and parses through each application, eliciting an admissions recommendation
 * to either accept, review further, or deny.
 *
 *
 */
public class JavaApp {

    Student studentEntry;

    public static void main(String[] args) {
        int i = 0;
        String first;
        String last;
        String zNumber;
        String gpaString;
        String gmatString;
        String greString;

        Student student;
        try {
            String file = "/Users/kkraynak/Documents/NetBeansProjects/JavaApp/accounting-students/student-list.txt";

            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {

                first = scanner.next();
                last = scanner.next();
                zNumber = scanner.next();
                gpaString = scanner.next();
                gmatString = scanner.next();
                greString = scanner.next();

                student = new Student(i, first, last, zNumber, gpaString, gmatString, greString);

                System.out.println("\nApplicant #" + student.number);
                System.out.println("Full name: " + student.firstName + " " + student.lastName);
                System.out.println("Z Number: " + student.ZNumber);
                System.out.println("GPA: " + student.gpa);

                if (student.gmat == 0) {
                    System.out.println("GMAT Score: NA");
                } else {
                    System.out.println("GMAT Score: " + student.gmat);
                }

                if (student.gre == 0) {
                    System.out.println("GRE Score: NA");
                } else {
                    System.out.println("GRE score: " + student.gre);
                }

                System.out.println("Admission suggestion: " + student.suggestion);
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
