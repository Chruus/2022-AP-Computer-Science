public class Die implements Comparable<Die>{
    private int faceValue;
    private int numberOfFaces;

    Die(int _numberOfFaces){
        numberOfFaces = _numberOfFaces;
        faceValue = (int)(Math.random()*numberOfFaces) + 1;
    }
    Die(){
        numberOfFaces = 6;
        faceValue = (int)(Math.random()*numberOfFaces) + 1;
    }

    //Getters
    public int getFaces(){
        return numberOfFaces;
    }
    public String getFacesToString(){
        return "There are " + numberOfFaces + " faces on the die.";
    }
    public int getFaceValue(){
        return faceValue;
    }

    //Setters
    public void roll(){
        faceValue = (int)(Math.random()*numberOfFaces) + 1;
    }

    public int compareTo(Die other){
        if(this.faceValue < other.faceValue )
            return -1;
        else if(this.faceValue > other.faceValue)
             return 1;
        else 
             return 0;
    }
}


