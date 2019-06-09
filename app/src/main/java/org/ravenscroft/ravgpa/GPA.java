package org.ravenscroft.ravgpa;
import android.content.Context;

import static org.ravenscroft.ravgpa.RavGPA.bump1;
import static org.ravenscroft.ravgpa.RavGPA.bump2;
import static org.ravenscroft.ravgpa.RavGPA.bump3;
import static org.ravenscroft.ravgpa.RavGPA.bump4;
import static org.ravenscroft.ravgpa.RavGPA.bump5;
import static org.ravenscroft.ravgpa.RavGPA.bump6;
import static org.ravenscroft.ravgpa.RavGPA.bump7;

public class GPA {
    private double num1;
    private double num2;
    private double num3;
    private double num4;
    private double num5;
    private double num6;
    private double num7;
    public GPA(String cl1, String cl2, String cl3, String cl4, String cl5, String cl6, String cl7){
        num1 = gradeConverter(cl1);
        num2 = gradeConverter(cl2);
        num3 = gradeConverter(cl3);
        num4 = gradeConverter(cl4);
        num5 = gradeConverter(cl5);
        num6 = gradeConverter(cl6);
        num7 = gradeConverter(cl7);

        num1 += bump1;
        num2 += bump2;
        num3 += bump3;
        num4 += bump4;
        num5 += bump5;
        num6 += bump6;
        num7 += bump7;

    }

    public double gradeConverter(String grade)
    {
        if (grade.equalsIgnoreCase("a+"))
        {
            return 4.3;
        }
        if (grade.equalsIgnoreCase("a"))
        {
            return 4.0;
        }
        if (grade.equalsIgnoreCase("a-"))
        {
            return 3.7;
        }
        if (grade.equalsIgnoreCase("b+"))
        {
            return 3.3;
        }
        if (grade.equalsIgnoreCase("b"))
        {
            return 3.0;
        }
        if (grade.equalsIgnoreCase("b-"))
        {
            return 2.7;
        }
        if (grade.equalsIgnoreCase("c+")){
            return 2.3;
        }
        if (grade.equalsIgnoreCase("c")){
            return 2.0;
        }
        if(grade.equalsIgnoreCase("c-")){
            return 1.7;
        }
        if (grade.equalsIgnoreCase("d+"))
        {
            return 1.3;
        }
        if (grade.equalsIgnoreCase("d"))
        {
            return 1.0;
        }
        if (grade.equalsIgnoreCase("d-")){
            return .7;
        }
        if(grade.equalsIgnoreCase("f")){
            return .0001;
        }
        else
        {
            return 0;
        }
    }

    public String getGPA(){
        double sum;
        int total = 3;
        sum = num1+num2+num3;
        if ((num4 == 0)){
            sum=sum;
        }
        else
        {
            sum = num1+num2+num3+num4;
            total +=1;
        }



        if ((num5 == 0)){
            sum = sum;
        }
        else
        {
            sum += num5;
            total +=1;
        }




        if ((num6 == 0)){
            sum = sum;
        }
        else
        {
            sum += num6;
            total +=1;
        }




        if ((num7 == 0)){
            sum = sum;
        }
        else
        {
            sum += num7;
            total +=1;
        }


        double GPA = sum/total;
        String test = Double.toString(GPA);
        if (test.length() > 4)
        {
            test = test.substring(0,5);
        }
        if (test.length() == 3)
        {
            test = test.substring(0,3) + "000";
            test = test.substring(0,4);
        }
        if (test.length() == 4)
        {
            test = test.substring(0,4) + "000";
            test = test.substring(0,5);
        }
        else {
            test = test;
        }



        return test;
    }
}
