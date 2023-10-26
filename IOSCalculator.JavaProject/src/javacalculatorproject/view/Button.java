package javacalculatorproject.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Button extends JButton {

    public Button(String text, Color color) {
        setText(text);
        setOpaque(true);
        setBackground(color);
        setFont(new Font("courrier", Font.PLAIN, 20));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(new Color(25, 26, 33)));

    }

}
