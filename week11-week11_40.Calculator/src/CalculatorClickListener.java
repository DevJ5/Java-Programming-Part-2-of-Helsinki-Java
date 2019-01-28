import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorClickListener implements ActionListener {
    private Calculator calculator;
    private JTextField inputText;
    private JTextField outputText;
    private JButton sumBtn;
    private JButton subtractBtn;
    private JButton resetBtn;

    public CalculatorClickListener(Calculator calculator, JTextField inputText, JTextField outputText, JButton sumBtn,
                                   JButton subtractBtn, JButton resetBtn) {
        this.calculator = calculator;
        this.inputText = inputText;
        this.outputText = outputText;
        this.sumBtn = sumBtn;
        this.subtractBtn = subtractBtn;
        this.resetBtn = resetBtn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sumBtn) handleSum();
        else if (ae.getSource() == subtractBtn) handleSubtract();
        else if (ae.getSource() == resetBtn) handleReset();
    }

    public void handleSum() {
        try {
            calculator.add(Integer.parseInt(inputText.getText()));
            setOutputText();
            resetBtn.setEnabled(true);
        } catch (Exception e) {

        }
        clearInput();
    }

    public void handleSubtract() {
        try {
            calculator.subtract(Integer.parseInt(inputText.getText()));
            setOutputText();
            resetBtn.setEnabled(true);
        } catch (Exception e) {

        }
        clearInput();
    }

    public void handleReset() {
        calculator.reset();
        clearInput();
        setOutputText();
        resetBtn.setEnabled(false);
    }

    public void clearInput () {
        inputText.setText("");
    }

    public void setOutputText() {
        outputText.setText("" + calculator.getValue());
    }
}
