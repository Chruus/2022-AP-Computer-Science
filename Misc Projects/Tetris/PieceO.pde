public class PieceO extends Tetromino{
    public PieceO(int row_, int col_, int scale_){
        super(row_, col_, scale_);
        color clr = color(25, 25, 255);
        blocks[0] = new Block(row, col, scale, clr);
        blocks[1] = new Block(row - 1, col, scale, clr);
        blocks[2] = new Block(row + 1, col, scale, clr);
        blocks[3] = new Block(row + 1, col - 1, scale, clr);
    }

    public void rotate(boolean clockwise){
        if(clockwise){
            rotation++;
        } else {
            rotation --;
        }
        if(rotation > 3){
            rotation = 0;
        }
        if(rotation < 0){
            rotation = 3;
        }

        if(rotation == 0){
            blocks[0].setPos(row, col);
            blocks[1].setPos(row - 1, col);
            blocks[2].setPos(row + 1, col);
            blocks[3].setPos(row + 1, col - 1);
        } else if(rotation == 1){
            blocks[0].setPos(row, col);
            blocks[1].setPos(row, col + 1);
            blocks[2].setPos(row, col - 1);
            blocks[3].setPos(row - 1, col - 1);
        } else if(rotation == 2){
            blocks[0].setPos(row, col);
            blocks[1].setPos(row + 1, col);
            blocks[2].setPos(row - 1, col);
            blocks[3].setPos(row - 1, col + 1);
        } else if(rotation == 3){
            blocks[0].setPos(row, col);
            blocks[1].setPos(row, col - 1);
            blocks[2].setPos(row, col + 1);
            blocks[3].setPos(row + 1, col + 1);
        }
    }

    public boolean canRotate(boolean clockwise, Block[][] grid){
        int rotationToCheck = rotation;
        if(clockwise){
            rotationToCheck++;
        } else {
            rotationToCheck --;
        }
        if(rotationToCheck > 3){
            rotationToCheck = 0;
        }
        if(rotationToCheck < 0){
            rotationToCheck = 3;
        }

        if(rotationToCheck == 0
        && (grid[row][col] != null
        || grid[row - 1][col] != null
        || grid[row + 1][col] != null
        || grid[row + 1][col + 1] != null)){
            return false;
        } else if(rotationToCheck == 1
        && (grid[row][col] != null
        || grid[row][col + 1] != null
        || grid[row][col - 1] != null
        || grid[row + 1][col - 1] != null)){
            return false;
        } else if(rotationToCheck == 2
        && (grid[row][col] != null
        || grid[row + 1][col] != null
        || grid[row - 1][col] != null
        || grid[row - 1][col - 1] != null)){
            return false;
        } else if(rotationToCheck == 3
        && (grid[row][col] != null
        || grid[row][col - 1] != null
        || grid[row][col + 1] != null
        || grid[row - 1][col + 1] != null)){
            return false;
        }
        return true;
    }
}