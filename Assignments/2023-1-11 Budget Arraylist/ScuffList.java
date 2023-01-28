//Christopher Petty

import java.io.*;
import java.util.*;

public class ScuffList implements Runnable {

    private int buffer;
    private int length;
    private int[] arr;

    public ScuffList() {
        buffer = 2;
        length = 0;
        arr = new int[0];
        run();
    }

    public void remove(int pos) throws IOException {
        run();
        checkForOOB(pos);
        shiftToPoint(pos);
        length--;
    }

    public void checkForOOB(int pos) throws IOException {
        if (pos >= length)
            throw new IOException("Index Out of Bounds: Position " + pos + " in BudgetIntArrayList size " + length);
    }

    public void add(int pos, int num) throws IOException {
        run();
        length++;
        checkForOOB(pos);
        shiftToSide(pos);
        arr[pos] = num;
    }

    private void shiftToSide(int pos) {
        for (int i = length; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
    }

    private void shiftToPoint(int pos) {
        for (int i = pos; i < length; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public int size() {
        return length;
    }

    public int get(int pos) throws IOException {
        checkForOOB(pos);
        return arr[pos];
    }

    public int set(int pos, int num) throws IOException {
        checkForOOB(pos);
        int output = arr[pos];
        arr[pos] = num;
        return output;
    }

    public String toString() {
        String output = "";
        for (int pos = 0; pos < arr.length - buffer; pos++)
            output += " " + arr[pos] + ",";

        if (output.equals(""))
            return "[]";

        output = "[" + output.substring(1, output.length() - 1) + "]";
        return output;
    }

    public void run() {
        while (arr.length < length + buffer) {
            int[] temp = arr;
            arr = new int[temp.length + 1];
            for (int pos = 0; pos < temp.length - 1; pos++)
                arr[pos] = temp[pos];
        }
        while (arr.length > length + buffer) {
            int[] temp = arr;
            arr = new int[temp.length - 1];
            for (int pos = 0; pos < arr.length - 1; pos++)
                arr[pos] = temp[pos];
        }
    }

    public int length() {
        return length;
    }
}

class testor {
    public static void main(String[] args) throws IOException {
        ScuffList arrlst = new ScuffList();

        arrlst.add(0, 1);
        arrlst.add(1, 3);
        arrlst.add(arrlst.size() / 2, 2);
        arrlst.add(arrlst.size(), 4);
        System.out.println(arrlst + "\n");
        comparison();
    }

    public static void comparison() throws IOException {
        ScuffList arrlst1 = new ScuffList();
        ArrayList<Integer> arrlst2 = new ArrayList<Integer>();
        arrlst1.add(0, 0);
        arrlst2.add(0, 0);

        double startTime = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            arrlst2.set(0, i);
        }
        double endTime = System.currentTimeMillis();
        System.out.println("ArrayList setting time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            arrlst1.set(0, i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ScuffList setting time: " + (endTime - startTime) + "\n");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrlst2.add(0, i);
            if (i == 50000)
                System.out.println(System.currentTimeMillis() - startTime);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList adding time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrlst1.add(0, i);
            if (i == 50000)
                System.out.println(System.currentTimeMillis() - startTime);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ScuffList adding time: " + (endTime - startTime) + "\n");
    }
}