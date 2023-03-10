//Christopher Petty

import java.util.*;

public class LessThan100 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix size--> ");
        String line = input.nextLine();
        input.close();
        Scanner lineScan = new Scanner(line);
        int[][] arr = new int[lineScan.nextInt()][lineScan.nextInt()];
        lineScan.close();

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                arr[r][c] = (int) (Math.random() * 200 + 1);
            }
        }

        System.out.println("\nGenerated Matrix");
        for (int[] r : arr) {
            for (int c : r)
                System.out.print(c + " ");
            System.out.println();
        }

        System.out.println("\nRow     Column");
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (arr[r][c] < 100)
                    System.out.println(r + "        " + c);
            }
        }
    }
}