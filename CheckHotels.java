package tour.and.travel.system;

import javax.swing.*;
import java.awt.*;

public class CheckHotels extends JFrame implements Runnable {

    Thread t1;
    JLabel[] label = new JLabel[10];
    JLabel caption;

    public void run() {
        String[] text = {
            "Breeze Blow Hotel", "The Taj Hotel", "Happy Morning Hotel",
            "Four Seasons Hotel", "Piyamit Hotel", "Worada Ressort",
            "A9 Hotel", "Raddison Blue Hotel", "Classio Hotel", "The Bay Club Hotel"
        };

        try {
            for (int i = 0; i <= 9; i++) {
                label[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(2700);
                if (i < 9) { // keep last one visible
                    label[i].setVisible(false);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CheckHotels() {
        setBounds(500, 150, 800, 570);
        getContentPane().setBackground(Color.black);
        setLayout(null);

        caption = new JLabel();
        caption.setBounds(50, 450, 800, 100);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.white);
        add(caption);

        for (int i = 0; i < 10; i++) {
            ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i + 1) + ".jpg"));
            Image scaled = image.getImage().getScaledInstance(800, 570, Image.SCALE_DEFAULT);
            ImageIcon icon = new ImageIcon(scaled);
            label[i] = new JLabel(icon);
            label[i].setBounds(0, 0, 800, 600);
            label[i].setVisible(false);
            add(label[i]);
        }

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckHotels();
    }
}
