//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class RichterScale{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        out.print("Enter a magnitude on the Richter scale ==>> ");
        float scale = input.nextInt();
        out.println();
        
        if(scale > 10){
            out.println("Good Luck, you broke the system");
        }
        else if(scale > 8){
            out.println("Most structures fall");
        }
        else if(scale > 7){
            out.println("Most buildings destroyed");
        }
        else if(scale > 6){
            out.println("Many buildings considerably damaged; some collapse");
        }
        else if(scale > 4.5){
            out.println("Damage to poorly constructed buildings");
        }
        else if(scale > 3.5){
            out.println("Felt by many people, no destruction");
        }
        else if(scale > 0){
            out.println("Generally not felt by people");
        }
        else out.println("Scale is 1-10");
    }
}

