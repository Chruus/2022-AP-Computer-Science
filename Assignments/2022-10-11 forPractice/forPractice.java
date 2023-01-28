//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class forPractice{
    
    public static void main(String[] args){
        for(int i = 0; i <= 25; i++){
            out.print(i + " ");
        }
        out.println("\n");
        for(int i = 10; i >= 1; i--){
            out.print(i + " ");
        }
        out.println("\n");
        for(int i = 1; i <= 39; i+=2){
            out.print(i + " ");
        }
        out.println("\n");
        for(int i = 2; i <= 40; i+=2){
            out.print(i + " ");
        }
        out.println("\n");
        for(int i = 10; i <= 200; i+=10){
            out.print(i + " ");
        }
        out.println("\n");
        for(int i = 10; i <= 20; i++){
            out.print(-i + " ");
        }
        //Or
        //for(int i = -10; i > -20; i--)
        //  out.print(i + " ");
        out.println("\n");
    }

}

