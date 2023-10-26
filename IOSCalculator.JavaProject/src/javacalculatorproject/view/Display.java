package javacalculatorproject.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javacalculatorproject.model.Memory;
import javacalculatorproject.model.MemoryObserver;

public class Display extends JPanel implements MemoryObserver {

    private JLabel label;

    public Display() {
        Memory.getInstance().addObserver(this);
        
        setBackground(new Color(46, 49, 50));
        label = new JLabel(Memory.getInstance().getCurrentText());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30));

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));
        add(label);
        
    }

    @Override
    public void changedValue(String newValue) {
        label.setText(newValue);
    }

}
