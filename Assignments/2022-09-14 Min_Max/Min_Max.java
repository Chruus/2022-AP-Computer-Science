//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Min_Max{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        out.print("Enter 1st Integer --> ");
        int num1 = input.nextInt();
        out.print("Enter 2nd Integer --> ");
        int num2 = input.nextInt();
        out.print("Enter 3rd Integer --> ");
        int num3 = input.nextInt();
        
        int smol = Math.min(num1, Math.min(num2, num3));
        int bigg = Math.max(num1, Math.max(num2, num3));
        
        out.println();
        out.println("Smallest = " + smol);
        out.println("Biggest = " + bigg);
    }

}

