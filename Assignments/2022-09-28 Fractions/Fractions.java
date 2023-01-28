//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Fractions{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        out.println("Enter a fraction, operator, and another fraction using\nthis format: (2/3 + 1/2), and I will add, subtract, multiply,\nor divide the fractions   according to the operation desired.");
        out.println();
        out.print("Enter Fractions --> ");
        String equation = input.nextLine();
        out.println();
        
        int num1 = Integer.parseInt(equation.substring(0,1));
        int den1 = Integer.parseInt(equation.substring(2,3));
        char symbol = equation.charAt(4);
        int num2 = Integer.parseInt(equation.substring(6,7));
        int den2 = Integer.parseInt(equation.substring(8,9));
        
        int num3 = 0;
        int den3 = 0;
        if(symbol == '+'){
            num3 = num1*den2 + num2*den1;
            den3 = den1*den2;
        }
        else if(symbol == '-'){
            num3 = num1*den2 - num2*den1;
            den3 = den1*den2;
        }
        else if(symbol == '*'){
            num3 = num1*num2;
            den3 = den1*den2;
        }
        else if(symbol == '/'){
            num3 = num1*den2;
            den3 = den1*num2;
        }
        out.println(num1 + "   " + num2 + "   " + num3);
        out.println("- " + symbol + " - = -");
        out.println(den1 + "   " + den2 + "   " + den3);
    }
}

