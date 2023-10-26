package javacalculatorproject.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.border.Border;

public class Calculator extends JFrame {

    

    public Calculator() {

        layoutOrganizer();

        setSize(232, 322);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void layoutOrganizer() {
        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(233, 60));
        add(display, BorderLayout.NORTH);

        TypeBoard typeBoard = new TypeBoard();
        add(typeBoard, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new Calculator();
    }
    
}
