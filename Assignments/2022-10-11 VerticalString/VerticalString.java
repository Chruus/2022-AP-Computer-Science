//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class VerticalString{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        for(int i = 0; i < line.length(); i++){
            out.println(line.charAt(i));
        }
    }

}

