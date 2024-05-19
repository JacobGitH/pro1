package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ComboBoxAndTable {
    public void ShowCase(){
        CsvHandle csvh = new CsvHandle();
        List<Person> people = csvh.CreatePersonFromCsv("src/main/java/org/example/person.csv", true);

        JFrame frame = new JFrame("Person Information Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        JPanel BottomPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        BottomPanel.setSize(500,100);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel genderlabel = new JLabel("Gender:");
        JTextField genderField = new JTextField();

        String[] columnNames = {"Name", "Age", "Email", "Gender"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);


        JButton addButton = new JButton("Add Person");

        addButton.addActionListener(e -> {
            people.add(new Person(nameField.getText(), Integer.parseInt(ageField.getText()), emailField.getText(), genderField.getText()));
            for (Person person : people) {
                tableModel.addRow(new Object[]{person.name, Integer.toString(person.age), person.email, person.gender});
            }
            nameField.setText("");
            ageField.setText("");
            emailField.setText("");
            genderField.setText("");
        });

        String[] items = {"csv", "json", "txt"};
        JComboBox comboBox = new JComboBox(items);
        comboBox.setSelectedIndex(-1);

        JButton chooseButton = new JButton("Click");
        chooseButton.addActionListener(e -> {
            if (comboBox.getSelectedItem().equals("csv")) {
                csvh.InsertIntoCsvMultiple(people, "src/main/java/org/example/person.csv");
            }else if(comboBox.getSelectedItem().equals("json")) {
                JsonHandle jh = new JsonHandle("src/main/java/org/example/person.json");
                jh.putToJson(people, "src/main/java/org/example/output.json");
            }else if(comboBox.getSelectedItem().equals("txt")) {
                //same shit
            }else{
                return;
            }
        });


        formPanel.add(nameLabel);
        formPanel.add(nameField);
        formPanel.add(ageLabel);
        formPanel.add(ageField);
        formPanel.add(emailLabel);
        formPanel.add(emailField);
        formPanel.add(genderlabel);
        formPanel.add(genderField);// Empty label for layout spacing
        formPanel.add(addButton);


        BottomPanel.add(chooseButton, BorderLayout.NORTH);
        BottomPanel.add(comboBox, BorderLayout.SOUTH);


        frame.add(formPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(BottomPanel, BorderLayout.SOUTH);

        frame.setSize(600,600);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
