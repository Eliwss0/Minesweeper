import javax.swing.*;
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
        visualGrid mine = new visualGrid(500, 500, 10, 10);

        JFrame appFrame = new JFrame();
        appFrame.setSize(500, 520);
        appFrame.setTitle("Minesweeper");
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);

        appFrame.add(mine);
        //appFrame.pack();
        appFrame.setResizable(false);
        Grid grid=new Grid();
        grid.assignMines();
    }

    public static void showWinLoseAlert(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
