package tour.and.travel.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;
    public void run(){
        try{
            for(int i = 1; i <= 101; i++){
                int max = bar.getMaximum();//100
                int value = bar.getValue();
                
                if (value < max){ //101 < 100
                    bar.setValue(bar.getValue() + 1);
                }else{
                    setVisible(false);
                    // new class object
                    
                }
                Thread.sleep(70);
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username = username;
        t = new Thread(this);
        
        setBounds(500,200,640,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Travel Sphere");
        text.setBounds(50,25,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway", Font.BOLD, 45));
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading! please wait....");
        loading.setBounds(220,130,230,30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway", Font.BOLD, 16));
        add(loading);
        
        JLabel lblusername = new JLabel("Welcome "+username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(lblusername);
        
        t.start();
        setVisible(true);
        new Dashboard(username);
    }
    public static void main(String[]args){
        new Loading("");
    }
}
