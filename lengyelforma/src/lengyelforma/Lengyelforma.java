/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lengyelforma;

import javax.swing.UIManager;

/**
 *
 * @author Suli
 */
public class Lengyelforma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		final View view = new View();
		view.setVisible(true);
    }
    
}
