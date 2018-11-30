//import javax.swing.JFrame;
//import java.awt.Graphics;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JPanel;
//
//public class visualGrid extends JPanel {
//    int width, height, rows, cols;
//
//    //array of images that a cell can have (0-8=0-8,flag=9,mine=10,unrevealed=11)
//    //may be better as a dictionary
//    int[] imgArray = new int[11];
//    //TODO: Import images
//    visualGrid(int w, int h, int r, int c) {
//
//        addMouseListener(new MineClicker());
//
//        setSize(width = w, height = h);
//        rows = r;
//        cols = c;
//    }
//
//    public void paint(Graphics g) {
//        int i;
//        width = getSize().width;
//        height = getSize().height;
//
//        // draw the rows
//        int rowHt = height / (rows);
//        for (i = 0; i < rows; i++)
//            g.drawLine(0, i * rowHt, width, i * rowHt);
//
//        // draw the columns
//        int rowWid = width / (cols);
//        for (i = 0; i < cols; i++)
//            g.drawLine(i * rowWid, 0, i * rowWid, height);
//
//        for (int x = 0; x < 10; x++) {
//            for (int y = 0; y < 10; y++) {
////                g.drawString("M", (y * 50) + 25, (x * 50) + 25);
//            }
//        }
//    }
//
////    @Override
////    public void paintComponent(Graphics g) {
////        for (int x = 0; x < 10; x++) {
////            for (int y = 0; y < 10; y++) {
////                g.drawString("HW", (y * 50), (x * 50));
////            }
////        }
////    }
//
//    private class MineClicker extends MouseAdapter {
//        @Override
//        public void mousePressed(MouseEvent event) {
//            int x = event.getX();
//            int y = event.getY();
//            int col = x / 50;
//            int row = y /50;
//
//            if (x < 500 && y < 500) {
//                System.out.print("pressed mouse at ");
//                System.out.print(x);
//                System.out.print(",");
//                System.out.print(y);
//                System.out.print(" ");
//                System.out.print(row);
//                System.out.print(",");
//                System.out.println(col);
//                if (event.getButton() == MouseEvent.BUTTON3) {
//                    System.out.println("Button 3, place flag");
//
//                }
//                else {
//                    System.out.println("Not Button 3");
//                }
//            }
//        }
//    }
//
//}
