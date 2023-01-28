//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Mixup{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        out.print("Enter a string --> ");
        String thingAMaDoodle = input.nextLine();
        String output = thingAMaDoodle.substring(thingAMaDoodle.length()/2) + thingAMaDoodle.substring(0, thingAMaDoodle.length()/2);
        out.println();
        out.println("New string = " + output);
        
    }

}

