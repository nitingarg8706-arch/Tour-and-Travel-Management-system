package tour.and.travel.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel,cac,cfood;
    JTextField tfperson,tfdays;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,back,book;
    
    
    BookHotel(String username){
        
        this.username= username;
        setBounds(250,100,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text= new JLabel("BOOK HOTEL");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(text);
        
        JLabel lblusername =new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblusername.setBounds(40,50,100,20);
        add(lblusername);
        
        labelusername =new JLabel();
        labelusername.setFont(new Font("Tahoma",Font.PLAIN, 16));
        labelusername.setBounds(250,50,200,20);
        add(labelusername);
        
        JLabel lblpackage =new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblpackage.setBounds(40,90,150,20);
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(250,90,200,20);
        add(chotel);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblperson =new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblperson.setBounds(40,130,150,20);
        add(lblperson);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(250,130,200,25);
        add(tfperson);
        
        JLabel lbldays =new JLabel("No. of Days");
        lbldays.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lbldays.setBounds(40,170,150,20);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(250,170,200,25);
        add(tfdays);
        
        JLabel lblac =new JLabel("AC/NON AC");
        lblac.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblac.setBounds(40,210,150,20);
        add(lblac);
        
        cac = new Choice();
        cac.add("AC");
        cac.add("NON AC");
        cac.setBounds(250,210,200,20);
        add(cac);
        
        JLabel lblfood =new JLabel("FOOD INCLUDED");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblfood.setBounds(40,250,150,20);
        add(lblfood);
        
        cfood = new Choice();
        cfood.add("YES");
        cfood.add("NO");
        cfood.setBounds(250,250,200,20);
        add(cfood);
        
        
        
        JLabel lblid =new JLabel("Id");
        lblid.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblid.setBounds(40,290,150,20);
        add(lblid);
        
        labelid =new JLabel();
        labelid.setBounds(250,290,200,25);
        add(labelid);
        
        JLabel lblnumber =new JLabel("Number");
        lblnumber.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblnumber.setBounds(40,330,150,25);
        add(lblnumber);
        
        labelnumber =new JLabel();
        labelnumber.setBounds(250,330,150,25);
        add(labelnumber);
        
        JLabel lblphone =new JLabel("Phone");
        lblphone.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lblphone.setBounds(40,370,150,25);
        add(lblphone);
        
        labelphone =new JLabel();
        labelphone.setBounds(250,370,150,25);
        add(labelphone);
        
        JLabel lbltotal =new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahoma",Font.PLAIN, 16));
        lbltotal.setBounds(40,410,150,25);
        add(lbltotal);
        
        labelprice =new JLabel();
        labelprice.setBounds(250,410,150,25);
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
        checkprice.setBounds(60,480,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        book= new JButton("Book Package");
        book.setBackground(Color.black);
        book.setForeground(Color.white);
        book.setBounds(200,480,120,25);
        book.addActionListener(this);
        add(book);
        
        back= new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,480,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel (i3);
        l12.setBounds(500,50,600,300);
        add(l12);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    int food = Integer.parseInt(rs.getString("foodinclude"));
                    
                    int person = Integer.parseInt(tfperson.getText());
                    int days= Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if(person * days> 0 ){
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("YES") ? food : 0;
                        total +=cost;
                        total = total * person * days;
                        labelprice.setText("Rs " +total);
                                
                    }else{
                        JOptionPane.showMessageDialog(null,"Please enter a valid number");
                    }
            }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == book){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
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
        new BookHotel("nitin00");

}
}