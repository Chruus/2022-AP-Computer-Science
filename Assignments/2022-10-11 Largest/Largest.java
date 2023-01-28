//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Largest{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int largest = 0;
        int lines = 0;
        String line = "";
        
        out.println("Type 10 Numbers");
        
        do {
            line = input.nextLine();
            int lineInt = 0;
            lines++;
            //Checks if there's a number in line, if not ignore the input
            try {
                lineInt = Integer.parseInt(line);
            }
            catch(NumberFormatException e){
                out.println("that's not a number!");
                line = "0";
                lines --;
            }
            
            if(lineInt > largest)
                largest = lineInt;
        }
        while(lines < 10);
        out.println(largest);
    }
}

