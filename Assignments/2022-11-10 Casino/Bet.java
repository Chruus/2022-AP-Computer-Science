
//Andrew Vallance
//add imports below
import java.util.*;

public class Bet {
    public static void main(String[] args) {
        Die[] dice = new Die[100];
        for (int i = 0; i < dice.length; i++) {
            dice[i] = new Die(6);
        }
        Scanner in = new Scanner(System.in);
        String stop = "";

        while (stop != "-1") {
            rollDice(dice);
            int[] numberOfValues = new int[dice[0].getFaces()];
            for (Die d : dice)
                numberOfValues[d.getFaceValue() - 1]++;

            int highest = 0;
            for (int value = 1; value <= dice[0].getFaces(); value++) {
                if (numberOfValues[value - 1] > highest)
                    highest = value;
            }
            for (int num : numberOfValues)
                System.out.print(" [ " + num + " ]");
            System.out.println();
            System.out.println("The highest frequency is : " + highest);
            stop = in.nextLine();
        }

        in.close();
    }

    public static void print(Die[] d) {
        for (Die heyYou : d)// For each Die called heyYou in d
        {
            System.out.print(heyYou.getFaceValue() + " ");
        }
        System.out.println();
    }

    public static int sum(Die[] d) {
        int sum = 0;
        for (Die bob : d) {
            sum += bob.getFaceValue();

        }
        return sum;
    }

    public static void rollDice(Die[] d) {
        for (Die die : d)
            die.roll();
    }

    public static int bigVal(Die[] d) {
        int w = 0;
        for (Die arj : d) {
            if (arj.getFaceValue() > w) {
                w = arj.getFaceValue();
            }
        }
        return w;
    }

    public static int findLargest(Die[] d) {
        int largest = bigVal(d);
        for (int i = 0; i < d.length; i++) {
            if (d[i].getFaceValue() == largest) {
                return i;
            }

        }
        return -1;
    }
}