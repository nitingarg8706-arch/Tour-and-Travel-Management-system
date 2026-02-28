package tour.and.travel.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tts","root","Nitin@00");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println("Database connection error: " + e.getMessage());
      
        }
        
    }
}
