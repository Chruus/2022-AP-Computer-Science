//Christopher Petty
void setup() {
    size(420, 600);

    heldPiece = -1;
    scale = 30;
    level = 1;
    linesCleared = 0;
    score = 0;
    
    grid = new Block[20][10];
    pieces = new Tetromino[7];
    bag1 = new ArrayList<Integer>();
    UI = new UserInterface(scale);

    pieces[0] = new PieceI(scale, grid);
    pieces[1] = new PieceJ(scale, grid);
    pieces[2] = new PieceL(scale, grid);
    pieces[3] = new PieceO(scale, grid);
    pieces[4] = new PieceS(scale, grid);
    pieces[5] = new PieceT(scale, grid);
    pieces[6] = new PieceZ(scale, grid);

    findNextPiece();
}

UserInterface UI;
ArrayList<Integer> bag1;
int level, score, linesCleared;
int scale, bagPos, heldPiece;
Block[][] grid;
boolean usingBagOne, canSwapHeldPiece;
Tetromino[] pieces;
Tetromino currentPiece;

void draw() {
    gravity();
    drawBackground();
    displayGrid();
    UI.displayCurrentStats(score, linesCleared, level);
    if(heldPiece >= 0)
        UI.displayHeldPiece(pieces[heldPiece]);
    currentPiece.displayGhost();
    currentPiece.display();
}

private void gravity(){
    if(!currentPiece.canMove("down")){
        currentPiece.addToGrid();
        findNextPiece();
        return;
    }

    if(level == 1 && frameCount % 48 == 0){
        currentPiece.move("down");
    }
    if(level == 2 && frameCount % 43 == 0){
        currentPiece.move("down");
    }
    if(level == 3 && frameCount % 38 == 0){
        currentPiece.move("down");
    }
    if(level == 4 && frameCount % 33 == 0){
        currentPiece.move("down");
    }
    if(level == 5 && frameCount % 28 == 0){
        currentPiece.move("down");
    }
    if(level == 6 && frameCount % 23 == 0){
        currentPiece.move("down");
    }
    if(level == 7 && frameCount % 18 == 0){
        currentPiece.move("down");
    }
    if(level == 8 && frameCount % 13 == 0){
        currentPiece.move("down");
    }
    if(level == 9 && frameCount % 8 == 0){
        currentPiece.move("down");
    }
    if(level == 10 && frameCount % 6 == 0){
        currentPiece.move("down");
    }
    if(level >= 11 && level <= 13 && frameCount % 5 == 0){
        currentPiece.move("down");
    }
    if(level >= 14 && level <= 16 && frameCount % 4 == 0){
        currentPiece.move("down");
    }
    if(level >= 17 && level <= 19 && frameCount % 3 == 0){
        currentPiece.move("down");
    }
    if(level >= 20 && level <= 29 && frameCount % 2 == 0){
        currentPiece.move("down");
    }
    if(level >= 30 && frameCount % 1 == 0){
        currentPiece.move("down");
    }
}

private void findNextPiece(){
    if(bag1.size() == 0){
        for(int i = 0; i < 7; i++){
            int newIndex = (int)random(0,7);
            while(bag1.contains(newIndex) && bag1.size() < 7)
                newIndex = (int)random(0,7);
            bag1.add(i, newIndex);
        }
    }

    currentPiece = pieces[bag1.remove(0)];
    currentPiece.reset();
    canSwapHeldPiece = true;

    if(!currentPiece.canMove("down")){
        System.out.println("You Lose");
        noLoop();
    }
}

private void swapHeldPiece(){
    if(!canSwapHeldPiece)
        return;
    
    canSwapHeldPiece = false;
    int oldHeldPiece = heldPiece;
    heldPiece = findIndex(currentPiece);

    if(oldHeldPiece == -1){
        findNextPiece();
        canSwapHeldPiece = false;
        return;
    }

    currentPiece = pieces[oldHeldPiece];
    currentPiece.reset();
}

private int findIndex(Tetromino piece){
    for(int i = 0; i < pieces.length; i++){
        if(piece.equals(pieces[i]))
            return i;
    }
    return -1;
}

private void drawBackground(){
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

private boolean isEmpty(Tetromino[] bag){
    for(int i = 0; i < bag.length; i++){
        if(bag[i] != null)
            return false;
    }
    return true;
}

private void displayGrid(){
    clearFullRows();
    for(int r = 0; r < grid.length; r++){
        for(int c = 0; c < grid[r].length; c++){
            if(grid[r][c] != null)
                grid[r][c].display();
        }
    }
}

private ArrayList<Integer> getFullRows(){
    ArrayList<Integer> fullRows = new ArrayList<Integer>();
    for(int r = 0; r < grid.length; r++){
        boolean isFullRow = true;
        for(int c = 0; c < grid[r].length; c++){
            if(grid[r][c] == null){
                isFullRow = false;
                break;
            }
        }
        if(isFullRow){
            fullRows.add(r);
        }
    }
    return fullRows;
}

private void clearFullRows(){
    ArrayList<Integer> fullRows = getFullRows();
    if(fullRows.size() == 0)
        return;
    calculateScore(fullRows.size());

    for(int row : fullRows){
        shiftGridDown(row);
    }
}

private void printGrid(){
    for(int r = 0; r < grid.length; r++){
        for(int c = 0; c < grid[r].length; c++){
            System.out.print('[');
            if(grid[r][c] != null)
                System.out.print(r);
            System.out.print(']');
        }
        System.out.println();
    }
}

private void calculateScore(int numOfLinesCleared){
    if(numOfLinesCleared == 1){
        linesCleared += 1;
        score += 100 * level;
    } else if(numOfLinesCleared == 2){
        linesCleared += 2;
        score += 200 * level;
    } else if(numOfLinesCleared == 3){
        linesCleared += 3;
        score += 400 * level;
    } else if(numOfLinesCleared == 4){
        linesCleared += 4;
        score += 800 * level;
    }
    level = linesCleared / 10 + 1;
}

private void shiftGridDown(int row){
    for(int r = row; r > 0; r--){
        for(int c = 0; c < grid[r].length; c++){
            grid[r][c] = grid[r - 1][c];
            if(grid[r][c] != null)
                grid[r][c].setPos(r, c);
        }
    }
    for(int c = 0; c < grid[0].length; c++){
        grid[0][c] = null;
    }
}

void keyPressed() {
    if(key == ' '){
        currentPiece.hardDrop();
    }
    if(key == 'c'){
        swapHeldPiece();
    }
    if(key == CODED){
        if(keyCode == UP){
            currentPiece.rotate(true);
        }
        if(keyCode == RIGHT && currentPiece.canMove("right")){
            currentPiece.move("right");
        }
        if(keyCode == LEFT && currentPiece.canMove("left")){
            currentPiece.move("left");
        }
        if(keyCode == DOWN && currentPiece.canMove("down")){
            currentPiece.move("down");
        }
    }
}