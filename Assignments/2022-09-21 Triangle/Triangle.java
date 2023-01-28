//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Triangle{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        out.print("Enter Size 1 --> ");
        int side1 = input.nextInt();
        out.print("Enter Size 1 --> ");
        int side2 = input.nextInt();
        out.print("Enter Size 1 --> ");
        int side3 = input.nextInt();
        
        out.println();
        if(side1 == side2 && side2 == side3)
            out.println("The triangle is an equilateral.");
        else if(side1 == side2 || side2 == side3 || side3 == side1)
            out.println("The triangle is an isosceles.");
        else
            out.println("The triangle is an scalene.");
    }
}

