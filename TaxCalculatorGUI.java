import javax.swing.*;
import java.awt.event.*;

public class TaxCalculatorGUI extends JFrame implements ActionListener {

    JLabel label;
    JTextField incomeField;
    JButton calculateBtn, resetBtn; //  reset button add
    JLabel resultLabel;

    TaxCalculatorGUI() {
        setTitle("Tax Calculator");

        label = new JLabel("Enter Annual Income:");
        label.setBounds(50, 50, 200, 30);

        incomeField = new JTextField();
        incomeField.setBounds(200, 50, 150, 30);

        calculateBtn = new JButton("Calculate Tax");
        calculateBtn.setBounds(50, 100, 150, 30);

        resetBtn = new JButton("Reset"); // ✅ new button
        resetBtn.setBounds(220, 100, 100, 30);

        resultLabel = new JLabel("Tax: ");
        resultLabel.setBounds(50, 150, 300, 30);

        calculateBtn.addActionListener(this);
        resetBtn.addActionListener(this); // ✅ action add

        add(label);
        add(incomeField);
        add(calculateBtn);
        add(resetBtn); // ✅ add to frame
        add(resultLabel);

        setSize(400, 300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // 🔹 Calculate Button Logic
        if (e.getSource() == calculateBtn) {
            try {
                double income = Double.parseDouble(incomeField.getText());
                double tax = 0;

                if (income <= 250000) {
                    tax = 0;
                } 
                else if (income <= 500000) {
                    tax = (income - 250000) * 0.05;
                } 
                else if (income <= 1000000) {
                    tax = (250000 * 0.05) + (income - 500000) * 0.10;
                } 
                else {
                    tax = (250000 * 0.05) + (500000 * 0.10) + (income - 1000000) * 0.20;
                }

                resultLabel.setText("Tax: ₹ " + tax);

            } catch (Exception ex) {
                resultLabel.setText("Invalid Input!");
            }
        }

        // 🔥 Reset Button Logic
        if (e.getSource() == resetBtn) {
            incomeField.setText("");
            resultLabel.setText("Tax: ");
        }
    }

    public static void main(String[] args) {
        new TaxCalculatorGUI();
    }
}