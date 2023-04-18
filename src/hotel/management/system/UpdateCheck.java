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



public class UpdateCheck extends JFrame implements ActionListener{
    
    private JLabel lblheading, lblid, lblRoom, lblName, 
                   lblCheckinTime, lblPaid, lblDue;
    private JTextField txtRoom, txtName, txtCheckinTime,
                       txtPaid, txtDue;
    private Choice choiceCustomer;
    private  JButton btnCheck, btnUpdate, btnBack;

    public UpdateCheck() {
        setLayout(null);
        setBounds(300, 200, 980, 500);
        getContentPane().setBackground(new Color(242, 210, 189));
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        lblheading = new JLabel("Update Status");
        lblheading.setBounds(90, 20, 200, 30);
        lblheading.setForeground(Color.BLUE);
        lblheading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblheading);
        
        lblid = new JLabel("Customer Id");
        lblid.setBounds(30, 80, 100, 20);
        lblid.setForeground(Color.BLUE);
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
        lblRoom.setBounds(30, 120, 140, 20);
        lblRoom.setForeground(Color.BLUE);
        lblRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblRoom);
        
        txtRoom = new JTextField();
        txtRoom.setBounds(200, 120, 150, 25);
        add(txtRoom);
        
        lblName = new JLabel("Name");
        lblName.setBounds(30, 160, 100, 20);
        lblName.setForeground(Color.BLUE);
        lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblName);
        
        txtName = new JTextField();
        txtName.setBounds(200, 160, 150, 25);
        add(txtName);
        
        lblCheckinTime = new JLabel("Checkin Time");
        lblCheckinTime.setBounds(30, 200, 100, 20);
        lblCheckinTime.setForeground(Color.BLUE);
        lblCheckinTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblCheckinTime);
        
        txtCheckinTime = new JTextField();
        txtCheckinTime.setBounds(200, 200, 150, 25);
        add(txtCheckinTime);
        
        lblPaid = new JLabel("Amount Paid");
        lblPaid.setBounds(30, 240, 100, 20);
        lblPaid.setForeground(Color.BLUE);
        lblPaid.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblPaid);
        
        txtPaid = new JTextField();
        txtPaid.setBounds(200, 240, 150, 25);
        add(txtPaid);
        
        lblDue = new JLabel("Due Amount");
        lblDue.setBounds(30, 280, 100, 20);
        lblDue.setForeground(Color.BLUE);
        lblDue.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblDue);
        
        txtDue = new JTextField();
        txtDue.setBounds(200, 280, 150, 25);
        add(txtDue);
        
        btnCheck = new JButton("Check");
        btnCheck.setBounds(30, 340, 100, 30);
        btnCheck.setBackground(Color.BLACK);
        btnCheck.setForeground(Color.WHITE);
        add(btnCheck);
        btnCheck.addActionListener(this);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(150, 340, 100, 30);
        btnUpdate.setBackground(Color.BLACK);
        btnUpdate.setForeground(Color.WHITE);
        add(btnUpdate);
        btnUpdate.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(270, 340, 100, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        btnBack.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
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
                    txtName.setText(rs.getString("name"));
                    txtCheckinTime.setText(rs.getString("checkInTime"));
                    txtPaid.setText(rs.getString("deposite"));
                }
                //noe fetching the data from table 'room' so that we can calculate the due amount of the custome...
                ResultSet rs2 = con.s.executeQuery("select * from room where roomNumber = '"+txtRoom.getText()+"'");
                
                while(rs2.next()){
                    String price = rs2.getString("price");
                    
                    //calculate the due amount for the room
                    int dueAmount = Integer.parseInt(price)-Integer.parseInt(txtPaid.getText());
                    
                    txtDue.setText(""+dueAmount);
                    txtDue.setForeground(Color.red);
                                      
                }
              
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == btnUpdate){
            
            String idNumber = choiceCustomer.getSelectedItem();
            String room = txtRoom.getText();
            String name = txtName.getText();
            String checkinTime = txtCheckinTime.getText();
            String deposite = txtPaid.getText();
            
            try{
                
                Conn con = new Conn();
             
             
                con.s.executeUpdate("update customer set roomNumber = '"+room+"', name = '"+name+"', checkInTime = '"+checkinTime+"', deposite = '"+deposite+"' where idNumber = '"+idNumber+"'");
            
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
        new UpdateCheck();
    }

    
    
}
