import javax.swing.*;
import java.awt.*;

public class calc {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "=", "C", "+"
        };

        final double[] firstNumber = {0};
        final String[] operation = {""};

        for (String text : buttons) {
            JButton button = new JButton(text);

            button.addActionListener(e -> {
                String value = button.getText();

                if (value.equals("C")) {
                    display.setText("");
                    firstNumber[0] = 0;
                    operation[0] = "";
                }
                else if (value.equals("+") || value.equals("-") ||
                         value.equals("*") || value.equals("/")) {

                    if (!display.getText().isEmpty()) {
                        firstNumber[0] = Double.parseDouble(display.getText());
                        operation[0] = value;
                        display.setText("");
                    }
                }
                else if (value.equals("=")) {

                    if (!display.getText().isEmpty() && !operation[0].isEmpty()) {
                        double secondNumber = Double.parseDouble(display.getText());
                        double result = 0;

                        switch (operation[0]) {
                            case "+" -> result = firstNumber[0] + secondNumber;
                            case "-" -> result = firstNumber[0] - secondNumber;
                            case "*" -> result = firstNumber[0] * secondNumber;
                            case "/" -> {
                                if (secondNumber == 0) {
                                    display.setText("Error");
                                    return;
                                }
                                result = firstNumber[0] / secondNumber;
                            }
                        }

                        display.setText(String.valueOf(result));
                        operation[0] = "";
                    }
                }
                else {
                    display.setText(display.getText() + value);
                }
            });

            panel.add(button);
        }

        frame.setLayout(new BorderLayout(5, 5));
        frame.add(display, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}