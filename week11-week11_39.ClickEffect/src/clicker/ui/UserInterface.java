package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;

import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface (Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);

        JLabel valueText = new JLabel("0");
        JButton clickBtn = new JButton("Click!");
        clickBtn.addActionListener(new ClickListener(calculator, valueText));

        container.add(valueText, BorderLayout.CENTER);
        container.add(clickBtn, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}
