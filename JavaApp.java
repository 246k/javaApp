package javaapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//import java.io.FileReader;
//import java.io.BufferedReader;
//import java.io.IOException;

/**
 *
 * @author kkraynak
 */

class Student {
    String firstName;
    String lastName;
    String ZNumber;
    Float gpa;
    int gmat;
    int gre;
    
    Student(String first, String last, String z, Float gpa, int gmat, int gre){
        this.firstName=first;
        this.lastName=last;
        this.ZNumber=z;
        this.gpa=gpa;
        this.gmat=gmat;
        this.gre=gre;
    }
            
}
public class JavaApp {
    
    Student studentEntry;
   
    public static void main(String[] args) {
        try {
            int i = 0;
            int gmat;
            int gre;
            String suggestion;
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
                
                if( (gpa >= 3.5) && ((gmat >= 640) || (gre >= 317)) ){
                    suggestion = "Accept";
                }else if( (gpa >= 3.5) || (gmat >= 640) || (gre >=317) || ((gpa >= 3.0) && ((gmat >= 500) || (gre >= 300))) ){
                    suggestion = "Review further";
                }else {
                    suggestion = "Deny";
                }
                
                student = new Student(first, last, zNumber, gpa, gmat, gre);
                
                System.out.println("Full name: " + first + " " + last);
                System.out.println("Z Number: " + zNumber);
                System.out.println("GPA: " + gpa);
                System.out.println("GMAT Score: " + gmatS);
                System.out.println("GRE score: " + greS);
                System.out.println("Admission suggestion: " + suggestion);
                i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
//        public static void main(String[] args) {
//        try {
//            FileReader reader = new FileReader("/Users/kkraynak/Documents/NetBeansProjects/JavaApp/accounting-students/student-list.txt");
//            BufferedReader bufferedReader = new BufferedReader(reader);
// 
//            String line;
// 
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//            reader.close();
// 
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
