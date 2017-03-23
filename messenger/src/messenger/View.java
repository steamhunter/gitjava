/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Suli
 */
public class View extends JFrame implements Listener {
 
    Model model;
    private final AbstractAction senderclick = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
           model.sendMessage(ipaddress.getText(), Integer.parseInt(port.getText()), msg.getText());
           textarea.append(msg.getText()+"\n");
           msg.setText("");
        }
    };
    JTextArea textarea;
     JTextField ipaddress;
     JTextField port;
     JTextField msg;
    public View(Model model) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        createStuff();
        this.model=model;
    }

    @Override
    public void messageReceived(String msg) {
        
        
        
        textarea.append(">"+msg+"\n");
         
    }

    @Override
    public void errorHappened(String msg) {
        
        
        
        textarea.append("hiba történt: "+msg+"\n");
         
    }

    private void createStuff() {
       textarea = new JTextArea(20, 60);
        Panel centerpanel = new Panel();
        BoxLayout centerbox = new BoxLayout(centerpanel, BoxLayout.X_AXIS);
        centerpanel.setLayout(centerbox);
        ipaddress = new JTextField();
        port = new JTextField();
        port.setText("8000");
        centerpanel.add(ipaddress);
        centerpanel.add(port);
        Panel downpanel = new Panel();
        BoxLayout downbox = new BoxLayout(downpanel, BoxLayout.X_AXIS);
        downpanel.setLayout(downbox);
        msg = new JTextField();
        downpanel.add(msg);
        JButton send = new JButton(senderclick);
        send.setText("küldés");
        downpanel.add(send);
        add(downpanel, BorderLayout.PAGE_END);
        add(textarea, BorderLayout.PAGE_START);
        add(centerpanel, BorderLayout.CENTER);
        this.setTitle("Messenger");
    }

}
