import java.awt.*;
import javax.swing.*;

public class GraphicCalculator implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public GraphicCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 150));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3,1);
        container.setLayout(layout);
        JTextField outputText = new JTextField("0");
        outputText.setEnabled(false);
        JTextField inputText = new JTextField();

        container.add(outputText);
        container.add(inputText);
        container.add(createPanel(inputText, outputText));
    }

    private JPanel createPanel(JTextField inputText, JTextField outputText) {
        JPanel panel = new JPanel(new GridLayout(1,3));

        JButton sumBtn = new JButton("+");
        panel.add(sumBtn);

        JButton subtractBtn = new JButton("-");
        panel.add(subtractBtn);

        JButton resetBtn = new JButton("Z");
        panel.add(resetBtn);

        CalculatorClickListener clickListener = new CalculatorClickListener(calculator, inputText, outputText, sumBtn, subtractBtn, resetBtn);

        sumBtn.addActionListener(clickListener);
        subtractBtn.addActionListener(clickListener);
        resetBtn.addActionListener(clickListener);

        resetBtn.setEnabled(false);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
