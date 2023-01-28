//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class QuickPick{
    
    public static void main(String[] args){
        out.println("Texas Lottery - Quick Pick");
        out.println("===========================");
        for(int i = 0; i < 6; i++){
            out.print(" " + (int)(Math.random()*50+1) + " ");
        }
        out.println();
    }

}

