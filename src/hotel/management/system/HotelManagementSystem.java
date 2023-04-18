package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class HotelManagementSystem extends JFrame implements ActionListener{

    public HotelManagementSystem() {
//        setSize(1366, 565);
//        setLocation(10, 100);
        setBounds(10, 100, 1366, 565);
        setResizable(false);    // Frame Non-Resizable
        setLocationRelativeTo(null); //display the JFrame to center position of a screen
        
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20, 430, 1000, 90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,30));
        image.add(text);
        
        JButton next = new JButton("Next");
        next.setBounds(1190, 450, 100, 50);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("serif",Font.PLAIN,20));
        image.add(next);
        next.addActionListener(this);
          
               
        
        setVisible(true);
        
        //depering the text "HOTLEL MANAGEMENT SYSTEM"
        while(true){
                        text.setVisible(false); 
                    try{
                        Thread.sleep(700); //1000 = 1 second
                    }catch(Exception e){
                        e.printStackTrace();
                    } 
                        text.setVisible(true);
                    try{
                        Thread.sleep(700);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
       new HotelManagementSystem();
    }

    
    
}
