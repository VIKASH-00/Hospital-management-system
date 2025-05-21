package hospital.management;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employe_Info extends JFrame {

    Employe_Info() {
        // Frame settings
        setTitle("Employee Info");
        setSize(800, 600);
        setLocation(350, 250);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 770, 550); // Adjusted to fit inside frame
        panel.setBackground(new Color(109, 164, 170));
        panel.setLayout(null);
        add(panel);

        // Table
        JTable table = new JTable();
        int tableY = 34;
        int tableHeight = 400;
        table.setBounds(10, tableY, 750, tableHeight); // Adjusted width and height
        table.setBackground(new Color(109, 164, 170));
        panel.add(table);

        // Table data from DB
        try {
            conn c = new conn(); // Assumes a working `conn` class
            String q = "SELECT * FROM emp_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Column labels
        JLabel label1 = new JLabel("Name");
        label1.setBounds(100, 11, 60, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Age");
        label2.setBounds(250, 11, 60, 20);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Phone No");
        label3.setBounds(450, 11, 80, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Email ID");
        label4.setBounds(630, 11, 80, 20);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        // BACK Button
        JButton button = new JButton("BACK");

        int buttonWidth = 200;
        int buttonHeight = 30;

        // Fixing the button position (below the table)
        int buttonX = (panel.getWidth() - buttonWidth) / 2;
        int buttonY = tableY + tableHeight + 20; // 20px below the table
        button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);

        // BACK action
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false); // Closes the window
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new Employe_Info();
    }
}
