package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Reception extends JFrame implements ActionListener{
    
    private JButton newCustomer, rooms, department, 
            employees, customerDetails, 
            managerDetails,
            checkout, updateStatus,roomStatus,
            pickupService, searchRoom, logout;

    public Reception() {
        setLayout(null);
        setBounds(350, 200, 800, 570);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        
        newCustomer = new JButton("New Customer");
        newCustomer.setBounds(10, 30, 200, 30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        add(newCustomer);
        newCustomer.addActionListener(this);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10, 70, 200, 30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        add(rooms);
        rooms.addActionListener(this);
        
        department = new JButton("Departments");
        department.setBounds(10, 110, 200, 30);
        department.setBackground(Color.BLACK);
        department.setForeground(Color.WHITE);
        add(department);
        department.addActionListener(this);
        
        employees = new JButton("Employees Info");
        employees.setBounds(10, 150, 200, 30);
        employees.setBackground(Color.BLACK);
        employees.setForeground(Color.WHITE);
        add(employees);
        employees.addActionListener(this);
        
        customerDetails = new JButton("Customers Info");
        customerDetails.setBounds(10, 190, 200, 30);
        customerDetails.setBackground(Color.BLACK);
        customerDetails.setForeground(Color.WHITE);
        add(customerDetails);
        customerDetails.addActionListener(this);
        
        managerDetails = new JButton("Maneger Info");
        managerDetails.setBounds(10, 230, 200, 30);
        managerDetails.setBackground(Color.BLACK);
        managerDetails.setForeground(Color.WHITE);
        add(managerDetails);
        managerDetails.addActionListener(this);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10, 270, 200, 30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        add(checkout);
        checkout.addActionListener(this);
        
        updateStatus = new JButton("Update Status");
        updateStatus.setBounds(10, 310, 200, 30);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        add(updateStatus);
        updateStatus.addActionListener(this);
        
        roomStatus = new JButton("Update Room Status");
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.setBackground(Color.BLACK);
        roomStatus.setForeground(Color.WHITE);
        add(roomStatus);
        roomStatus.addActionListener(this);
        
        pickupService = new JButton("Pickup Service");
        pickupService.setBounds(10, 390, 200, 30);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        add(pickupService);
        pickupService.addActionListener(this);
        
        searchRoom = new JButton("Search Rooms");
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        add(searchRoom);
        searchRoom.addActionListener(this);
        
        logout = new JButton("Logout");
        logout.setBounds(10, 470, 200, 30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        add(logout);
        logout.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 470, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
              
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == newCustomer){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        }
        else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }
        else if(ae.getSource() == employees){
            setVisible(false);
            new EmployeeInfo();
        }
        else if(ae.getSource() == managerDetails){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == customerDetails){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource() == updateStatus){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource() == roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == pickupService){
            setVisible(false);
            new PickUp();
        }
        else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        }
        else if(ae.getSource() == logout){
            setVisible(false);
        }
    }
    
    
     public static void main(String[] args) {
        new Reception();
    }

    
}

