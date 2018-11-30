import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Grid extends JPanel {
    private int randX,randY, width, height, rows, cols;

    Cell[][] cellsList = new Cell[10][10];

    Grid(int w, int h, int r, int c) {

        initializeCells();
        assignMines();

        addMouseListener(new MineClicker());

        setSize(width = w, height = h);
        rows = r;
        cols = c;
    }

    public void checkCell(Cell[][] cl,int y,int x){
        if(cl[y][x].getHasMine())
            Main.showWinLoseAlert("You have lost.", "Game Over");
        if(cl[y][x].getNumOfAdjMines()==0){
            revealAdj(cl,y,x);
        }
        //set image on cell to number of adj mines here
        cl[y][x].setChecked();
    }

    @Override
    public void paintComponent(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        int i;
        width = getSize().width;
        height = getSize().height;

        // draw the rows
        int rowHt = height / (rows);
        for (i = 0; i < rows; i++)
            g.drawLine(0, i * rowHt, width, i * rowHt);

        // draw the columns
        int rowWid = width / (cols);
        for (i = 0; i < cols; i++)
            g.drawLine(i * rowWid, 0, i * rowWid, height);

        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
//                g.drawString("M", (y * 50) + 25, (x * 50) + 25);
                if (cellsList[x][y].getFlagged()) {
                    g.drawString("F", (x * 50) + 25, (y * 50) + 25);
                }
                else if (cellsList[x][y].getMinePressed()) {
                    g.drawString("M", (x * 50) + 25, (y * 50) + 25);
                }
                else {
                    int mines = cellsList[x][y].getNumOfAdjMines();
                    if (mines != 0) {
                        g.drawString(String.valueOf(cellsList[x][y].getNumOfAdjMines()), (y * 50) + 25, (x * 50) + 25);
                    }
                }
            }
        }
    }

    void initializeCells(){
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                cellsList[i][j]=new Cell();
            }
        }
    }

    void assignMines(){
        //Max 15 mines
        int i=0;
        while(i<15){
            randX=(int)(Math.random()*10);
            randY=(int)(Math.random()*10);
            cellsList[randY][randX].setMine();
            i++;
        }
    }

    void checkForTouchingMines(Cell[][] cells, int x, int y) {

        System.out.println("checking " + String.valueOf(x) + "," + String.valueOf(y));

        int mines = 0;

        boolean leftMines = (x != 0) && cells[x - 1][y].getHasMine();
        if (leftMines) {
            mines++;
        }
        boolean topLeftMines = (x != 0 && y != 0) && cells[x - 1][y + 1].getHasMine();
        if (topLeftMines) {
            mines++;
        }
        boolean topMines = (y != 0) && cells[x][y + 1].getHasMine();
        if (topMines) {
            mines++;
        }
        boolean topRightMines = (x != 9 && y != 0) && cells[x + 1][y + 1].getHasMine();
        if (topRightMines) {
            mines++;
        }
        boolean rightMines = (x != 9) && cells[x + 1][y].getHasMine();
        if (rightMines) {
            mines++;
        }
        boolean bottomRightMines = (x != 9 && y != 9) && cells[x + 1][y + 1].getHasMine();
        if (bottomRightMines) {
            mines++;
        }
        boolean bottomMines = (y != 9) && cells[x][y + 1].getHasMine();
        if (bottomMines) {
            mines++;
        }
        boolean bottomLeftMines = (x != 0 && y != 10) && cells[x - 1][y + 1].getHasMine();
        if (bottomLeftMines) {
            mines++;
        }

        if (mines == 0) {
            //TODO: reveal mines
            System.out.println("revealing empty cells...");
//            revealTouchingMines(cells, x, y);
//            revealAdj(cells, x, y);

            repaint();
        }

        cellsList[x][y].setNumOfAdjMines(mines);
    }

    void checkForAdjMines(Cell[][] arr, int x, int y){

        System.out.println("checking " + String.valueOf(x) + "," + String.valueOf(y));

        int numOfAdjMines=0;
        if(arr[y][x+1].getHasMine() && x < 10) //check right
            numOfAdjMines++;
        if(arr[y+1][x].getHasMine() && y < 10) //check up
            numOfAdjMines++;
        if(arr[y+1][x+1].getHasMine() && x<10 && y < 10) //check up-right
            numOfAdjMines++;
        if(arr[y-1][x].getHasMine() && y > 0) //check down
            numOfAdjMines++;
        if(arr[y][x-1].getHasMine() && x > 0) //check left
            numOfAdjMines++;
        if(arr[y-1][x-1].getHasMine() && y > 0 && x > 0) //check down-left
            numOfAdjMines++;
        if(arr[y+1][x-1].getHasMine() && y < 10 && x > 0) //check up-left
            numOfAdjMines++;
        if(arr[y-1][x+1].getHasMine() && y > 0 && x < 10) //check down-right
            numOfAdjMines++;

        if (numOfAdjMines == 0) {
            revealAdj(cellsList, y, x);
        }

        cellsList[y][x].setNumOfAdjMines(numOfAdjMines);
        //if empty w/ no adj mines, start revealAdj
    }

    void revealAdj(Cell[][] arr,int y,int x){
        //woo recursion
        if (arr[y][x + 1].getNumOfAdjMines() == 0&&x<10) //check right
            revealAdj(cellsList,y,x+1);
        if (arr[y + 1][x].getNumOfAdjMines() == 0&&y<10) //check up
            revealAdj(cellsList,y+1,x);
        if (arr[y + 1][x + 1].getNumOfAdjMines() == 0&&y<10&&x<10) //check up-right
            revealAdj(cellsList,y+1,x+1);
        if (arr[y - 1][x].getNumOfAdjMines() == 0&&y>0) //check down
            revealAdj(cellsList,y-1,x);
        if (arr[y][x - 1].getNumOfAdjMines() == 0&&x>0) //check left
            revealAdj(cellsList,y,x-1);
        if (arr[y - 1][x - 1].getNumOfAdjMines() == 0&&y>0&&x>0) //check down-left
            revealAdj(cellsList,y-1,x-1);
        if (arr[y + 1][x - 1].getNumOfAdjMines() == 0&&y<10&&x>0) //check up-left
            revealAdj(cellsList,y+1,x-1);
        if (arr[y - 1][x + 1].getNumOfAdjMines() == 0&&y>0&&x<10) //check down-right
            revealAdj(cellsList,y-1,x+1);
    }

    private class MineClicker extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent event) {
            int mouseX = event.getX();
            int mouseY = event.getY();
            int cellX = mouseX / 50;
            int cellY = mouseY /50;

            if (mouseX < 500 && mouseY < 500) {
                System.out.print("pressed mouse at ");
                System.out.print(cellX);
                System.out.print(",");
                System.out.println(cellY);
                if (event.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("place flag");
                    cellsList[cellX][cellY].toggleFlagged();

//                    revalidate();
                    repaint();
                }
                else {
                    System.out.println("checking for mine");
                    if (cellsList[cellX][cellY].getHasMine()) {
                        cellsList[cellX][cellY].setMinePresed(true);
                        repaint();
                        Main.showWinLoseAlert("You have lost.", "Game Over");
                        //TODO: clean game and start over
                    }
                    else {
                        checkForTouchingMines(cellsList, cellY, cellX);
//                        checkForAdjMines(cellsList, col, row);
                    }

//                    revalidate();
                    repaint();
                }
            }
        }
    }
}
