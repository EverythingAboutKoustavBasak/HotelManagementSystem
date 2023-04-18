package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener{

    private JTextField tfname, tfage, tfcompany, tfmodel, tflocation;
    private JComboBox  cbavailable, cbgender;
    private JButton add, cancel;
    public AddDriver() {
        setLayout(null);
        setBounds(300, 200, 980, 470);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading = new JLabel("Add Drivers !");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);
        
        JLabel lblroomNo = new JLabel("Name");
        lblroomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomNo.setBounds(60, 70, 120, 30);
        add(lblroomNo);
        
        tfname = new JTextField();
        tfname.setBounds(200, 70, 150, 30);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 110, 120, 30);
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(200, 110, 150, 30);
        add(tfage);
        
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 150, 120, 30);
        add(lblgender);
        
        String genderOptions[] = {"Male", "Female"};
        cbgender = new JComboBox(genderOptions);
        cbgender.setBounds(200, 150, 150, 30);
        cbgender.setBackground(Color.white);
        add(cbgender);
        
        JLabel lblcompany = new JLabel("Car-Company");
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcompany.setBounds(60, 190, 120, 30);
        add(lblcompany);
        
        tfcompany = new JTextField();
        tfcompany.setBounds(200, 190, 150, 30);
        add(tfcompany);
        
        JLabel lblmodel = new JLabel("Car-Model");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblmodel.setBounds(60, 230, 120, 30);
        add(lblmodel);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 230, 150, 30);
        add(tfmodel);
        
        JLabel lblavailable = new JLabel("Availabilty");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 270, 120, 30);
        add(lblavailable);
        
        String availableOptions[] = {"Available", "Busy"};
        cbavailable = new JComboBox(availableOptions);
        cbavailable.setBounds(200, 270, 150, 30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);
        
        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60, 310, 120, 30);
        add(lbllocation);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 30);
        add(tflocation);
        
        add = new JButton("Add Driver");
        add.setBounds(60, 370, 130, 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add(add);
        add.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 370, 130, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        
        setVisible(true);
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== add){
            
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)cbgender.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String availablity = (String)cbavailable.getSelectedItem();
            String location = tflocation.getText();
            
            try{
               
                Conn conn = new Conn();
                
                String query = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+model+"', '"+availablity+"','"+location+"')";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully...");
                
                setVisible(false);
                
                
                
            }catch (Exception e){
                e.printStackTrace();
            }
            
            
        }
        else {
            setVisible(false);
        }
    }
    
     public static void main(String[] args) {
        new AddDriver();
    }
}
