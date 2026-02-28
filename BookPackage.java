package tour.and.travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfperson;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,back,book;
    
    
    BookPackage(String username){
        
        this.username= username;
        setBounds(350,200,1020,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text= new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(text);
        
        JLabel lblusername =new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);
        
        labelusername =new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN, 16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);
        
        JLabel lblpackage =new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Bronze Package");
        cpackage.add("Silver Package");
        cpackage.add("Gold Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);
        
        
        
        JLabel lblperson =new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblperson.setBounds(40,150,150,20);
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);
        
        JLabel lblid =new JLabel("Id");
        lblid.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblid.setBounds(40,190,150,20);
        add(lblid);
        
        labelid =new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);
        
        JLabel lblnumber =new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);
        
        labelnumber =new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);
        
        JLabel lblphone =new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblphone.setBounds(40,270,150,25);
        add(lblphone);
        
        labelphone =new JLabel();
        labelphone.setBounds(250,270,150,25);
        add(labelphone);
        
        JLabel lbltotal =new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lbltotal.setBounds(40,310,150,25);
        add(lbltotal);
        
        labelprice =new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);
        
         try{
           Conn conn = new Conn();
           String query = "select * from customer where username = '"+username+"'";
           ResultSet rs = conn.s.executeQuery(query);
           while(rs.next()){
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("Id"));
               labelnumber.setText(rs.getString("Number"));
               labelphone.setText(rs.getString("Phone"));
              
                 }
                    
                    
        } catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice= new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        book= new JButton("Book Package");
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        book.setBounds(200,380,120,25);
        book.addActionListener(this);
        add(book);
        
        back= new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel (i3);
        l12.setBounds(550,50,500,300);
        add(l12);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if(pack.equals("Gold Package")){
                cost +=32000;
            }else if(pack.equals("Silver Package")){
                cost +=24000;
            }else{
                cost +=12000;
            }
            
            int person = Integer.parseInt(tfperson.getText());
            cost *= person;
            labelprice.setText("Rs" +cost);
        }else if(ae.getSource() == book){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new BookPackage("");
    }
}
