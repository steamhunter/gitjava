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
public interface Listener {

    void messageReceived(final String msg);

    void errorHappened(final String msg);
}
