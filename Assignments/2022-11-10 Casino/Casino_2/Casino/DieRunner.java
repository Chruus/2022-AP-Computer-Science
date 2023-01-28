//Andrew Vallance
//add imports below
import static java.lang.System.out;

public class DieRunner{
    public static void main(String[] args){
        Die d = new Die();
        d.rollOut();
        System.out.println(d.getValue());
    }
}