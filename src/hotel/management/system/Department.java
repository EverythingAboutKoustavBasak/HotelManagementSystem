
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


public class Department extends JFrame implements ActionListener{

    private JLabel lblDepartment, lblBudget;
    private JTable table;
    private JButton btnBack;
    
    public Department() {
        setLayout(null);
        setBounds(400, 200, 700, 480);
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setResizable(false);
        
//        
        
        lblDepartment = new JLabel("Departments");
        lblDepartment.setBounds(180, 10, 100, 20);
        lblDepartment.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblDepartment);
        
        lblBudget = new JLabel("Budget");
        lblBudget.setBounds(420, 10, 100, 20);
        lblBudget.setFont(new Font("Raleway", Font.BOLD, 12));
        add(lblBudget);
        
//        
        
        table = new JTable();
        table.setBounds(0, 50, 700, 350);
        add(table);
        
        //fetching the values from 'department' database
        try{
           Conn conn = new Conn();
           
           String query = "SELECT * FROM department";
           
           ResultSet rs = conn.s.executeQuery(query);
           
           //by using the re2xml.jar 
           //we are fetching all the data from the 'department' table and put all the data into the table
           table.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        btnBack = new JButton("Back");
        btnBack.setBounds(280, 400, 120, 30);
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
        new Department();
    }

   

    
}
