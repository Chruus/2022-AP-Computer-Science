public class Grades{
    
      public static void main(String[] args){
          double dailyAvg = 88, quizAvg = 74, testAvg = 95, sixWeeksAvg = 0;
          
          sixWeeksAvg = dailyAvg * 0.3 + quizAvg * 0.2 + testAvg * 0.5;
          
          System.out.println("Daily Average = " + dailyAvg);
          System.out.println("Quiz Average = " + quizAvg);
          System.out.println("Test Average = " + testAvg);
          System.out.println("---------------------");
          System.out.println("Six Weeks average = " + (int)sixWeeksAvg);
      }
    
}

