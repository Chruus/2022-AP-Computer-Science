//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class AnyPower{
    
    public static void main(String[] args){
        Scanner Base = new Scanner(System.in);
        out.print("Please enter an integer --> ");
        int base = Base.nextInt();
        out.print("Please enter an exponent --> ");
        int exponent = Base.nextInt();
        int result = base;
        for(int i=1; i<exponent; i++){
            result *= base;
        }
        out.println();
        out.println(base + " ^ " + exponent + " = " + result);
    }

}

