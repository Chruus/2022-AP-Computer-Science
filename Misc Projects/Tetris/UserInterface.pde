public class UserInterface{
    int scale;
    boolean hasChangedMenu, needToResetGame;
    boolean inMenu, inGame, inGameOver;
    Button returnToMenu, playAgain, play;
    ScoreFile file;
    public UserInterface(int scale_){
        scale = scale_;
        
        color backgroundColor = color(225, 225, 255);
        color textColor = color(0);

        inMenu = true;
        inGame = inGameOver = false;

        file = new ScoreFile();
        play = new Button("Play", textColor, width / 2, 5 * scale, 10 * scale, 4 * scale, backgroundColor);
        playAgain = new Button("Play Again", textColor, width / 2, (int)(16.5 * scale), 5 * scale, 2 * scale, backgroundColor);
        returnToMenu = new Button("Return to Menu", textColor, width / 2, (int)(13.5 * scale), 5 * scale, 2 * scale, backgroundColor);
    }

    public void displayHeldPiece(Tetromino piece){
        if(piece == null)
            return;
        Tetromino heldPiece = piece.clone();
        heldPiece.reset();
        heldPiece.setPos(2, 12);
        heldPiece.display();
    }

    public void displayFuturePieces(ArrayList<Tetromino> pieces){
        pieces.get(0).setPos(6, 12);
        pieces.get(1).setPos(9, 12);
        pieces.get(2).setPos(12, 12);
        for(Tetromino piece : pieces){
            piece.display();
        }
    }

    public boolean hasBeenPressed(){
        if(play.hasBeenPressed() || playAgain.hasBeenPressed()){
            inGame = needToResetGame = true;
            inGameOver = inMenu = false;
            return true;
        }
        if(inGameOver && returnToMenu.hasBeenPressed()){
            inMenu = true;
            inGameOver = inGame = false;
            return true;
        }
        return false;
    }

    public boolean needToResetGame(){
        if(needToResetGame){
            needToResetGame = false;
            return true;
        }
        return false;
    }

    public void displayMenu(){
        pushStyle();
        pushMatrix();
        
        background(0, 100);
        play.display();
    
        textAlign(CENTER);
        textSize(scale);
        fill(255);
        
        text("Highest Score:\n" + file.hiScore(), width / 2, 10 * scale);
        text("Highest Lines:\n" + file.hiLines(), width / 2, 13 * scale);
        text("Highest Level:\n" + file.hiLevel(), width / 2, 16 * scale);

        popMatrix();
        popStyle();

        hasBeenPressed();
    }

    public boolean isInGame(){
        return inGame;
    }

    public void gameOver(){
        inGameOver = true;
        inMenu = inGame = false;
    }

    public boolean isInGameOver(){
        return inGameOver;
    }

    public boolean isInMenu(){
        return inMenu;
    }

    public void displayGameOver(int score, int linesCleared, int level){
        inGameOver = true;
        inGame = inMenu = false;
        file.saveScores(score, linesCleared, level);

        pushStyle();
        pushMatrix();

        background(0, 100);
        playAgain.display();
        returnToMenu.display();
    
        textAlign(CENTER);
        textSize(scale);
        fill(255);
        
        text("Score:", width / 2, 3 * scale);
        text(score, width / 2, 4.25 * scale);
        text("Lines:", width / 2, 6 * scale);
        text(linesCleared, width / 2, 7.25 * scale);
        text("Level:", width / 2, 9 * scale);
        text(level, width / 2, 10.25 * scale);

        popMatrix();
        popStyle();

        hasBeenPressed();
    }

    public void displayCurrentStats(int score, int linesCleared, int level){
        pushStyle();
        pushMatrix();

        textAlign(LEFT);
        textSize(scale * 0.5);
        fill(255);

        int x = scale / 2 * 21;
        int y = scale * 17;
        
        text("Score:\n" + score, x, y - scale * 1.65);
        text("Lines:\n" + linesCleared, x, y);
        text("Level:\n" + level, x, y + scale * 1.65);

        popMatrix();
        popStyle();
        
        hasBeenPressed();
    }

    public void mousePressed(){
        if(inMenu){
            play.mousePressed();
        }
        if(inGameOver){
            playAgain.mousePressed();
            returnToMenu.mousePressed();
        }
    }

    public void mouseReleased(){
        if(inMenu)
            play.mouseReleased();
        if(inGameOver){
            playAgain.mouseReleased();
            returnToMenu.mouseReleased();
        }
    }

    /*private void displayUIBackground(){
        pushMatrix();
        pushStyle();

        color[] colors;
        colors = {color(255, 0, 0), color(125, 0, 255), color(25, 240, 25), color(245, 245, 0), clr = color(255, 125, 0), color(50, 50, 255), color(0, 255, 255)};
        
        for(int r = scale / 2; r < grid.length(); r += scale){
            for(int c = scale / 2; c < grid.width(); c += scale){
                color clr = colors[(int)(Math.random() * 7)];
                fill(clr);
                rect(c, r, scale, scale);
            }
        }

        popStyle();
        popMatrix();
    }*/

    public void displayBackground(){
        pushMatrix();
        pushStyle();

        background(30, 30, 40);
        strokeWeight(2);
        stroke(15, 15, 20);
        for(int x = 0; x <= scale * 10; x += scale){
            line(x, 0, x, scale * 20);
        }
        for(int y = 0; y <= scale * 20; y += scale){
            line(0, y, scale * 10, y);
        }

        popStyle();
        popMatrix();
    }
}