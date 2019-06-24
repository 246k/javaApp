package javaapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.me.mylib.Student;

/**
 *
 * @author kkraynak
 * 
 * This program takes a list of student applicants to a program
 * via a text file and parses through each application, 
 * eliciting an admissions recommendation to either 
 * accept, review further, or deny.
 * 
 * 
 */


public class JavaApp {

    Student studentEntry;

    public static void main(String[] args) {
        try {
            int i = 0;
            int gmat;
            int gre;
            
            Student student;

            String file = "/Users/kkraynak/Documents/NetBeansProjects/JavaApp/accounting-students/student-list.txt";
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                System.out.println("\nApplicant #" + (i + 1));
                String first = scanner.next();
                String last = scanner.next();
                String zNumber = scanner.next();
                String gpaS = scanner.next();
                float gpa = Float.valueOf(gpaS);
                String gmatS = scanner.next();
                if ("NA".equals(gmatS)) {
                    gmat = 0;
                } else {
                    gmat = Integer.valueOf(gmatS);
                }
                String greS = scanner.next();
                if ("NA".equals(greS)) {
                    gre = 0;
                } else {
                    gre = Integer.valueOf(greS);
                }

                student = new Student(i, first, last, zNumber, gpa, gmat, gre);

                System.out.println("Full name: " + student.firstName + " " + student.lastName);
                System.out.println("Z Number: " + student.ZNumber);
                System.out.println("GPA: " + student.gpa);
                System.out.println("GMAT Score: " + student.gmat);
                System.out.println("GRE score: " + student.gre);
                System.out.println("Admission suggestion: " + student.suggestion);
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
