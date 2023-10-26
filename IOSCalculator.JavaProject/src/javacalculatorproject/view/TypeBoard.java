package javacalculatorproject.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class TypeBoard extends JPanel{
    
    private final Color DARKGRAY_COLOR = new Color(68, 68, 68);
    private final Color LIGHTGRAY_COLOR = new Color(99, 99, 99);
    private final Color ORANGE_COLOR = new Color(242, 163, 60);

    public TypeBoard() {

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        
        setLayout(layout);

        addButton("AC", DARKGRAY_COLOR, c, 0, 0);
        addButton("+/-", DARKGRAY_COLOR, c, 1, 0);
        addButton("%", DARKGRAY_COLOR, c, 2, 0);
        addButton("/", ORANGE_COLOR, c, 3, 0);

        addButton("7", LIGHTGRAY_COLOR, c, 0, 1);
        addButton("8", LIGHTGRAY_COLOR, c, 1, 1);
        addButton("9", LIGHTGRAY_COLOR, c, 2, 1);
        addButton("X", ORANGE_COLOR, c, 3, 1);

        addButton("4", LIGHTGRAY_COLOR, c, 0, 2);
        addButton("5", LIGHTGRAY_COLOR, c, 1, 2);
        addButton("6", LIGHTGRAY_COLOR, c, 2, 2);
        addButton("-", ORANGE_COLOR, c, 3, 2);

        addButton("1", LIGHTGRAY_COLOR, c, 0, 3);
        addButton("2", LIGHTGRAY_COLOR, c, 1, 3);
        addButton("3", LIGHTGRAY_COLOR, c, 2, 3);
        addButton("+", ORANGE_COLOR, c, 3, 3);

        addButton("0", LIGHTGRAY_COLOR, c, 0, 4);
        addButton("0", LIGHTGRAY_COLOR, c, 1, 4);
        addButton(",", LIGHTGRAY_COLOR, c, 2, 4);
        addButton("=", ORANGE_COLOR, c, 3, 4);

    }

        private void addButton(String text, Color color, GridBagConstraints c, int x, int y) {
            c.gridx = x;
            c.gridy = y;
            Button button = new Button(text, color);
            add(button, c);
        }

        
}
