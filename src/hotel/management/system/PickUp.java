
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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class PickUp extends JFrame implements ActionListener{

    private JLabel lblHeading, lblName, lblAge, lblAvailability, lblGender,
            lblCarCompany, lblCarType, lblCarModel, lblLocation;
    private Choice choiceCarType;
    private JCheckBox chkbxRoomAvailable;
    private JTable table;
    private JButton btnBack, btnSubmit;
    
    public PickUp() {
        setLayout(null);
        setBounds(300, 200, 1000, 600);
        getContentPane().setBackground(new Color(129, 199, 132));
        setLocationRelativeTo(null);
        setResizable(false);
        
        lblHeading = new JLabel("Pickup Service");
        lblHeading.setBounds(400, 30, 200, 30);
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(lblHeading);
        
        lblCarType = new JLabel("Car-Type");
        lblCarType.setBounds(50, 100, 100, 20);
        lblCarType.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblCarType);
        
        choiceCarType = new Choice();
        choiceCarType.setBounds(150, 100, 200, 25);
        add(choiceCarType);
        
        //fetching ythe data from table 'driver'
        try{
            Conn con = new Conn();
            
            String query = "SELECT * FROM driver";
            
            ResultSet rs = con.s.executeQuery(query);
            
            while (rs.next()) {                
                choiceCarType.add(rs.getString("carModel"));
            }
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
              
        
               
        lblName = new JLabel("Driver Name");
        lblName.setBounds(30, 160, 100, 20);
        lblName.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblName);
        
        lblAge = new JLabel("Age");
        lblAge.setBounds(200, 160, 100, 20);
        lblAge.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblAge);
        
        lblGender = new JLabel("Gender");
        lblGender.setBounds(330, 160, 100, 20);
        lblGender.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblGender);
        
        lblCarCompany = new JLabel("Car-Company");
        lblCarCompany.setBounds(460, 160, 100, 20);
        lblCarCompany.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblCarCompany);
        
        lblCarModel = new JLabel("Car-Model");
        lblCarModel.setBounds(600, 160, 100, 20);
        lblCarModel.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblCarModel);
        
        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(740, 160, 100, 20);
        lblAvailability.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblAvailability);
        
        lblLocation = new JLabel("Location");
        lblLocation.setBounds(860, 160, 100, 20);
        lblLocation.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblLocation);
        
        table = new JTable();
        table.setBounds(0, 200, 1000, 300);
        table.setBackground(new Color(129, 199, 132));
        add(table);
        
        //fetching the values from 'driver' table
        try{
           Conn conn = new Conn();
           
           String query = "SELECT * FROM driver";
           
           ResultSet rs = conn.s.executeQuery(query);
           
           //by using the re2xml.jar 
           //we are fetching all the data from the 'driver' table and put all the data into the table
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
                
               String query = "SELECT * FROM driver WHERE carModel = '"+choiceCarType.getSelectedItem()+"'";
                                             
               ResultSet rs = conn.s.executeQuery(query);
                
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
        new PickUp();
    }

   

    
}
