package hospital.management.patient;

import hospital.management.conn;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class patient_discharge extends JFrame {
    public patient_discharge() {
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 790, 390);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.WHITE);
        panel.add(label);


        JLabel label1 = new JLabel("Customer Id");
        label1.setBounds(40, 80, 150, 20);
        label1.setFont(new Font("Tahoma", Font.BOLD, 20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(40, 130, 150, 20);
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(230,130,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,20));
        RNo.setForeground(Color.WHITE);
        panel.add(RNo);



        Choice choice = new Choice();
        choice.setBounds(200, 80, 150, 25);
        panel.add(choice);
        try{
          conn c =new conn();
            ResultSet resultSet=c.statement.executeQuery("select*from Patient_Info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));

            }
        }catch (Exception e){
           e.printStackTrace();
        }




        JLabel label4 = new JLabel("In Time");
        label4.setBounds(40,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,20));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,500,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,20));
        INTime.setForeground(Color.WHITE);
        panel.add(INTime);


        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(40,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,20));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        Date date = new Date();

        JLabel OutTime = new JLabel(""+date);
        OutTime.setBounds(200,230,500,20);
        OutTime.setFont(new Font("Tahoma",Font.BOLD,20));
        OutTime.setForeground(Color.WHITE);
        panel.add(OutTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.black);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    c.statement.executeUpdate("delete from Patient_Info where number='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability='Available'where room_no='"+RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }catch(Exception E){
                    E.printStackTrace();

                }


            }
        });

        JButton Check = new JButton("Check");
        Check.setBounds(170,300,120,30);
        Check.setBackground(Color.black);
        Check.setForeground(Color.WHITE);
        panel.add(Check);

        Check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try{
                    ResultSet resultSet = c.statement.executeQuery("select*from Patient_Info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next()){
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }

            }
        });






        JButton Back = new JButton("Back");
        Back.setBounds(320,300,120,30);
        Back.setBackground(Color.black);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
























       setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);

        setVisible(true);
    }
    public static void main(String[] args) {
        new patient_discharge();

    }
}
