
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class SearchRoom extends JFrame implements ActionListener{

    private JLabel lblHeading, lblRoomNumber, lblAvailability, lblCleaningStatus,
            lblPrice, lblBedType;
    private JComboBox cbBedType;
    private JCheckBox chkbxRoomAvailable;
    private JTable table;
    private JButton btnBack, btnSubmit;
    
    public SearchRoom() {
        setLayout(null);
        setBounds(300, 200, 1000, 600);
        getContentPane().setBackground(new Color(242, 210, 189));
        setLocationRelativeTo(null);
        setResizable(false);
        
        lblHeading = new JLabel("Searching For Room");
        lblHeading.setBounds(400, 30, 200, 30);
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblHeading);
        
        lblBedType = new JLabel("Bed-Type");
        lblBedType.setBounds(50, 100, 100, 20);
        lblBedType.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblBedType);
        
        cbBedType = new JComboBox(new String[] {"Single-Bed", "Double-Bed"});
        cbBedType.setBounds(150, 100, 150, 25);
        cbBedType.setBackground(Color.WHITE);
        add(cbBedType);
        
        chkbxRoomAvailable = new JCheckBox("Only Display Available");
        chkbxRoomAvailable.setBounds(650, 100, 150, 25);
        chkbxRoomAvailable.setBackground(new Color(242, 210, 189));;
        add(chkbxRoomAvailable);
        
        lblRoomNumber = new JLabel("Room Number");
        lblRoomNumber.setBounds(50, 160, 100, 20);
        lblRoomNumber.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblRoomNumber);
        
        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(270, 160, 100, 20);
        lblAvailability.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblAvailability);
        
        lblCleaningStatus = new JLabel("Cleaning-Status");
        lblCleaningStatus.setBounds(450, 160, 100, 20);
        lblCleaningStatus.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblCleaningStatus);
        
        lblPrice = new JLabel("Price");
        lblPrice.setBounds(670, 160, 100, 20);
        lblPrice.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblPrice);
        
        lblBedType = new JLabel("Bed Type");
        lblBedType.setBounds(870, 160, 100, 20);
        lblBedType.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblBedType);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        table.setBackground(new Color(242, 210, 189));
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
        
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(300, 520, 120, 30);
        btnSubmit.setBackground(Color.BLACK);
        btnSubmit.setForeground(Color.WHITE);
        add(btnSubmit);
        btnSubmit.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(500, 520, 120, 30);
        btnBack.setBackground(Color.BLACK);
        btnBack.setForeground(Color.WHITE);
        add(btnBack);
        btnBack.addActionListener(this);
        
        
        
        setVisible(true);
    }
    
     @Override
    public void actionPerformed(ActionEvent ae) {
         
        if(ae.getSource() == btnSubmit){
            try{
                Conn conn = new Conn();
                
               String query1 = "SELECT * FROM room WHERE bedType = '"+cbBedType.getSelectedItem()+"'";
               String query2 = "SELECT * FROM room WHERE availability = 'Available' AND bedType = '"+cbBedType.getSelectedItem()+"'";
               
               ResultSet rs;
               if(chkbxRoomAvailable.isSelected()){
                  
                  rs = conn.s.executeQuery(query2);
               }else{
                  rs = conn.s.executeQuery(query1);
 
               }
                
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
                
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
            
        }
        else if(ae.getSource() == btnBack){
            setVisible(false);
            new Reception();
        }
        
    }
    
     public static void main(String[] args) {
        new SearchRoom();
    }

   

    
}
