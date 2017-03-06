/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lengyelforma;

import java.awt.BorderLayout;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Suli
 */
public class View extends JFrame {

    private final AbstractAction buttonClick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            final JButton button = (JButton) e.getSource();

        }
    };

    JTextField expr;

    public View() {
        super("Ablakom");
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(600, 400);
        createStuff();
    }

    private void createStuff() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        JButton button1 = new JButton(buttonClick);
        button1.setText("kiszámít");
        button1.setAlignmentX(CENTER_ALIGNMENT);
        expr = new JTextField(20);
        panel.add(expr);
        panel.add(button1);
        add(panel, BorderLayout.PAGE_START);
        String kif="( 2 + 3 ) * 4 ";
        Scanner sc= new Scanner(kif);
        ArrayList<String> tokens= new ArrayList<>();
        while(sc.hasNext())
        {
            tokens.add(sc.next());
        }
        System.out.println(PolishNotation.to(tokens));
    }

}
