//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Pythag{
    
    public static void main(String[] args){
        Scanner side = new Scanner(System.in);
        out.print("Enter side 1 -->");
        double s1 = side.nextInt();
        out.print("Enter side 2 -->");
        double s2 = side.nextInt();
        out.println();
        
        double s3 = Math.sqrt(Math.pow(s1,2) + Math.pow(s2,2));
        out.println("The hypotenuse of the triangle = " + Math.round(s3));
    }

}

