
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Dashboard extends JFrame implements ActionListener{

    JButton logout;
    public Dashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1500, 1000);
        add(image);
        
        JLabel text = new JLabel("WELCOME TO THE TAJ HOTEL");
        text.setBounds(400, 80, 1000, 50);
        text.setFont(new Font("Tahoma", Font.BOLD, 46));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        
        //Menu bar Created...
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        mb.setBackground(Color.YELLOW);
        image.add(mb);
        //inserting the menus...
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        //adding menu items...
        JMenuItem receptionist = new JMenuItem("RECEPTIONIST");
        hotel.add(receptionist);
        receptionist.addActionListener(this);
        
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);
        
        JMenuItem addEmployee = new JMenuItem("ADD EMPLOYEE");
        admin.add(addEmployee);
        addEmployee.addActionListener(this);
        
        JMenuItem addRoom = new JMenuItem("ADD ROOMS");
        admin.add(addRoom);
        addRoom.addActionListener(this);
        
        JMenuItem addDriver = new JMenuItem("ADD DRIVERS");
        admin.add(addDriver);
        addDriver.addActionListener(this);
        
        JMenu logout = new JMenu("LOGOUT");
        logout.setForeground(Color.RED);
        mb.add(logout);
        
        JMenuItem wantsToLogout = new JMenuItem("Wants to Logout");
        logout.add(wantsToLogout);
        wantsToLogout .addActionListener(this);
        
//        logout = new JButton("Logout");
//        logout.setForeground(Color.BLACK);
//        logout.setBackground(Color.WHITE);
//        logout.setBounds(1200, 40, 100, 30);
//        add(logout);
//        logout.addActionListener(this);
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("ADD EMPLOYEE")){
            new AddEmployee();
                    
        }
        else if(ae.getActionCommand().equals("ADD ROOMS")){
            new AddRooms();
                    
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS")){
            new AddDriver();
                    
        }
        else if(ae.getActionCommand().equals("RECEPTIONIST")){
            new Reception();
                    
        }
        else if(ae.getActionCommand().equals("RECEPTIONIST")){
            new Reception();
                    
        }
        else if(ae.getActionCommand().equals("Wants to Logout")){
            setVisible(false);
            System.exit(0);
                    
        }
//        else if(ae.getSource()==logout)){
//            setVisible(false);
//        }

    }
    
    
    
    public static void main(String[] args) {
       new Dashboard();
    }

    
}
