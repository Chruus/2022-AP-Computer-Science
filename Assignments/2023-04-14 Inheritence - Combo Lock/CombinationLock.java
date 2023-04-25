import java.util.*;

//Christopher Petty
public class CombinationLock extends Lock {
    private String combination;

    public CombinationLock() {
        super(); // call the default constructor of the Lock class
        combination = "";
    }

    public void open() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter combination -->");
        String line = input.nextLine();

        if (line.equals(combination))
            super.open();
        else
            super.close();
    }

    public String getCombination() {
        return combination;
    }

    public void setCombination(String newCombo) {
        combination = newCombo;
    }

    public CombinationLock(String combo) {
        super();
        combination = combo;
    }

    public String toString() {
        String str = super.toString() + "\n" +
                "Combination = " + combination + "\n";
        return str;
    }
}
