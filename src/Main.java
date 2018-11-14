import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args){

        JFrame appFrame = new JFrame();
        appFrame.setSize(500, 500);
        appFrame.setTitle("Minesweeper");
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setVisible(true);

    }

    public static void showWinLoseAlert(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
