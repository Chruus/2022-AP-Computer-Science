import java.util.*;
import java.io.*;

public class SpellCheck {
    // instance variable
    private ArrayList<String> wordList;

    // constructor
    public SpellCheck() {
        wordList = new ArrayList<String>();
        readFile();
        searchWords();
    }

    // Performs a binary search on the wordlist looking for key.
    // If key is found, it returns true;
    // otherwise it returns false
    public boolean binarySearch(String key) {
        int start = 0;
        int stop = wordList.size() - 1;
        int index = (int) (wordList.size() / 2);

        while (stop >= start) {
            index = (stop + start) / 2;
            int comparison = wordList.get(index).compareTo(key);

            if (comparison == 0)
                return true;
            if (start > stop)
                return false;

            if (comparison < 0) {
                start = index + 1;
            } else if (comparison > 0) {
                stop = index - 1;
            }
        }
        return false;
    }

    // Interface used to check spelling of words
    public void searchWords() {
        Scanner keyboard = new Scanner(System.in);
        String ans = "Y";
        while (ans.equalsIgnoreCase("Y")) {
            System.out.print("Enter word -->");
            String word = keyboard.nextLine();
            System.out.println();

            if (binarySearch(word) == true)
                System.out.println(word + " is spelled correctly.");
            else {
                System.out.println(word + " is spelled incorrectly!");
            }

            System.out.println();
            System.out.print("Enter another word[Y/N]? ");
            ans = keyboard.nextLine();
            System.out.println();
        }
    }

    // Populates wordlist from a text file a words
    public void readFile() {
        System.out.println("Reading wordlist ...");
        System.out.println();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("spellcheck.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }

        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            wordList.add(str);
        }
    }

    public static void main(String[] args) {
        SpellCheck spellCheck = new SpellCheck();
    }
}