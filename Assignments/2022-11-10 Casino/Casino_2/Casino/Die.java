//Andrew Vallance
//add imports below
import static java.lang.System.out;

public class Die{
    private int sides;
    private int value;
    public Die(int s)
    {
        sides = s;
        value = rollOut();
    }
    public Die()
    {
        sides = 6;
        value = rollOut();
    }
    public int rollOut()
        {
          value = (int)(Math.random()*sides)+1;
          return value;
        }
        
    public int getValue(){return value;}  
    public String toString()
    {
        return "Roll Value: " + getValue() + "\nNumber of total Sides: " + sides;
    }
    }

