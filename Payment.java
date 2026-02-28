package tour.and.travel.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Payment extends JFrame implements ActionListener {

    JTextField nameField, cardNumberField, expiryField, cvvField, amountField;
    JButton payBtn, cancelBtn;

    Payment() {
        setTitle("Payment Portal");
        setBounds(500, 200, 400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel heading = new JLabel("Payment Gateway");
        heading.setFont(new Font("Tahoma", Font.BOLD, 22));
        heading.setBounds(90, 20, 250, 30);
        add(heading);

        JLabel name = new JLabel("Card Holder Name:");
        name.setBounds(50, 80, 150, 25);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(200, 80, 130, 25);
        add(nameField);

        JLabel cardNumber = new JLabel("Card Number:");
        cardNumber.setBounds(50, 120, 150, 25);
        add(cardNumber);

        cardNumberField = new JTextField();
        cardNumberField.setBounds(200, 120, 130, 25);
        add(cardNumberField);

        JLabel expiry = new JLabel("Expiry Date (MM/YY):");
        expiry.setBounds(50, 160, 150, 25);
        add(expiry);

        expiryField = new JTextField();
        expiryField.setBounds(200, 160, 130, 25);
        add(expiryField);

        JLabel cvv = new JLabel("CVV:");
        cvv.setBounds(50, 200, 150, 25);
        add(cvv);

        cvvField = new JTextField();
        cvvField.setBounds(200, 200, 130, 25);
        add(cvvField);

        JLabel amount = new JLabel("Amount (₹):");
        amount.setBounds(50, 240, 150, 25);
        add(amount);

        amountField = new JTextField();
        amountField.setBounds(200, 240, 130, 25);
        add(amountField);

        payBtn = new JButton("Pay Now");
        payBtn.setBounds(70, 300, 100, 30);
        payBtn.addActionListener(this);
        add(payBtn);

        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(200, 300, 100, 30);
        cancelBtn.addActionListener(this);
        add(cancelBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == payBtn) {
            String name = nameField.getText().trim();
            String card = cardNumberField.getText().trim();
            String expiry = expiryField.getText().trim();
            String cvv = cvvField.getText().trim();
            String amount = amountField.getText().trim();

            if (name.isEmpty() || card.isEmpty() || expiry.isEmpty() || cvv.isEmpty() || amount.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields!");
                return;
            }

            if (!card.matches("\\d{16}")) {
                JOptionPane.showMessageDialog(null, "Card number Invalid!");
                return;
            }

            if (!cvv.matches("\\d{3}")) {
                JOptionPane.showMessageDialog(null, "CVV Invalid!");
                return;
            }

            if (!isValidExpiryDate(expiry)) {
                JOptionPane.showMessageDialog(null, "Invalid or expired expiry date!");
                return;
            }

            JOptionPane.showMessageDialog(null,
                    "Payment of ₹" + amount + " successful!\nThank you, " + name + "!");
            dispose();

        } else if (ae.getSource() == cancelBtn) {
            dispose();
        }
    }

    private boolean isValidExpiryDate(String expiry) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            YearMonth enteredDate = YearMonth.parse(expiry, formatter);
            YearMonth currentDate = YearMonth.now();
            return !enteredDate.isBefore(currentDate);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        new Payment();
    }
}
