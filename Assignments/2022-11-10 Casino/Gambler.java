public class Gambler{
    private int balance;
    private Die die1;
    private Die die2;
    private String gamblerName;

    //Constructors
    public Gambler(String name){
        gamblerName = name;
        die1 = new Die();
        die2 = new Die();
        balance = 100;
    }
    public Gambler(String name, int money){
        gamblerName = name;
        die1 = new Die();
        die2 = new Die();
        balance = money;
    }

    //Getters
    public String getName(){
        return gamblerName;
    }
    public String getNameToString(){
        return "Name: " + gamblerName;
    }
    public Die getDie1(){
        return die1;
    }
    public String getDie1FaceValueToString(){
        return "Die1: " + die1.getFaceValue();
    }
    public Die getDie2(){
        return die2;
    }
    public String getDie2FaceValueToString(){
        return "Die2: " + die2.getFaceValue();
    }
    public int getBalance(){
        return balance;
    }
    public String getBalanceToString(){
        return "Balance: " + balance;
    }
    public int getDiceSum(){
        return die1.getFaceValue() + die2.getFaceValue();
    }


    //Setters
    public void rollDice(){
        die1.roll();
        die2.roll();
    }
    public void setName(String name){
        gamblerName = name;
    }
    public void addMoney(int money){
        balance += money;
    }
    public void takeMoney(int money){
        balance -= money;
    }
}