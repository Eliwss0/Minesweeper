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
        if(hasMine) {
            //Game over
        }
    }
    int checkForAdjMines(Cell[][] arr,int x,int y){
        if(arr[y][x+1].hasMine)
            numOfAdjMines++;
        if(arr[y+1][x].hasMine)
            numOfAdjMines++;
        if(arr[y+1][x+1].hasMine)
            numOfAdjMines++;
        if(arr[y-1][x].hasMine)
            numOfAdjMines++;
        if(arr[y][x-1].hasMine)
            numOfAdjMines++;
        if(arr[y-1][x-1].hasMine)
            numOfAdjMines++;
        if(arr[y+1][x-1].hasMine)
            numOfAdjMines++;
        if(arr[y-1][x+1].hasMine)
            numOfAdjMines++;
        return numOfAdjMines;
    }
}