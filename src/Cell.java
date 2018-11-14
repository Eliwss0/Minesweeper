class Cell {
    private boolean hasMine;
    private boolean isFlagged;
    private int numOfAdjMines;
    Cell(){
        hasMine=false;
        isFlagged=false;
        numOfAdjMines=-1;
    }
}