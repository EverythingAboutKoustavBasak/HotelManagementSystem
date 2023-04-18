
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


public class CustomerInfo extends JFrame implements ActionListener{

    private JLabel lblDocumentType, lblDocumentNumber,
                   lblGender, lblCountry, lblRoomNumber, lblCheckinTime, lblDeposite;
    private JTable table;
    private JButton btnBack;
    
    public CustomerInfo() {
        setLayout(null);
        setBounds(300, 200, 1000, 600);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setResizable(false);
        
       
        
        lblDocumentType = new JLabel("Document-Type");
        lblDocumentType.setBounds(10, 10, 100, 20);
        lblDocumentType.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblDocumentType);
        
        lblDocumentNumber = new JLabel("Document-No");
        lblDocumentNumber.setBounds(130, 10, 100, 20);
        lblDocumentNumber.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblDocumentNumber);
        
        lblGender = new JLabel("Name");
        lblGender.setBounds(260, 10, 100, 20);
        lblGender.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblGender);
        
        lblGender = new JLabel("Gender");
        lblGender.setBounds(410, 10, 100, 20);
        lblGender.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblGender);
        
        lblCountry = new JLabel("Country");
        lblCountry.setBounds(520, 10, 100, 20);
        lblCountry.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblCountry);
        
        lblRoomNumber = new JLabel("Room-No");
        lblRoomNumber.setBounds(640, 10, 100, 20);
        lblRoomNumber.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblRoomNumber);
        
        lblCheckinTime = new JLabel("Checkin-Time");
        lblCheckinTime.setBounds(760, 10, 100, 20);
        lblCheckinTime.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblCheckinTime);
        
        lblDeposite = new JLabel("Deposite");
        lblDeposite.setBounds(900, 10, 100, 20);
        lblDeposite.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblDeposite);
        
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        //fetching the values from 'employee' database
        try{
           Conn conn = new Conn();
           
           String query = "SELECT * FROM customer";
           
           ResultSet rs = conn.s.executeQuery(query);
           
           //by using the re2xml.jar 
           //we are fetching all the data from the 'customer' table and put all the data into the table
           table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        btnBack = new JButton("Back");
        btnBack.setBounds(420, 500, 120, 30);
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
        new CustomerInfo();
    }

   

    
}
