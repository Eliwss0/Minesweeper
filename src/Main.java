import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public static void main(String[] args) {
        visualGrid mine = new visualGrid(500, 500, 10, 10);

        JFrame appFrame = new JFrame();
        appFrame.setSize(500, 520);
        appFrame.setTitle("Minesweeper");
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);

        appFrame.add(mine);
        //appFrame.pack();
        appFrame.setResizable(false);

        //Window to get game parameters
        JFormattedTextField xSize,ySize,mineNum;
        NumberFormatter numFormat=new NumberFormatter();
        numFormat.setValueClass(Integer.class);
        JPanel gameParamPanel=new JPanel();
        JFrame gameParameters=new JFrame("Minesweeper Parameters");
        gameParamPanel.setLayout(new FlowLayout());
        xSize=new JFormattedTextField(numFormat);
        JLabel widthX=new JLabel("Width of play field");
        ySize=new JFormattedTextField(numFormat);
        JLabel heightY=new JLabel("Height of play field");
        mineNum=new JFormattedTextField(numFormat);
        JLabel numOfMines=new JLabel("Number of mines");
        JButton confirmParameters=new JButton();
        confirmParameters.setText("Confirm");
        gameParamPanel.add(widthX);
        gameParamPanel.add(xSize);
        gameParamPanel.add(heightY);
        gameParamPanel.add(ySize);
        gameParamPanel.add(numOfMines);
        gameParamPanel.add(mineNum);
        gameParameters.add(gameParamPanel);
        gameParameters.add(confirmParameters);
        gameParameters.setSize(300,150);
        gameParameters.setLocationRelativeTo(null);
        gameParameters.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameParameters.setVisible(true);
        //TODO: trigger grid creation and display with confirmParameters button
        Grid grid=new Grid((int)xSize.getValue(),(int)ySize.getValue(),(int)mineNum.getValue());
    }

    public static void showWinLoseAlert(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
