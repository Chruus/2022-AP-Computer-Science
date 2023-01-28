//Christopher Petty

import static java.lang.System.out;
import java.io.*;
import java.util.Scanner;

public class RandomRanges{
    
    public static void main(String[] args){
        out.println("Random Ranges");
        out.println("================");
        out.println("1. Range 0 to 25 = " + (int)(Math.random()*26));
        out.println("2. Range 50 to 100 = " + (int)(Math.random()*51+50));
        out.println("3. Range -100 to 100 = " + (int)(Math.random()*201-100));
        out.println("4. Range 0.1 to 1 = " + (double)((int)(Math.random()*1000+10))/1000);
        out.println("5. Range A to Z = " + (char)(Math.random()*27+65));
        out.println("6. Range 1000 to 10000 (rounded to nearest thousand) = " + (Math.round((int)(Math.random()*11)*1000)));
    }

}

