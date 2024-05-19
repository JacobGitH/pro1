package org.example;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.*;

public class RandomNumber {
    public int randomNumber;
    Random random = new Random();

    public void randomNumberGenerator(){
        randomNumber = random.nextInt(100);
        JFrame frame = new JFrame();
        frame.setTitle("Random Number");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel(randomNumber + "");
        label.setBounds(250, 100, 100, 30);

        JButton button = new JButton("Random Number");
        button.setBounds(100, 100, 100, 30);
        button.addActionListener(e -> {
            randomNumber = random.nextInt(100);
            label.setText(randomNumber + "");
            label.setBounds(250, 100, 100, 30);
        });

        frame.add(button);
        frame.add(label);
    }
}
