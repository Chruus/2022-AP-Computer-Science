//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class WhilePractice{
    
    public static void main(String[] args){
        int i = 1;
        while(i < 26)
        {
            out.print(i + " ");
            i++;
        }
        out.println();
        i = 50;
        while(i<71)
        {
            out.print(i + " ");
            i++;
        }
        out.println();
        i = 0;
        while(i <= 100)
        {
            out.print(i + " ");
            i+=5;
        }
        out.println();
        i = 20;
        while(i > 0)
        {
            out.print(i + " ");
            i--;
        }
        out.println();
        int a = 0;
        i = 0;
        while(a < 20000)
        {
            a += i;
            out.print(a + " ");
            i++;
        }
        out.println("\n");
    }

}

