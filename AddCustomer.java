package tour.and.travel.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.regex.*;

public class AddCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname, labelgender, labelcountry, labeladdress;
    JComboBox comboid;
    JTextField tfnumber, tfaddress, tfcountry, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add, back;

    AddCustomer(String username) {
        setBounds(450, 150, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        comboid = new JComboBox(new String[]{"Passport", "Aadhar card", "Pan Card", "Voter card"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 290, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 330, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 330, 150, 25);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 370, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 370, 150, 25);
        add(tfphone);

        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 450, 420);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username ='" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    // -------------------------- VALIDATION --------------------------

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

    private boolean isValidId(String idType, String idNumber) {
        switch (idType) {
            case "Aadhar card":
                // 12 digits only
                return idNumber.matches("\\d{12}");
            case "Pan Card":
                // 5 letters + 4 digits + 1 letter (e.g., ABCDE1234F)
                return idNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
            case "Passport":
                // 8 alphanumeric, often starts with a letter (e.g., A1234567)
                return idNumber.matches("[A-Z]{1}[0-9]{7}");
            case "Voter card":
                // 3 letters + 7 digits (e.g., ABC1234567)
                return idNumber.matches("[A-Z]{3}[0-9]{7}");
            default:
                return false;
        }
    }
    // ----------------------------------------------------------------

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText().trim();
            String name = labelname.getText();
            String gender = rmale.isSelected() ? "Male" : (rfemale.isSelected() ? "Female" : "");
            String country = tfcountry.getText().trim();
            String address = tfaddress.getText().trim();
            String phone = tfphone.getText().trim();
            String email = tfemail.getText().trim();

            // ----------- FIELD CHECKS -----------
            if (username.isEmpty() || number.isEmpty() || name.isEmpty() || gender.isEmpty() ||
                country.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields before submitting.");
                return;
            }

            if (!isValidId(id, number)) {
                JOptionPane.showMessageDialog(null, "Invalid " + id + " format. Please check and try again.");
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(null, "Invalid email format. Example: name@example.com");
                return;
            }

            if (!isValidPhone(phone)) {
                JOptionPane.showMessageDialog(null, "Invalid phone number. Enter 10 digits only.");
                return;
            }
            // ------------------------------------

            try {
                Conn c = new Conn();
                String query = "insert into customer values('" + username + "','" + id + "','" + number + "','" +
                               name + "','" + gender + "','" + country + "','" + address + "','" + phone + "','" + email + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Details Added Successfully!");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("");
    }
}
