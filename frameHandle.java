package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class frameHandle {

    public void SwingLayoutExample() {
        JFrame frame = new JFrame("Swing Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        // Create a combo box
        String[] options = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(options);

        // Create a table
        String[] columnNames = {"Name", "Age"};
        Object[][] data = {
                {"John", 30},
                {"Jane", 25},
                {"Doe", 35}
        };
        JTable table = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Create a list
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Item 1");
        listModel.addElement("Item 2");
        listModel.addElement("Item 3");
        JList<String> list = new JList<>(listModel);
        JScrollPane listScrollPane = new JScrollPane(list);

        // Add components to the main panel
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(comboBox, BorderLayout.WEST);
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);
        mainPanel.add(listScrollPane, BorderLayout.EAST);

        // Add action listener to button 1
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Button 1 clicked");
            }
        });

        // Add main panel to the frame
        frame.add(mainPanel);

        frame.setVisible(true);
    }
}
