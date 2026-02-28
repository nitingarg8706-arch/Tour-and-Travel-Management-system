package tour.and.travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {
    About(){
        setBounds(600,100,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("ABOUT");
        l1.setBounds(200,10,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN , 20));
        add(l1);
        
        String s = "About Projects          \n"+
                "\n  "+
                "The objective of the Travel and Tourism Management Systemproject is to develop a system that automates the processes and activibes of a travel and the purpose is to design a system using which one can perform all operations related to traveling.\n"+
                "\n"+
                "This application will help in accessing the information related to the travel to the particular destination with great ease. The users can track the information related to their tours with great ease through thes application. The travel agency information can also be obtained through this application\n"+
                "\n"+
                "Advantages of Project\n"+
                "Gives accurate information\n"+
                "Simplifies the manual work\n"+
                "minimizes the documentation related work\n"+
                "Provides up to date information\n"+
                "Friendly Environment by providing warming messages\n"+
                "traveler's details can be provided\n"+
                "booking confirmation notification\n"+
                "\n"+
                "\n";
                
                
        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
        new About();
    }
}
