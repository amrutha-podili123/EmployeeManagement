
package com.miniguiproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterDevelope extends JFrame
        implements ActionListener {

    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3;
    JComboBox<String> cb;
    JButton b1, b2;

   
    private JPanel createBackgroundPanel() {

        ImageIcon icon = new ImageIcon(
            "C:\\Users\\podil\\Desktop\\registration.jpg"
        );

        
        if (icon.getIconWidth() == -1) {
            System.out.println(
                "Image not found! Check registration.jpg path."
            );
        }

        Image image = icon.getImage();

        return new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(
                    image, 0, 0,
                    getWidth(), getHeight(), this
                );
            }
        };
    }

    public RegisterDevelope() {

        setTitle("Employee Registration");
        setSize(500, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
        JPanel bg = createBackgroundPanel();
        setContentPane(bg);

        l1 = new JLabel("EMPLOYEE REGISTRATION");
        l2 = new JLabel("Name:");
        l3 = new JLabel("Email:");
        l4 = new JLabel("Department:");
        l5 = new JLabel("Salary:");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();

        cb = new JComboBox<>(new String[]{
            "IT", "HR", "Finance", "Marketing"
        });

        b1 = new JButton("Submit");
        b2 = new JButton("Clear");

        
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(90, 30, 320, 35);

        
        l2.setBounds(60, 100, 100, 30);
        l3.setBounds(60, 150, 100, 30);
        l4.setBounds(60, 200, 100, 30);
        l5.setBounds(60, 250, 100, 30);

        l2.setForeground(Color.BLACK);
        l3.setForeground(Color.BLACK);
        l4.setForeground(Color.BLACK);
        l5.setForeground(Color.BLACK);

        
        t1.setBounds(180, 100, 200, 30);
        t2.setBounds(180, 150, 200, 30);
        cb.setBounds(180, 200, 200, 30);
        t3.setBounds(180, 250, 200, 30);

        // Buttons
        b1.setBounds(100, 320, 100, 35);
        b2.setBounds(230, 320, 100, 35);

        
        bg.add(l1);
        bg.add(l2);
        bg.add(l3);
        bg.add(l4);
        bg.add(l5);

        bg.add(t1);
        bg.add(t2);
        bg.add(t3);
        bg.add(cb);

        bg.add(b1);
        bg.add(b2);

       
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        // Clear fields
        if (ae.getSource() == b2) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            cb.setSelectedIndex(0);
        }

        // Submit employee details
        if (ae.getSource() == b1) {

            if (t1.getText().trim().isEmpty()
                    || t2.getText().trim().isEmpty()
                    || t3.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    this, "Please fill all fields"
                );
                return;
            }

            try {
                double salary = Double.parseDouble(
                    t3.getText().trim()
                );

                if (salary < 0) {
                    JOptionPane.showMessageDialog(
                        this, "Salary cannot be negative"
                    );
                    return;
                }

                AdminPage.addEmployee(
                    t1.getText().trim(),
                    t2.getText().trim(),
                    (String) cb.getSelectedItem(),
                    salary
                );

                JOptionPane.showMessageDialog(
                    this, "Employee Added Successfully"
                );

                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                    this, "Enter a valid salary"
                );
            }
        }
    }
}
