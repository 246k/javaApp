/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.mylib;

/**
 *
 * @author kkraynak
 */
public class Student {

    public int number;
    public String firstName;
    public String lastName;
    public String ZNumber;
    public Float gpa;
    public int gmat;
    public int gre;
    public String suggestion;

    public Student(int i, String first, String last, String z, Float gpa, int gmat, int gre) {
        this.number = i;
        this.firstName = first;
        this.lastName = last;
        this.ZNumber = z;
        this.gpa = gpa;
        this.gmat = gmat;
        this.gre = gre;
        if ((gpa >= 3.5) && ((gmat >= 640) || (gre >= 317))) {
            suggestion = "Accept";
        } else if ((gpa >= 3.5) || (gmat >= 640) || (gre >= 317) || ((gpa >= 3.0) && ((gmat >= 500) || (gre >= 300)))) {
            suggestion = "Review further";
        } else {
            suggestion = "Deny";
        }
    }
}
