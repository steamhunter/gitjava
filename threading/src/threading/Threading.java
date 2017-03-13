/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threading;

import java.util.LinkedList;

/**
 *
 * @author Suli
 */

class MyList
{
    LinkedList<Integer> list=new LinkedList<>();
    
    public synchronized void add(int item)
    {
        list.add(item);
    }
    public synchronized void removeFirst()
    {
        list.removeFirst();
    }
}
 class Thread1 extends Thread {
        MyList lista;
        public Thread1(MyList list) {
            this.lista=list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 200; i++) {
                lista.add(i);
                lista.removeFirst();
            }
        }

        private void mySleep(final int msec) {
            try {
                Thread.sleep(msec);
            } catch (InterruptedException ex) {
            }
        }

    }
public class Threading {

   
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     MyList lista=new MyList();
     Thread1 t1 = new Thread1(lista);
     Thread1 t2 = new Thread1(lista);
        t1.start();
        t2.start();
    }

}
