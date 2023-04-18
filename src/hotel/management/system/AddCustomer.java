
package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class AddCustomer extends JFrame implements ActionListener{
    
    private JLabel lblid, lblNumber, lblName, lblGender, 
            lblCountry, lblRoom, lblCheckInTime,
            lblCheckIn, lblDeposite;
    private JComboBox cbId;
    private JTextField tfNumber, tfName, 
            tfCountry, tfDeposite;
    private JRadioButton rbMale, rbFemale;
    private Choice cRoom;
    private JButton btnAdd, btnBack;
    
    public AddCustomer() {
        setLayout(null);
        setBounds(350, 200, 800, 550);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        
        JLabel heading = new JLabel("NEW CUSTOMER FORM");
        heading.setBounds(100, 20, 300, 30);
        heading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(heading);
        
        lblid = new JLabel("Customer Id");
        lblid.setBounds(35, 80, 100, 20);
        lblid.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblid);
        
        String idOptions[] = {"Aadhar Card", "Passport", "Driving License", "Voter-Id Card", "PAN Card"};
        cbId = new JComboBox(idOptions);
        cbId.setBounds(200, 80, 150, 25);
        cbId.setBackground(Color.WHITE);
        add(cbId);
        
        lblNumber = new JLabel("Id Number");
        lblNumber.setBounds(35, 120, 100, 20);
        lblNumber.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblNumber);
        
        tfNumber = new JTextField();
        tfNumber.setBounds(200, 120, 150, 25);
        add(tfNumber);
        
        lblName = new JLabel("Name");
        lblName.setBounds(35, 160, 100, 20);
        lblName.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblName);
        
        tfName = new JTextField();
        tfName.setBounds(200, 160, 150, 25);
        add(tfName);
        
        lblGender = new JLabel("Gender");
        lblGender.setBounds(35, 200, 100, 20);
        lblGender.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblGender);
        
        rbMale = new JRadioButton("Male");
        rbMale.setBounds(200, 200, 60, 25);
        rbMale.setBackground(Color.WHITE);
        add(rbMale);
        
        rbFemale = new JRadioButton("Female");
        rbFemale.setBounds(270, 200, 100, 25);
        rbFemale.setBackground(Color.WHITE);
        add(rbFemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMale);
        bg.add(rbFemale);
        
        lblCountry = new JLabel("Country");
        lblCountry.setBounds(35, 240, 100, 20);
        lblCountry.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblCountry);
        
        tfCountry = new JTextField();
        tfCountry.setBounds(200, 240, 150, 25);
        add(tfCountry);
        
        lblRoom = new JLabel("Allocated Room");
        lblRoom.setBounds(35, 280, 150, 20);
        lblRoom.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblRoom);
        
        cRoom = new Choice();
        cRoom.setBounds(200, 280, 150, 25);
        add(cRoom);
        //fetching the roomNumber data from 'room' table 
        try{
            Conn conn = new Conn();
            
            String query = "SELECT * FROM room WHERE availability = 'Available'";
            
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {                
                cRoom.add(rs.getString("roomNumber"));
            }
                  
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        lblCheckIn = new JLabel("Checkin Time");
        lblCheckIn.setBounds(35, 320, 150, 20);
        lblCheckIn.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblCheckIn);
        
        Date date  = new Date();

/* CREATING THE INDIAN STYLE DATE...        
        // create a LocalDate object representing the current date
        LocalDate today = LocalDate.now();

        // create a DateTimeFormatter object with the Indian date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("en-IN"));

        // format the date using the formatter
        String indianDate = today.format(formatter);
*/
               
        lblCheckInTime = new JLabel("" + date);
        lblCheckInTime.setBounds(200, 320, 150, 25);
        lblCheckInTime.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lblCheckInTime);
        
        lblDeposite = new JLabel("Deposite");
        lblDeposite.setBounds(35, 360, 100, 20);
        lblDeposite.setFont(new Font("Raleway", Font.PLAIN, 16));
        add(lblDeposite);
        
        tfDeposite = new JTextField();
        tfDeposite.setBounds(200, 360, 150, 25);
        add(tfDeposite);
        
        btnAdd = new JButton("Add");
        btnAdd.setBounds(35, 410, 140, 30);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(Color.BLACK);
        add(btnAdd);
        btnAdd.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(200, 410, 150, 30);
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.BLACK);
        add(btnBack);
        btnBack.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 300, 400);
        add(image);
        
        
        
        
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnAdd){
            
            String id = (String)cbId.getSelectedItem();
            String idNumber = tfNumber.getText();
            String name = tfName.getText();
            String gender = null;
            if(rbMale.isSelected()){
                gender = "Male";
            }
            else if(rbFemale.isSelected()){
                gender = "Female";
            }
            
            String country = tfCountry.getText();
            String roomNumber = cRoom.getSelectedItem();
            String checkedInTime = lblCheckInTime.getText();
            String deposite = tfDeposite.getText();
            
            //inserting the data into the 'customer' database
            try{
                Conn conn = new Conn();
                
                String queryForCustomerTable = "INSERT INTO customer VALUES('"+id+"', '"+idNumber+"', '"+name+"', '"+gender+"', '"+country+"', '"+roomNumber+"', '"+checkedInTime+"', '"+deposite+"')";
                
                String queryForRoomTable = "UPDATE room SET availability = 'Occupied' WHERE roomNumber = '"+roomNumber+"'";
                
                
                conn.s.executeUpdate(queryForCustomerTable);
                conn.s.executeUpdate(queryForRoomTable);
                
                JOptionPane.showMessageDialog(null, "Customer Inserted Successfully");
                
                setVisible(false);
                
                new Reception();
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        }
        else if(ae.getSource() == btnBack){
                
            setVisible(false);
                
            new Reception();
        }

    }
   
    
    
    public static void main(String[] args) {
        new AddCustomer();
    }

    
    
    
}
