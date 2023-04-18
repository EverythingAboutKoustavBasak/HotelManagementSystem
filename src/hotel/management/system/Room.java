
package hotel.management.system;

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
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class Room extends JFrame implements ActionListener{

    private JLabel lblRoomNumber, lblAvailability, lblCleaningStatus,
            lblPrice, lblBedType;
    private JTable table;
    private JButton btnBack;
    
    public Room() {
        setLayout(null);
        setBounds(300, 200, 1050, 600);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setResizable(false);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        lblRoomNumber = new JLabel("Room Number");
        lblRoomNumber.setBounds(10, 10, 100, 20);
        lblRoomNumber.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblRoomNumber);
        
        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(120, 10, 100, 20);
        lblAvailability.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblAvailability);
        
        lblCleaningStatus = new JLabel("Status");
        lblCleaningStatus.setBounds(230, 10, 100, 20);
        lblCleaningStatus.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblCleaningStatus);
        
        lblPrice = new JLabel("Price");
        lblPrice.setBounds(330, 10, 100, 20);
        lblPrice.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblPrice);
        
        lblBedType = new JLabel("Bed Type");
        lblBedType.setBounds(410, 10, 100, 20);
        lblBedType.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblBedType);
        
        table = new JTable();
        table.setBounds(0, 40, 500, 400);
        add(table);
        
        //fetching the values from 'room' database
        try{
           Conn conn = new Conn();
           
           String query = "SELECT * FROM room";
           
           ResultSet rs = conn.s.executeQuery(query);
           
           //by using the re2xml.jar 
           //we are fetching all the data from the 'room' table and put all the data into the table
           table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        btnBack = new JButton("Back");
        btnBack.setBounds(200, 500, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        btnBack.addActionListener(this);
        
        
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
         setVisible(false);
         new Reception();

    }
    
     public static void main(String[] args) {
        new Room();
    }

   

    
}
