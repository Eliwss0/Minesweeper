import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Should we use JavaFX?
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
    }

    public static void showWinLoseAlert(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

}
