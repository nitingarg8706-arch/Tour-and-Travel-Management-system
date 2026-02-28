package tour.and.travel.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    String username;
    JButton addPersonalDetails, viewPersonalDetails,updatePersonalDetails,checkpackages ,bookpackage, viewpackage,viewhotel , destination,bookhotel,viewbookhotel,payments,about,deletePersonalDetails ;
    Dashboard(String username){
        this.username = username;
        //setBounds(0,0,1366,768);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1366,65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
                
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,30));// to move left te button
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));// to move left te button
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Personal Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,30));// to move left te button
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,30));// to move left te button
        deletePersonalDetails .addActionListener(this);
        p2.add(deletePersonalDetails);
        
        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,30));// to move left te button
        checkpackages .addActionListener(this);
        p2.add(checkpackages);

        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.white);
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackage.setMargin(new Insets(0,0,0,30));// to move left te button
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        viewpackage = new JButton("View Package");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(new Color(0,0,102));
        viewpackage.setForeground(Color.white);
        viewpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage.setMargin(new Insets(0,0,0,30));// to move left te button
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        viewhotel = new JButton("View Hotel");
        viewhotel.setBounds(0,350,300,50);
        viewhotel.setBackground(new Color(0,0,102));
        viewhotel.setForeground(Color.white);
        viewhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotel.setMargin(new Insets(0,0,0,30));// to move left te button
        viewhotel.addActionListener(this);
        p2.add(viewhotel);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,30));// to move left te button
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        viewbookhotel = new JButton(" View Book Hotel");
        viewbookhotel.setBounds(0,450,300,50);
        viewbookhotel.setBackground(new Color(0,0,102));
        viewbookhotel.setForeground(Color.white);
        viewbookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookhotel.setMargin(new Insets(0,0,0,30));// to move left te button
        viewbookhotel.addActionListener(this);
        p2.add(viewbookhotel);
        
        destination = new JButton(" Destination");
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.white);
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,30));// to move left te button
        destination.addActionListener(this);
        p2.add(destination);
        
        payments = new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,30));// to move left te button
        payments.addActionListener(this);
        p2.add(payments);


        about = new JButton("About");
        about.setBounds(0,600,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,30));// to move left te button
        about.addActionListener(this);
        p2.add(about);          
        
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel image = new JLabel(i6);
       image.setBounds(0,0,1650,1000);
       add(image);
       
       JLabel text = new JLabel("Travel Sphere");
       text.setBounds(400,70,1200,70);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("Raleway",Font.PLAIN,60));
       image.add(text);
              
        
        
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){    //function override
        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
            
        }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }else if (ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == checkpackages ){
            new CheckPackages();
        }else if (ae.getSource() == bookpackage){
            new BookPackage(username);
        }else if(ae.getSource() == viewpackage){
            new ViewPackage(username);
        }else if(ae.getSource() == viewhotel){
            new CheckHotels();
        }else if(ae.getSource() == destination){
            new Destination();
       }else if(ae.getSource() == bookhotel){
           new BookHotel(username);
       }else if(ae.getSource() == viewbookhotel){
           new ViewBookHotel(username);
       }else if(ae.getSource() == payments){
           new Payment();
       }else if(ae.getSource() == about){
           new About();
       }else if(ae.getSource() == deletePersonalDetails ){
           new DeleteDetails(username);
       }
    
    }
    public static void main(String[] args){
        new Dashboard("");
    }
}
