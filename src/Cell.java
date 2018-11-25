class Cell {
    private boolean hasMine;
    private boolean isFlagged;
    private boolean isChecked;
    private int numOfAdjMines;
    Cell(){
        hasMine=false;
        isFlagged=false;
        numOfAdjMines=-1;
    }
    void toggleFlagged(){
        isFlagged=!isFlagged;
    }
    void setChecked(){
        isChecked=true;
    }
    void checkForAdjMines(){
        //check cell-1,cell+1,cell-sizeX-1,cell-sizeX,cell-sizeX+1,cell+sizeX-1,cell+sizeX,cell+sizeX+1
    }
}