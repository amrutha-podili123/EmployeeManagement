
package com.miniguiproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginDevelope extends JFrame implements ActionListener {

    JLabel jl1, jl2, jl3;
    JTextField jt;
    JPasswordField jp;
    JButton jb1, jb2, jb3;

    
    private JPanel createBackgroundPanel() {

        Image image = new ImageIcon(
            "C:\\Users\\podil\\Desktop\\office.jpg"
        ).getImage();

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

    public LoginDevelope() {

        setTitle("Employee Management System");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JPanel bg = createBackgroundPanel();
        setContentPane(bg);

        jl1 = new JLabel("EMPLOYEE LOGIN");
        jl2 = new JLabel("EMAIL:");
        jl3 = new JLabel("PASSWORD:");

        jt = new JTextField();
        jp = new JPasswordField();

        jb1 = new JButton("Login");
        jb2 = new JButton("Clear");
        jb3 = new JButton("Register");

        jl1.setFont(new Font("Arial", Font.BOLD, 24));
        jl1.setForeground(Color.BLUE);

        jl1.setBounds(170, 40, 300, 40);
        jl2.setBounds(80, 130, 100, 30);
        jl3.setBounds(80, 190, 100, 30);

        jt.setBounds(200, 130, 200, 30);
        jp.setBounds(200, 190, 200, 30);

        jb1.setBounds(80, 270, 100, 35);
        jb2.setBounds(210, 270, 100, 35);
        jb3.setBounds(150, 340, 130, 35);

        
        bg.add(jl1);
        bg.add(jl2);
        bg.add(jl3);
        bg.add(jt);
        bg.add(jp);
        bg.add(jb1);
        bg.add(jb2);
        bg.add(jb3);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == jb2) {
            jt.setText("");
            jp.setText("");
        }

        if (ae.getSource() == jb3) {
            new RegisterDevelope().setVisible(true);
        }

        if (ae.getSource() == jb1) {

            String email = jt.getText().trim();
            String password = new String(jp.getPassword());

            if (email.equals("admin@gmail.com")
                    && password.equals("admin123")) {

                JOptionPane.showMessageDialog(
                    this, "Login Successful"
                );

                new AdminPage().setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(
                    this, "Invalid Email or Password"
                );
            }
        }
    }
}
