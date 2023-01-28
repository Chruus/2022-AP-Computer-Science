import java.util.Scanner;
public class EZGrader{
    
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the number of questions answered incorrectly: ");
        int numQuestionsWrong= in.nextInt();
        System.out.print("Enter the total number of questions: ");
        int numQuestionsTotal = in.nextInt();
        
        double result;
        result = (double)(numQuestionsTotal-numQuestionsWrong)/(double)numQuestionsTotal*100;
        result+=0.5;
        
        System.out.println("Your grade is " + (int)result);
      
    }
    
}

