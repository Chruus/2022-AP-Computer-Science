//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class ForPractice
{
    
    public static void main(String[] args){
        for(int i = 1; i < 26; i++)
        {
            out.print(i + " ");
        }
        out.println();
        for(int i = 50; i<71; i++)
        {
            out.print(i + " ");
        }
        out.println();
        for(int i = 0; i <= 100; i+=5)
        {
            out.print(i + " ");
        }
        out.println();
        for(int i = 20; i > 0; i--)
        {
            out.print(i + " ");
        }
        out.println();
        int a = 0;
        for(int i = 0; a < 20000; i++)
        {
            a += i;
            out.print(a + " ");
        }
        out.println("\n");
    }

}

