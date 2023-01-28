//Andrew Vallance
//add imports below
import static java.lang.System.out;

public class Gambler{
    private double money;
    private String name;
    private Die d1;
    private Die d2;
    
    public Gambler(String n)
    {
        name = n;
        d1 = new Die();
        d2 = new Die();
    }
    public Gambler(String n, double m)
    {
        name = n;
        money = m;
        d1 = new Die();
        d2 = new Die();
    }
    public Die d1()
    {
      return d1; 
    }
    public Die d2()
    {
        return d2;
    }
    public String getName()
    {
        return name;
    }
    public double getMoney()
    {
        return money;
    }
    public int getTotal()
    {
        return d1.getValue() + d2.getValue();
    }
    
    public void rollDice()
    {
        d1.rollOut();
        d2.rollOut();
    }
    public void setName(String n)
    {
        name = n;
    }
    public void addMoney(double m)
    {
        money += m;
        
    }
    public void subtractMoney(double m)
    {
        money -= m;
    }
    public String toString()
    {
        return "Name: " + name + "\nMoney: " + money + "\nDie1: " + d1.getValue() + "\nDie2: " + d2.getValue();
    }
    
}