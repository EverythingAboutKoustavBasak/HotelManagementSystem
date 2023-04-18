
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


public class EmployeeInfo extends JFrame implements ActionListener{

    private JLabel lblName, lblAge, lblGender,
            lblJob, lblSalary, lblPhone, lblEmail, lblAadhar;
    private JTable table;
    private JButton btnBack;
    
    public EmployeeInfo() {
        setLayout(null);
        setBounds(300, 200, 1000, 600);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setResizable(false);
        
       
        
        lblName = new JLabel("Name");
        lblName.setBounds(20, 10, 100, 20);
        lblName.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblName);
        
        lblAge = new JLabel("Age");
        lblAge.setBounds(170, 10, 100, 20);
        lblAge.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblAge);
        
        lblGender = new JLabel("Gender");
        lblGender.setBounds(290, 10, 100, 20);
        lblGender.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblGender);
        
        lblJob = new JLabel("Job-Post");
        lblJob.setBounds(400, 10, 100, 20);
        lblJob.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblJob);
        
        lblSalary = new JLabel("Salary");
        lblSalary.setBounds(540, 10, 100, 20);
        lblSalary.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblSalary);
        
        lblPhone = new JLabel("Phone-No");
        lblPhone.setBounds(670, 10, 100, 20);
        lblPhone.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblPhone);
        
        lblEmail = new JLabel("Email-Id");
        lblEmail.setBounds(790, 10, 100, 20);
        lblEmail.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblEmail);
        
        lblAadhar = new JLabel("Aadhar-No");
        lblAadhar.setBounds(910, 10, 100, 20);
        lblAadhar.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblAadhar);
        
        
        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        
        //fetching the values from 'employee' database
        try{
           Conn conn = new Conn();
           
           String query = "SELECT * FROM employee";
           
           ResultSet rs = conn.s.executeQuery(query);
           
           //by using the re2xml.jar 
           //we are fetching all the data from the 'employee' table and put all the data into the table
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
        new EmployeeInfo();
    }

   

    
}
