//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Powers{
    
    public static void main(String[] args){
        Scanner Base = new Scanner(System.in);
        out.print("Please enter an integer --> ");
        int base = Base.nextInt();
        
        out.println("The Square = " + base * base);
        out.println("The Cube = " + base * base * base);
        out.println("The Fourth Power = " + base * base * base * base);
    }

}

