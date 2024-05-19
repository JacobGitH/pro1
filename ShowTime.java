package org.example;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowTime {
    public static void showTime() {
        JFrame frame = new JFrame("Live Time Display");
        JLabel timeLabel = new JLabel();

        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(timeLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                String time = dateFormat.format(new Date());
                timeLabel.setText("Current Time: " + time);
            }
        });
        timer.start();

        frame.setVisible(true);
    }

//    ShowTime showTime = new ShowTime();
//        showTime.showTime();
}


