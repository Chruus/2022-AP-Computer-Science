//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Rectangle{
    public static void main(String[] args){
        //Inputs
        Scanner rect = new Scanner(System.in);
        out.print("Enter the Length --> ");
        int length = rect.nextInt();
        out.print("Enter the Width --> ");
        int height = rect.nextInt();
        //Outputs
        int perimeter = length*2 + height*2;
        int area = length*height;
        out.println();
        out.println("Perimeter = " + perimeter);
        out.println("Area = " + area);
    }

}

