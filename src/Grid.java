public class Grid {
    private int randX,randY;
    Cell[][] cellsList=new Cell[10][10];
    Grid(){
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                System.out.print("creating cell at ");
                System.out.print(x);
                System.out.print(",");
                System.out.println(y);
                cellsList[x][y] = new Cell();
            }
        }
    }
    void assignMines(){
        //Max 15 mines
        int i=0;
        while(i<15){
            randX=(int)(Math.random()*10);
            randY=(int)(Math.random()*10);

            //not working check to see if mine is already there
//            if(!cellsList[randY][randX].getHasMine()){
//                cellsList[randY][randX].setMine();
//                i++;
//            }
        }
    }
}
