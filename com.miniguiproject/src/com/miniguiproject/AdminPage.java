
package com.miniguiproject;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminPage extends JFrame {

    static ArrayList<Object[]> employees = new ArrayList<>();

    DefaultTableModel model;
    JTable table;

    // Background image method
    private JPanel createBackgroundPanel() {

        ImageIcon icon = new ImageIcon(
            "C:\\Users\\podil\\Desktop\\admin.jpg"
        );

        Image image = icon.getImage();

        return new JPanel(new BorderLayout(10, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                g.drawImage(image, 0, 0,
                    getWidth(), getHeight(), this);
            }
        };
    }

    public AdminPage() {

        setTitle("Admin Dashboard");
        setSize(850, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // IMPORTANT: Use the background panel
        JPanel bg = createBackgroundPanel();
        setContentPane(bg);

        JLabel title = new JLabel(
            "EMPLOYEE MANAGEMENT SYSTEM",
            SwingConstants.CENTER
        );

        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(Color.BLUE);
        title.setOpaque(false);

        model = new DefaultTableModel(
            new String[]{"ID", "Name", "Email",
                         "Department", "Salary"}, 0
        ) {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        table = new JTable(model);
        table.setRowHeight(25);

        // Make table background transparent
        table.setOpaque(false);
        ((javax.swing.table.DefaultTableCellRenderer)
            table.getDefaultRenderer(Object.class))
            .setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        JButton add = new JButton("Add Employee");
        JButton view = new JButton("View Employees");
        JButton clear = new JButton("Clear Table");

        JPanel buttons = new JPanel();
        buttons.setOpaque(false);
        buttons.add(add);
        buttons.add(view);
        buttons.add(clear);

        // Add all components to background panel
        bg.add(title, BorderLayout.NORTH);
        bg.add(scrollPane, BorderLayout.CENTER);
        bg.add(buttons, BorderLayout.SOUTH);

        add.addActionListener(e ->
            new RegisterDevelope().setVisible(true)
        );

        view.addActionListener(e -> loadEmployees());

        clear.addActionListener(e -> model.setRowCount(0));

        loadEmployees();
    }

    public static void addEmployee(
            String name, String email,
            String department, double salary) {

        int id = employees.size() + 1;

        employees.add(new Object[]{
            id, name, email, department, salary
        });
    }

    private void loadEmployees() {
        model.setRowCount(0);

        for (Object[] employee : employees) {
            model.addRow(employee);
        }
    }
}
