
//Christopher Petty
import java.util.*;
import java.io.*;

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            list.add((int) (Math.random() * 101));
        }
        System.out.println(list);
        long start = System.currentTimeMillis();
        sort(list);
        long end = System.currentTimeMillis();
        System.out.println(list + "\n" + (end - start));
    }

    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i + 1) < list.get(i)) {
                int temp = list.get(i + 1);
                list.set(i + 1, list.get(i));
                list.set(i, temp);
                i = -1;
            }
        }
    }
}