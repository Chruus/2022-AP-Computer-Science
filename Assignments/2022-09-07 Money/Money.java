//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Money{
    
    public static void main(String[] args){
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        int totalCents = 0;
        int dollars = 0;
        int cents = 0;
        Scanner input = new Scanner(System.in);
        
        out.print("How many pennies do you have --> ");
        pennies = input.nextInt();
        out.print("How many nickels do you have --> ");
        nickels = input.nextInt();
        out.print("How many dimes do you have ----> ");
        dimes = input.nextInt();
        out.print("How many quarters do you have -> ");
        quarters = input.nextInt();
        
        double total = pennies + nickels*5 + dimes*10 + quarters*25;
        
        out.println();        
        out.println("Total value = " + (int)(total*.01) + " dollars and " + (int)total%100 + " cents.");
    }

}

