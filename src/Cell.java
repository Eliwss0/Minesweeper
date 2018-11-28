class Cell {
    private boolean hasMine;
    private boolean isFlagged;
    private boolean isChecked;
    private int numOfAdjMines;
    Cell(){
        hasMine=false;
        isFlagged=false;
        numOfAdjMines=0;
    }
    boolean getHasMine(){
        return hasMine;
    }
    void setMine(){
        hasMine=true;
    }
    void toggleFlagged(){
        isFlagged=!isFlagged;
    }
    void setChecked(){
        isChecked=true;
        if(hasMine) {
            //TODO: Game over
        }
    }
    int checkForAdjMines(Cell[][] arr,int x,int y){
        if(arr[y][x+1].hasMine) //check right
            numOfAdjMines++;
        if(arr[y+1][x].hasMine) //check up
            numOfAdjMines++;
        if(arr[y+1][x+1].hasMine) //check up-right
            numOfAdjMines++;
        if(arr[y-1][x].hasMine) //check down
            numOfAdjMines++;
        if(arr[y][x-1].hasMine) //check left
            numOfAdjMines++;
        if(arr[y-1][x-1].hasMine) //check down-left
            numOfAdjMines++;
        if(arr[y+1][x-1].hasMine) //check up-left
            numOfAdjMines++;
        if(arr[y-1][x+1].hasMine) //check down-right
            numOfAdjMines++;
        return numOfAdjMines;
    }
}