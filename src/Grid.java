public class Grid {
    //maxNumOfMines, sizeX, and sizeY should be provided by user before beginning the game
    private int maxNumOfMines;
    private int sizeX,sizeY,randX,randY;
    Cell[][] cellsList=new Cell[sizeY][sizeX];
    Grid() {
        //Randomly place mines
        int i=0;
        while(i<maxNumOfMines){
            randX=(int)(Math.random()*sizeX);
            randY=(int)(Math.random()*sizeY);
            if(!cellsList[randY][randX].getHasMine()){
                cellsList[randY][randX].setMine();
                i++;
            }
        }
    }
}
