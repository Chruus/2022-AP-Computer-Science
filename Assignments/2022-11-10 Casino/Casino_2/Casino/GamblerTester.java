//Andrew Vallance
//add imports below
import static java.lang.System.out;

public class GamblerTester{
    public static void main(String[] args){
        Gambler g = new Gambler("Andrew");
        g.rollDice();
        g.toString();
        System.out.println(g);
        
    }
}