/*import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class Main extends JFrame {

    public static void main(String[] args) {
        //Window to get game parameters
//        JFormattedTextField xSize,ySize,mineNum;
//        NumberFormatter numFormat=new NumberFormatter();
//        numFormat.setValueClass(Integer.class);
//        JPanel gameParamPanel=new JPanel();
//        JFrame gameParameters=new JFrame("Minesweeper Parameters");
//        gameParamPanel.setLayout(new BoxLayout(gameParamPanel,BoxLayout.PAGE_AXIS));
//        xSize=new JFormattedTextField(numFormat);
//        JLabel widthX=new JLabel("Width of play field");
//        ySize=new JFormattedTextField(numFormat);
//        JLabel heightY=new JLabel("Height of play field");
//        mineNum=new JFormattedTextField(numFormat);
//        JLabel numOfMines=new JLabel("Number of mines");
//        JButton confirmParameters=new JButton();
//        ActionListener confirm=new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int xSquares=0,ySquares=0;
//                Grid grid=new Grid();
//                grid.assignMines();
//            }
//        };
//        confirmParameters.addActionListener(confirm);
//        confirmParameters.setText("Confirm");
//        gameParamPanel.add(widthX);
//        gameParamPanel.add(xSize);
//        gameParamPanel.add(heightY);
//        gameParamPanel.add(ySize);
//        gameParamPanel.add(numOfMines);
//        gameParamPanel.add(mineNum);
//        gameParameters.add(gameParamPanel);
//        gameParameters.add(confirmParameters,BorderLayout.SOUTH);
//        gameParameters.setSize(300,175);
//        gameParameters.setLocationRelativeTo(null);
//        gameParameters.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        gameParameters.setVisible(true);

        //images are 17x17, maybe scale grid by number of cells?
        Grid mine = new Grid(500, 500, 10, 10);

        JFrame appFrame = new JFrame();
        appFrame.setSize(500, 520);
        appFrame.setTitle("Minesweeper");
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);

        appFrame.add(mine);
        //appFrame.pack();
        appFrame.setResizable(false);
//        Grid grid=new Grid();
//        mine.initializeCells();
//        mine.assignMines();
        mine.setLayout(new GridLayout(10,10));
//        for (int x = 0; x < 10; x++) {
//            for (int y = 0; y < 10; y++) {
//                mine.add(grid.cellsList[x][y]);
//            }
//        }
    }

    public static void showWinLoseAlert(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Main implements ActionListener {

    JFrame frame = new JFrame("Mine Sweeper");
    JButton reset = new JButton("Reset");
    JButton[][] buttons = new JButton[20][20];//button array
    JButton[] flags = new JButton[20];
    int[][] counts = new int[20][20];
    Container grid = new Container(); //grid for buttons
    int MineNum = 50;//number of mines
    final int MINE = 10;//int value to identify a mine



    public Main() {
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.add(reset, BorderLayout.NORTH);
        reset.addActionListener(this);
        //Grid of Buttons
        grid.setLayout(new GridLayout(20,20));
        for (int a = 0; a<buttons.length; a++) {
            for (int b = 0; b < buttons[0].length; b++) {
                buttons[a][b] = new JButton("▒");
                buttons[a][b].addActionListener(this);
                buttons[a][b].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getButton() == MouseEvent.BUTTON3) {
                            mineFlagger(true);
                        }
                    }
                });
                grid.add(buttons[a][b]);
            }
        }
        frame.add(grid, BorderLayout.CENTER);
        makeRandomMines();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void mineFlagger (boolean flag){
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {
                if(flag == true) {
                    buttons[i][j].setText("F");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    public void makeRandomMines() {
        //initializes list of random pairs
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int x = 0; x < counts.length; x++) {
            for (int y = 0; y < counts[0].length; y++) {
                list.add(x * 100 + y);//changed y to x
            }
        }
        //resets the counts in case reset button is pressed & picks random mines
        counts = new int[20][20];
        for (int i = 0; i < MineNum; i++) {
            int choice = (int) (Math.random() * list.size());
            counts[list.get(choice) / 100][list.get(choice) % 100] = MINE;
            list.remove(choice);
        }
        //neighbor counts(how many mines are touching this square.)
        for (int x = 0; x < counts.length; x++) {
            for (int y = 0; y < counts[0].length; y++) {
                int neighborCount = 0;
                if (counts[x][y] != MINE) {
                    if(x > 0 && y > 0 && counts[x - 1][y - 1] == MINE) { //a mine is up & left
                        neighborCount++;
                    }
                    if(y > 0 && counts[x][y - 1] == MINE) { //a mine is up
                        neighborCount++;
                    }
                    if(x < counts.length - 1 && y > 0 && counts[x + 1][y - 1] == MINE) { // a mine is left
                        neighborCount++;
                    }
                    if(x > 0 && counts[x - 1][y] == MINE) { //left
                        neighborCount++;
                    }
                    if(x < counts.length - 1 && counts[x + 1][y] == MINE) { //mine is right
                        neighborCount++;
                    }
                    if(x > 0 && y < counts[0].length - 1 && counts[x - 1][y + 1] == MINE) { //mine is down
                        neighborCount++;
                    }
                    if(y < counts[0].length - 1 && counts[x][y + 1]== MINE) {//mine is up right
                        neighborCount++;
                    }
                    if(x < counts[0].length - 1 && y < counts[0].length - 1 && counts[x + 1][y + 1]== MINE) {//mine is down left
                        neighborCount++;
                    }
                    counts[x][y] = neighborCount;
                }
            }
        }
    }

    public void lostGame() {
        for (int x = 0; x < buttons.length; x++) {
            for (int y = 0; y < buttons[0].length; y++) {
                if (buttons[x][y].isEnabled()) {
                    if (counts[x][y] != MINE) {
                        buttons[x][y].setText(counts[x][y] + "");
                        buttons[x][y].setEnabled(false);
                    }
                    else {
                        buttons[x][y].setText("✪");
                        buttons[x][y].setEnabled(false);
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "You Lose!\n" + "You clicked on a mine!", "BOOM!", JOptionPane.INFORMATION_MESSAGE);
    }

    public void checkWin() {
        boolean winner = true;

        for (int x = 0; x < counts.length; x++) {
            for (int y = 0; y < counts[0].length; y++) {
                if (counts[x][y] != MINE && buttons[x][y].isEnabled()) {
                    winner = false;
                }
            }
        }
        if (winner == true) {
            JOptionPane.showMessageDialog(frame, "You win!");
        }
    }

    public void zeroCleaner(ArrayList<Integer> toClear) {
        if (toClear.size() == 0) {
            return;
        }
        else {
            int x = toClear.get(0) / 100;
            int y = toClear.get(0) % 100;
            toClear.remove(0);
            if(x > 0 && y > 0 && buttons[x-1][y-1].isEnabled()) { //up and left
                buttons[x - 1][y - 1].setText(counts[x-1][y-1] + "");
                buttons[x - 1][y - 1].setEnabled(false);
                if (counts[x - 1][y - 1] == 0) {
                    toClear.add((x-1) * 100 + (y-1));
                }
            }
            if (y > 0 && buttons[x][y-1].isEnabled()) { // up
                buttons[x][y - 1].setText(counts[x][y-1] + "");
                buttons[x][y - 1].setEnabled(false);
                if (counts[x][y - 1] == 0) {
                    toClear.add(x * 100+(y - 1));
                }
            }
            if (x < counts.length - 1 && y > 0 && buttons[x+1][y-1].isEnabled()) { //up right
                buttons[x + 1][y - 1].setText(counts[x+1][y-1] + "");
                buttons[x + 1][y - 1].setEnabled(false);
                if (counts[x + 1][y - 1] == 0) {
                    toClear.add((x + 1)*100+(y - 1));
                }
            }
            if(x > 0 && y > 0 && buttons[x-1][y].isEnabled()) { //left
                buttons[x - 1][y].setText(counts[x-1][y] + "");
                buttons[x - 1][y].setEnabled(false);
                if (counts[x-1][y] == 0) {
                    toClear.add((x-1)*100+y);
                }
            }
            if (x < counts.length - 1 && buttons[x+1][y].isEnabled()) { //right
                buttons[x + 1][y].setText(counts[x+1][y] + "");
                buttons[x + 1][y].setEnabled(false);
                if (counts[x + 1][y] == 0) {
                    toClear.add((x + 1)*100+y);
                }
            }
            if(x > 0 && y < counts[0].length - 1 && buttons[x-1][y+1].isEnabled()) { //down and left
                buttons[x - 1][y + 1].setText(counts[x-1][y+1] + "");
                buttons[x - 1][y + 1].setEnabled(false);
                if (counts[x-1][y+1] == 0) {
                    toClear.add((x-1)*100+(y+1));
                }
            }
            if (y < counts[0].length - 1 && buttons[x][y+1].isEnabled()) { // down
                buttons[x][y + 1].setText(counts[x][y+1] + "");
                buttons[x][y + 1].setEnabled(false);
                if (counts[x][y + 1] == 0) {
                    toClear.add(x * 100+(y + 1));
                }
            }
            if (x < counts.length - 1 && y < counts[0].length - 1 && buttons[x+1][y+1].isEnabled()) { //down right
                buttons[x + 1][y + 1].setText(counts[x+1][y+1] + "");
                buttons[x + 1][y + 1].setEnabled(false);
                if (counts[x + 1][y + 1] == 0) {
                    toClear.add((x + 1)*100+(y + 1));
                }
            }
            zeroCleaner(toClear);
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if(event.getSource().equals(reset)) {
            //Resets the playing field
            for (int x = 0; x < buttons.length; x++) {
                for (int y = 0; y < buttons[0].length; y++) {
                    buttons[x][y].setEnabled(true);
                    buttons[x][y].setText("▒");
                }
            }
            makeRandomMines();
        }
        else {
            for (int x = 0; x < buttons.length ; x++) {
                for (int y = 0; y < buttons[0].length; y++) {
                    if(event.getSource().equals(buttons[x][y])) {
                        if (counts[x][y]== MINE) {
                            lostGame();
                        }
                        else if(counts[x][y] == 0) {
                            buttons[x][y].setText(counts[x][y]+ "");
                            buttons[x][y].setEnabled(false);
                            ArrayList<Integer> toClear = new ArrayList<>();
                            toClear.add(x*100+y);
                            zeroCleaner(toClear);
                            checkWin();
                        }
                        else {
                            buttons[x][y].setText(counts[x][y]+ "");
                            buttons[x][y].setEnabled(false);
                            checkWin();
                        }
                    }
                }
            }
        }
    }
}
