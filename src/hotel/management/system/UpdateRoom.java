package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class UpdateRoom extends JFrame implements ActionListener{
    
    private JLabel lblheading, lblid, lblRoom, lblAvailability, 
                   lblCleaningStatus, lblPaid, lblDue;
    private JTextField txtRoom, txtAvailability, txtCleaningStatus,
                       txtPaid, txtDue;
    private Choice choiceCustomer;
    private  JButton btnCheck, btnUpdate, btnBack;

    public UpdateRoom() {
        setLayout(null);
        setBounds(300, 200, 980, 500);
        getContentPane().setBackground(new Color(206,147,216));
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        lblheading = new JLabel("Update Room Status");
        lblheading.setBounds(30, 20, 250, 30);
        lblheading.setForeground(Color.BLACK);
        lblheading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblheading);
        
        lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        lblid.setForeground(Color.BLACK);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblid);
        
        choiceCustomer = new Choice();
        choiceCustomer.setBounds(200, 80, 150, 25);
        add(choiceCustomer);
        
        //detching the data from table 'customer'
        try{
            
            Conn con = new Conn();
            
            String query = "SELECT * FROM customer";
            
            ResultSet rs = con.s.executeQuery(query);
            
            while (rs.next()) {
                choiceCustomer.add(rs.getString("idNumber"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(30, 130, 140, 20);
        lblRoom.setForeground(Color.BLACK);
        lblRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblRoom);
        
        txtRoom = new JTextField();
        txtRoom.setBounds(200, 130, 150, 25);
        add(txtRoom);
        
        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(30, 180, 100, 20);
        lblAvailability.setForeground(Color.BLACK);
        lblAvailability.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblAvailability);
        
        txtAvailability = new JTextField();
        txtAvailability.setBounds(200, 180, 150, 25);
        add(txtAvailability);
        
        lblCleaningStatus = new JLabel("Cleaning Status");
        lblCleaningStatus.setBounds(30, 230, 120, 20);
        lblCleaningStatus.setForeground(Color.BLACK);
        lblCleaningStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblCleaningStatus);
        
        txtCleaningStatus = new JTextField();
        txtCleaningStatus.setBounds(200, 230, 150, 25);
        add(txtCleaningStatus);
        
        
        btnCheck = new JButton("Check");
        btnCheck.setBounds(30, 300, 100, 30);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        add(btnCheck);
        btnCheck.addActionListener(this);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(150, 300, 100, 30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        add(btnUpdate);
        btnUpdate.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(270, 300, 100, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        btnBack.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 500, 300);
        add(image);
        
        
        
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnCheck){
           
            try{
                Conn con = new Conn();
                
                String customerId = choiceCustomer.getSelectedItem();
                
                String query1 = "SELECT * FROM customer WHERE idNumber = '"+customerId+"'";
                
                ResultSet rs = con.s.executeQuery(query1);
            
                while(rs.next()){
                    txtRoom.setText(rs.getString("roomNumber"));
                }
                //now fetching the data from table 'room' so that we can calculate the due amount of the custome...
                ResultSet rs2 = con.s.executeQuery("select * from room where roomNumber = '"+txtRoom.getText()+"'");
                
                while(rs2.next()){
                  txtAvailability.setText(rs2.getString("availability"));
                  txtCleaningStatus.setText(rs2.getString("cleaningStatus"));
                  
                }
              
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == btnUpdate){
            
            String idNumber = choiceCustomer.getSelectedItem();
            String room = txtRoom.getText();
            String availability = txtAvailability.getText();
            String cleaningStatus = txtCleaningStatus.getText();
            
            try{
                
                Conn con = new Conn();
             
             
                con.s.executeUpdate("update room set availability = '"+availability+"', cleaningStatus = '"+cleaningStatus+"' where roomNumber = '"+room+"'");
            
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource() == btnBack){
            setVisible(false);
            new Reception();
        }
    
    }
    
    
     public static void main(String[] args) {
        new UpdateRoom();
    }

    
    
}
