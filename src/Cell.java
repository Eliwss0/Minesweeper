import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Cell extends JPanel {
    private boolean hasMine;
    private boolean isFlagged;
    private boolean isChecked;
    private int numOfAdjMines,x,y;
    Cell(){
        hasMine=false;
        isFlagged=false;
        numOfAdjMines=0;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isLeftMouseButton(e)) {
                    // left click
                    //check
                }
                else if (SwingUtilities.isRightMouseButton(e)) {
                    // right click
                    //set flag
                }
            }
        }
        );
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
            Main.showWinLoseAlert("You have lost.", "Game Over");
        }
    }
    void setNumOfAdjMines(int numMines){
        numOfAdjMines=numMines;
    }
    int getNumOfAdjMines(){
        return numOfAdjMines;
    }
}