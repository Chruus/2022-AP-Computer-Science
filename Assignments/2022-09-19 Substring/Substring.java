//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class Substring{ 
    public static void main(String[] args){
        out.print("Enter the word flashlight --> ");
        Scanner input = new Scanner(System.in);
        String flashlight = input.nextLine();
        String output;
        out.println(flashlight);
        
        out.println("Part 1");
        out.println("=================");
        output = flashlight.substring(0,5);
        out.println(output);
        output = flashlight.substring(5);
        out.println(output);
        output = flashlight.substring(2,5);
        out.println(output);
        output = flashlight.substring(0,2) + flashlight.substring(6);
        out.println(output);
        output = flashlight.substring(0,3) + flashlight.substring(7,8);
        out.println(output);
        output = flashlight.substring(0,1) + flashlight.substring(6,7) + flashlight.substring(9);
        out.println(output);
        output = flashlight.substring(4,5) + flashlight.substring(6,9);
        out.println(output);
        output = flashlight.substring(7,8) + flashlight.substring(2,4);
        out.println(output);
        output = flashlight.substring(0,1) + flashlight.substring(2,4) + flashlight.substring(9);
        out.println(output);
        output = flashlight.substring(3,5) + flashlight.substring(2,3) + flashlight.substring(0,1) + flashlight.substring(9);
        out.println(output);
        out.println();
        
        //Here is where I realize that I don't need to make them completely out of the original string. Good practice tho.
        out.println("Part 2");
        out.println("=================");
        output = flashlight.substring(5);
        out.println(output + "s");
        out.println(output + "er");
        out.println(output + "ning");
        out.println("en" + output + "ened");
    }
}

