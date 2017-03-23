/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

/**
 *
 * @author Suli
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Model model = new Model();
        final View view = new View(model);
        model.setListener(view);
        model.startListening();
        view.setVisible(true);
    }

}
