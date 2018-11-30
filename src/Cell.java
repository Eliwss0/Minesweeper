import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Cell extends JPanel {
    private boolean hasMine;
    private boolean isFlagged;
    private boolean isChecked;
    private int numOfAdjMines;

    Cell() {
        hasMine = false;
        isFlagged = false;
        numOfAdjMines = 0;
    }

    boolean getHasMine() {
        return hasMine;
    }

    void setMine() {
        hasMine = true;
    }

    void toggleFlagged() {
        isFlagged = !isFlagged;
    }

    boolean getFlagged() {
        return isFlagged;
    }

    void setChecked() {
        isChecked = true;
    }

    void setNumOfAdjMines(int numMines) {
        numOfAdjMines = numMines;
    }

    int getNumOfAdjMines() {
        return numOfAdjMines;
    }
}