
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


public class AddRooms extends JFrame implements ActionListener{

    private JTextField tfroom, tfprice;
    private JComboBox cbbed, cbavailable, cbclean;
    private JButton add, cancel;
    public AddRooms() {
        setLayout(null);
        setBounds(330, 200, 940, 470);
        setLocationRelativeTo(null);
        setResizable(false);    // Frame Non-Resizable
        
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel heading = new JLabel("Add Rooms !");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblroomNo = new JLabel("Room Number");
        lblroomNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblroomNo.setBounds(60, 80, 120, 30);
        add(lblroomNo);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 80, 150, 30);
        add(tfroom);
        
        JLabel lblavailable = new JLabel("Availability");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 130, 120, 30);
        add(lblavailable);
        
        String availableOptions[] = {"Available", "Occupied"};
        cbavailable = new JComboBox(availableOptions);
        cbavailable.setBounds(200, 130, 150, 30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);
        
        
        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 120, 30);
        add(lblclean);
        
        String cleanOptions[] = {"Clean", "Dirty"};
        cbclean = new JComboBox(cleanOptions);
        cbclean.setBounds(200, 180, 150, 30);
        cbclean.setBackground(Color.white);
        add(cbclean);
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 120, 30);
        add(lblprice);
        
        tfprice = new JTextField();
        tfprice.setBounds(200, 230, 150, 30);
        add(tfprice);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblbed.setBounds(60, 280, 120, 30);
        add(lblbed);
        
        String bedOptions[] = {"Single-Bed", "Double-Bed"};
        cbbed = new JComboBox(bedOptions);
        cbbed.setBounds(200, 280, 150, 30);
        cbbed.setBackground(Color.white);
        add(cbbed);
        
        add = new JButton("Add Room");
        add.setBounds(60, 350, 130, 30);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add(add);
        add.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 350, 130, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        add(cancel);
        cancel.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
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
            
            String roomNumber = tfroom.getText();
            String availablity = (String)cbavailable.getSelectedItem();
            String cleaningStatus = (String)cbclean.getSelectedItem();
            String price = tfprice.getText();
            String bedType = (String)cbbed.getSelectedItem();
            
            try{
               
                Conn conn = new Conn();
                
                String query = "INSERT INTO room values( '"+roomNumber+"', '"+availablity+"', '"+cleaningStatus+"','"+price+"', '"+bedType+"')";
                
                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "New Room Added Successfully...");
                
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
        new AddRooms();
    }

   
}
