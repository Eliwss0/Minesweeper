import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Cell extends JPanel {
    private boolean hasMine;
    private boolean isFlagged;
    private boolean isChecked;
    private int numOfAdjMines, x, y;
    private String imageToLoad = "images/blank";
    private BufferedImage image;

    Cell(){
        hasMine = false;
        isFlagged = false;
        numOfAdjMines = 0;

        this.add(new JLabel("B"));
        addMouseListener(new java.awt.event.MouseAdapter() {

        });
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
            Main.showWinLoseAlert("You have lost.", "Game Over");
        }
    }
    void clicked(java.awt.event.MouseEvent event) {
        JPanel panel = (JPanel)event.getSource();
        if (SwingUtilities.isRightMouseButton(event)) {
            System.out.println("right click");
        }
        else if (SwingUtilities.isLeftMouseButton(event)) {
            System.out.println("left click");
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}