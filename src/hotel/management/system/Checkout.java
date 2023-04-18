package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Checkout extends JFrame implements ActionListener{

    JLabel lblHeading, lblCustomerId, lblRoom, 
           lblRoomNumber, lblCheckin, 
           lblCheckinTime, lblCheckout,
           lblCheckoutTime;
    Choice choiceCustomerId;
    JButton btnCheckout, btnBack;
    
    public Checkout() {
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setBounds(300, 200, 800, 400);
        getContentPane().setBackground(Color.WHITE);
        
        lblHeading = new JLabel("Checkout");
        lblHeading.setBounds(100, 20, 100, 30);
        lblHeading.setForeground(Color.BLUE);
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblHeading);
        
        lblCustomerId = new JLabel("Customer Id");
        lblCustomerId.setBounds(30, 80, 100, 30);
        lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblCustomerId);
        
        choiceCustomerId = new Choice();
        choiceCustomerId.setBounds(150, 80, 150, 25);
        add(choiceCustomerId);
        
                
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310, 80, 20, 20);
        add(image);
        
        lblRoom = new JLabel("Room Number :");
        lblRoom.setBounds(30, 130, 100, 30);
        lblRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblRoom);
        
        lblRoomNumber = new JLabel();
        lblRoomNumber.setBounds(150, 130, 100, 30);
        lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblRoomNumber);
        
        lblCheckin = new JLabel("Checkin Time :");
        lblCheckin.setBounds(30, 180, 100, 30);
        lblCheckin.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblCheckin);
        
        lblCheckinTime = new JLabel();
        lblCheckinTime.setBounds(150, 180, 160, 30);
        lblCheckinTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblCheckinTime);
        
        lblCheckout = new JLabel("Checkout Time :");
        lblCheckout.setBounds(30, 230, 110, 30);
        lblCheckout.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblCheckout);
        
        Date date = new Date();
        
        lblCheckoutTime = new JLabel(""+date);
        lblCheckoutTime.setBounds(150, 230, 165, 30);
        lblCheckoutTime.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblCheckoutTime);
        
        
        btnCheckout = new JButton("Checkout");
        btnCheckout.setBounds(30, 280, 120, 30);
        btnCheckout.setBackground(Color.BLACK);
        btnCheckout.setForeground(Color.WHITE);
        add(btnCheckout);
        btnCheckout.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(170, 280, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        btnBack.addActionListener(this);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel img = new JLabel(i6);
        img.setBounds(350, 50, 400, 250);
        add(img);

//detching the data from table 'customer'
        try{
            
            Conn con = new Conn();
            
            String query = "SELECT * FROM customer";
            
            ResultSet rs = con.s.executeQuery(query);
            
            while (rs.next()) {
                choiceCustomerId.add(rs.getString("idNumber"));
                lblRoomNumber.setText(rs.getString("roomNumber"));
                lblCheckinTime.setText(rs.getString("checkInTime"));
            
            }
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        
        if(ae.getSource() == btnCheckout){
           
            String q1 = "DELETE FROM customer WHERE idNumber='"+choiceCustomerId.getSelectedItem()+"'";
            String q2 = "UPDATE room SET availability = 'Available' WHERE roomNumber = '"+lblRoomNumber.getText()+"'";
            
            try{
                
                Conn con = new Conn();
                
                con.s.executeUpdate(q1);
                con.s.executeUpdate(q2);
                
                
                JOptionPane.showMessageDialog(null, "Checkout Done...Have A Nice Day!");
            
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
        new Checkout();
    }

    

    
}
