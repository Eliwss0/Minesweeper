public class Grid {
    private int randX,randY;
    Cell[][] cellsList=new Cell[10][10];
    Grid(){}
    void assignMines(){
        //Max 15 mines
        int i=0;
        while(i<15){
            randX=(int)(Math.random()*10);
            randY=(int)(Math.random()*10);
            i++;
        }
    }
    int checkForAdjMines(Cell[][] arr,int x,int y){
        int numOfAdjMines=0;
        if(arr[y][x+1].getHasMine()) //check right
            numOfAdjMines++;
        if(arr[y+1][x].getHasMine()) //check up
            numOfAdjMines++;
        if(arr[y+1][x+1].getHasMine()) //check up-right
            numOfAdjMines++;
        if(arr[y-1][x].getHasMine()) //check down
            numOfAdjMines++;
        if(arr[y][x-1].getHasMine()) //check left
            numOfAdjMines++;
        if(arr[y-1][x-1].getHasMine()) //check down-left
            numOfAdjMines++;
        if(arr[y+1][x-1].getHasMine()) //check up-left
            numOfAdjMines++;
        if(arr[y-1][x+1].getHasMine()) //check down-right
            numOfAdjMines++;
        return numOfAdjMines;
    }
    void revealAdj(Cell[][] arr,int y,int x){
        //woo recursion
        if (arr[y][x + 1].getNumOfAdjMines() == 0) //check right
            revealAdj(cellsList,y,x+1);
        if (arr[y + 1][x].getNumOfAdjMines() == 0) //check up
            revealAdj(cellsList,y+1,x);
        if (arr[y + 1][x + 1].getNumOfAdjMines() == 0) //check up-right
            revealAdj(cellsList,y+1,x+1);
        if (arr[y - 1][x].getNumOfAdjMines() == 0) //check down
            revealAdj(cellsList,y-1,x);
        if (arr[y][x - 1].getNumOfAdjMines() == 0) //check left
            revealAdj(cellsList,y,x-1);
        if (arr[y - 1][x - 1].getNumOfAdjMines() == 0) //check down-left
            revealAdj(cellsList,y-1,x-1);
        if (arr[y + 1][x - 1].getNumOfAdjMines() == 0) //check up-left
            revealAdj(cellsList,y+1,x-1);
        if (arr[y - 1][x + 1].getNumOfAdjMines() == 0) //check down-right
            revealAdj(cellsList,y-1,x+1);
    }
}
