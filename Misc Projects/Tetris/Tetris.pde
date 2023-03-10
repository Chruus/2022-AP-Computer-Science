//Christopher Petty
void setup() {
    size(400, 800);
    grid = new Block[20][10];
    piece = new PieceT(5, 5, 20);
}

Block[][] grid;
PieceT piece;

void draw() {
    background(255);
    piece.display();
}

void keyReleased() {
    if(key == 'r')
        piece.rotate(true);
    if(key == 's')
        piece.moveDown();
}