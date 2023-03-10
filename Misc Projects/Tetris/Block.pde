public class Block{
    private int row, col, scale;
    private color clr;
    
    public Block(int row_, int col_, int scale_, color clr_){
        row = row_;
        col = col_;
        clr = clr_;
        scale = scale_;
    }

    public void display(){
        pushStyle();
        pushMatrix();

        int x = (col + 1) * scale - scale / 2;
        int y = (row + 1) * scale - scale / 2;
        rectMode(CENTER);
        strokeWeight(0);
        fill(clr);
        rect(x, y, scale * 0.9, scale * 0.9);

        popMatrix();
        popStyle();
    }

    public int row(){
        return row;
    }

    public int col(){
        return col;
    }

    public color clr(){
        return clr;
    }

    public void setPos(int newRow, int newCol){
        row = newRow;
        col = newCol;
    }

    public Block clone(){
        return new Block(row, col, scale, clr);
    }
}