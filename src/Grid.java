import java.util.ArrayList;


public class Grid {
    private int maxNumOfMines;
    private int sizeX,sizeY;
    //ArrayList is size of x*y, wraps around to next line every sizeX cells
    ArrayList<Cell> cellsList=new ArrayList<>(sizeX*sizeY);
}





