/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messenger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 *
 * @author Suli
 */
public class Model {

    public Model() {
        
    }

    Listener listener;
    DatagramSocket socket;
    public void setListener(final Listener listener) {
        this.listener = listener;
    }

    public void sendMessage(final String address, final int port, final String msg) {

        try {
            if (socket == null) {
                socket = new DatagramSocket(8001);
            }

            InetSocketAddress saddress = new InetSocketAddress(address, port);

            byte message[] = msg.getBytes();

            DatagramPacket packet = new DatagramPacket(message, message.length, saddress);

            socket.send(packet);
        } catch (Exception e) {
            listener.errorHappened(e.getMessage());
        }

    }

    public void startListening() {

        new Thread(new JustRun()).start();
    }

    class JustRun implements Runnable
    {
        @Override
        public void run()
        {
            try {
            DatagramSocket socket = new DatagramSocket(8000);

            byte buffer[] = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while(true)
            {
            socket.receive(packet);

            String message = new String(packet.getData(), 0, packet.getLength());

            listener.messageReceived(message);
            }
        } catch (Exception e) {
            listener.errorHappened(e.getMessage());
        }
        }
    }
}
