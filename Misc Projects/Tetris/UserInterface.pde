public class UserInterface{
    int scale;
    public UserInterface(int scale_){
        scale = scale_;
    }

    public void displayHeldPiece(Tetromino piece){
        Tetromino heldPiece = piece.clone();
        heldPiece.reset();
        heldPiece.setPos(2, 12);
        heldPiece.display();
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
    }
}