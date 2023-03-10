public abstract class Tetromino{
    int row, col;
    Block[] blocks;
    int rotation, scale;

    public Tetromino(int row_, int col_, int scale_){
        row = row_;
        col = col_;
        scale = scale_;
        blocks = new Block[4];
        rotation = 0;
    }

    public void display(){
        for(Block block : blocks){
            block.display();
        }
    }

    public void moveDown(){
        row++;
        for(Block block : blocks){
            block.setPos(block.row() + 1, block.col());
        }
    }

    public void hardDrop(Block[][] grid){
        while(canMoveDown(grid)){
            moveDown();
        }
        addToGrid(grid);
    }

    public void addToGrid(Block[][] grid){
        for(Block block : blocks){
            grid[block.row()][block.col()] = block.clone();
        }
    }

    public boolean canMoveDown(Block[][] grid){
        for(Block block : blocks){
            if(block.row == grid.length - 1 || grid[block.row() + 1][block.col()] != null){
                return false;
            }
        }
        return true;
    }

    public void move(int direction, Block[][] grid){
        final int RIGHT = 1;
        final int LEFT = -1;

        if(direction == RIGHT && canMove(RIGHT, grid)){
            col++;
            for(Block block : blocks){
                block.setPos(block.row(), block.col() + 1);
            }
        }
        if(direction == LEFT && canMove(LEFT, grid)){
            col--;
            for(Block block : blocks){
                block.setPos(block.row(), block.col() - 1);
            }
        }
    }

    public boolean canMove(int direction, Block[][] grid){
        final int RIGHT = 1;
        final int LEFT = -1;

        for(Block block : blocks){
            if(direction == RIGHT && (block.col() == grid[0].length - 1 || grid[block.row()][block.col() + 1] != null)){
                return false;
            }
            if(direction == LEFT && (block.col() == 0 || grid[block.row()][block.col() - 1] != null)){
                return false;
            }
        }
        return true;
    }

    public abstract void rotate(boolean clockwise);

    public abstract boolean canRotate(boolean clockwise, Block[][] grid);
}